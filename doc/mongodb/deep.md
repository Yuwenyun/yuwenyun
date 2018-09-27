1. fix collection
- organise data as a cycle
- deletion is not allowed, and not allowed to move when update
- not index in fix collection even on field _id

2. create a fix collection explicitly
```
# create a fix collection with size 10000 bytes and max 100 docs
db.createCollection("my_collection", {"capped":true, "size":10000, "max":100})
```