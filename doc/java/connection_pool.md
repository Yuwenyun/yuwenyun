1. jdbc process
- load driver: Class.forName("...");
- create connection: DriverManager.getConnection();
- execute sql
- process result
- close connection

2.
- Statement: handle ordinary query
- PreparedStatement: query with params, pre-compile, sql-insertion proof
- CallableStatement: execute procedure

3. mybatis data sources
- UnpooledDataSource/PooledDataSource -> java.sql.DataSource
- JndiDataSource

4. mybatis connection pool
- initialized when reading config file with <datasource> node
- connection created when executing sql
- getConnection(): check for idle connection, has no idle connection, then check for max connection number, not reach, then create new one. otherwise wait for a while.
- to make sure whenever connection.close() is called, return connection to pool, mybatis has a proxy for connection and use Proxy.newInstance() to invoke returning connection to pool
instead of closing it.

5. prevent sql insertion, mybatis use **#{variable}** to parse the value user give. **${columnName}** is not able to prevent insertion.
