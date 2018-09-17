1. mysql structures
- connectors: interact with other languages
- management services and utilities: manage system and provide controller utilities
- connection pool: authentication, thread reuse, connection limits, check memory/caches
- sql interface: dml, ddl, stored procedures, views, triggers
- parser: parse/validate sql
- optimizer: optimize results of parser
- cache and buffer: if query hit, the item will be placed in cache(for read) and buffer(for write)
- engine: interact with native file system

2. query process in mysql:
- request reached connection pool and managed by management service and utilities
- request picked up from waiting queue and handle over to sql interface and get its hash result, if result in cache, return result
- if result not exists, request be handled to parser for validation and optimizer for optimized data structure
- optimized execution plan will be handled to engine finally to get data

> note: engine of mysql is pluggable, using InnoDB by default

- mysql will cache hash of query/result

3. difference between MyISAM and InnoDB
- InnoDB implements row-level lock while MyISAM table-level thus frequent reading, almost no writing, MyISAM is better, otherwise, InnoDB is better.
- MyISAM has full-text search indexes while InnoDB not util MySQL 5.6
- InnoDB implements transactions, foreign keys and relationship contraints while the other not

4. difference between heap table and temporary table
- heap table is present in the memory and need to specify **TYPE=HEAP** when creating
```
create table test type=heap (...)
```
- blob and text type coloumns are not allowed in heap table
- use indexes to make it faster
- temporary table exist in current client session, not shared in memory among sessions like heap table
