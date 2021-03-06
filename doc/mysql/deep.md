1. view: a virtual table defining a process to get data
```
create or replace view employee_view as
select *
from employee emp, department dep
where ...
```

2. index
```
create index name_idx on employee(name);
```

3. full text index are created on text-based columns (CHAR, VARCHAR, or TEXT columns) to help speed up queries and DML operations on data contained within those columns
```
# create fulltext index, a set of index tables are created
CREATE TABLE opening_lines (
       id INT UNSIGNED AUTO_INCREMENT NOT NULL PRIMARY KEY,
       opening_line TEXT(500),
       author VARCHAR(200),
       title VARCHAR(200),
       FULLTEXT idx (opening_line)
       ) ENGINE=InnoDB;
       
# check index tables
SELECT table_id, name, space from INFORMATION_SCHEMA.INNODB_SYS_TABLES WHERE name LIKE 'test/%';
+----------+----------------------------------------------------+-------+
| table_id | name                                               | space |
+----------+----------------------------------------------------+-------+
|      333 | test/FTS_0000000000000147_00000000000001c9_INDEX_1 |   289 |
|      334 | test/FTS_0000000000000147_00000000000001c9_INDEX_2 |   290 |
|      335 | test/FTS_0000000000000147_00000000000001c9_INDEX_3 |   291 |
|      336 | test/FTS_0000000000000147_00000000000001c9_INDEX_4 |   292 |
|      337 | test/FTS_0000000000000147_00000000000001c9_INDEX_5 |   293 |
|      338 | test/FTS_0000000000000147_00000000000001c9_INDEX_6 |   294 |
|      330 | test/FTS_0000000000000147_BEING_DELETED            |   286 |
|      331 | test/FTS_0000000000000147_BEING_DELETED_CACHE      |   287 |
|      332 | test/FTS_0000000000000147_CONFIG                   |   288 |
|      328 | test/FTS_0000000000000147_DELETED                  |   284 |
|      329 | test/FTS_0000000000000147_DELETED_CACHE            |   285 |
|      327 | test/opening_lines                                 |   283 |
+----------+----------------------------------------------------+-------+
```
- inverted index start with **FTS_** and end with **INDEX_**

4. heap table
```
# create heap table
create table heap_table_demo engine=memory select * from employee;
```
- definition of heap table is in disk with extention **.frm**
- data of heap table is in memory, will lost if mysql instance dies
- heap table doesn't support columns of type blob and text
- if restart mysql, primary key and index are still there, only data is lost
- heap table is shared among different sessions
- heap table won't support transaction and is table level lock

5. a transaction is a set of separate actions that must all be completely processed, or none processed at all.
- Atomicity guarantees that each transaction is treated as a single "unit", which either succeeds completely, or fails completely
- Consistency ensures that a transaction can only bring the database from one valid state to another, maintaining database invariants: any data written to the database must be valid according to all defined rules. 
- Isolation ensures that concurrent execution of transactions leaves the database in the same state that would have been obtained if the transactions were executed sequentially
- Durability guarantees that once a transaction has been committed, it will remain committed even in the case of a system failure.

> note: mysql commit every sql by default in the current session, to disable this, **set autocommit=0**
```
# start a transaction
start transaction;
...
commit;

# roll back a transaction to undo all the uncommitted change
rollback;

# create a save point
savepoint point1;

# release a save point
release savepoint point1;

# roll back to point1
rollback to point1
```
6. isolation level:
- read uncommitted(dirty read): changes in a transaction is available even not committed
- read committed: any result from read is committed
- repeatable read: default isolation level for innodb, **consistent reads** within the same transaction read the snapshot elastablished by the first read.
- serializable: transaction commit serializably

> note: consistent reads, two transactions select from mysql begin with transaction, following operations are based on the snapshot of first select of each transaction.

- dirty read: read uncommited data
- phantom read: every time read results are not the same

7. InnoDB implements **shared** lock and **exclusive** lock.
- Transaction T1 holds a shared lock of row r, requests from T2 for lock on r will be granted immediately, both T1 and T2 hold the lock. requests from T2 for exclusive lock will not be granted immediately.
- Transaction T1 holds a exclusive lock on row r, any requests for share lock and exclusive lock would wait for release of lock from T1
```
# lock table
lock table my_table_name read;
lock table my_table_name write;
```
8. **Intention** locks are table-level locks that used to solve conflict of row lock and table lock.
- T1 get the shared lock of row r, means no other transactions are allowed to update row r.
- T2 get the exclusive lock of table t which contains r. Thus causing conflict.

note:
- intention locks including intention shared lock(IS) and intention exclusive lock(IX).
- intention locks are table level, but won't lock table, instead indicating transaction holding row level lock.
- when first get row lock, need first get intention lock.




