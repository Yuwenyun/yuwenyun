mysql structures
- connectors: interact with other languages
- management services and utilities: manage system and provide controller utilities
- connection pool: authentication, thread reuse, connection limits, check memory/caches
- sql interface: dml, ddl, stored procedures, views, triggers
- parser: parse/validate sql
- optimizer: optimize results of parser
- cache and buffer: if query hit, the item will be placed in cache(for read) and buffer(for write)
- engine: interact with native file system

query process in mysql:
- request reached connection pool and managed by management service and utilities
- request picked up from waiting queue and handle over to sql interface and get its hash result, if result in cache, return result
- if result not exists, request be handled to parser for validation and optimizer for optimized data structure
- optimized execution plan will be handled to engine finally to get data

> note: engine of mysql is pluggable, using InnoDB by default

- mysql will cache hash of query/result