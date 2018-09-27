1. below two docs are different
```
# mongo doc key/value are ordered
{"greeting":"hello owen", "foo":3}
{"foo":3, "greeting":"hello owen"}

# mongo doc case sensitive
{"foo":3}
{"Foo":3}

# mongo doc integer and string are not the same
{"foo":3}
{"foo":"3"}
```

2. mongo doc has no mapping like es
```
# below two docs may be in the same collection
{"greeting":"hello owen"}
{"foo":3}
```

3. start mongodb
```
${MONGO_HOME}/bin/mongod &
```
mongodb will use /data/db for data dir by default, and 27017 as port for connection,
28017 for http call

4. mongo shell client is a javascript shell
- it will connect to test db of mongo
- it contains some non-javascript grammar extension for mongo
```
# switch to db foobar
use foobar
# check current db
db
# show all the db
show dbs
# show all the collections of current db
show collections

# create new doc in collection
> post={"title":"My Blog Post",
... "content":"Here's my blog post",
... "date":new Date()}
> db.blog.insert(post)

# find the doc
> db.blog.find()

# check source code of function
> db.blog.find
```

5. basic type of mongo
- null: empty value or not exist
- bool: true or false, {"x":true}
- 32-bit integer: not supported in javascript shell
- 64-bit integer: not supported in javascript shell
- 64-bit float: both of below are 64-bit float in shell
```
{"x":3.14}
{"x":3}
```
- string: {"x":"string"}
- object id: 12-byte uniq id, {"_id":ObjectId()}
- date: milli-seconds, {"x":new Date()}
- reg expression: {"x":/foobar/i}
- code: {"x":function(){}}
- undefined: {"x":undefined}
- inner doc: {"x":{"y":"z"}}

6. how to guarantee **_id** is uniq
```aidl
# 12 bytes in total
0000 000 00 000
# date(ms) + machine id + pid of mongo instance + counter
```