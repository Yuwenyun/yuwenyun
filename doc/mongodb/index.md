index of mongodb is like other relational index, insert/update/delete would cost more.
max indexes are 64 for each collection.

1. create index
```
db.user.ensureIndex({"name":1, "age":-1})
# create index for nested doc
db.user.ensureIndex({"comments.date":1})

# create index with name
db.user.ensureIndex({"date":1}, {"name":"date_index"})

# ensure uniq of index key
db.user.ensureIndex({"date":1}, {"uniq":true})

# drop all the duplicated doc of field date
db.user.ensureIndex({"date":1}, {"uniq":true, "dropDups":true})
```

2. use explain, call **explain()** on cursor(return value of find()) to show detail
```
db.blog.find().explain()

{
  "queryPlanner" : {
    "plannerVersion" : 1,
    "namespace" : "test.blog",
    "indexFilterSet" : false,
    "parsedQuery" : {
			
    },
    "winningPlan" : {
      "stage" : "COLLSCAN",  # no index query, scan the collection
      "direction" : "forward"
    },
    "rejectedPlans" : [ ]
  },
  "serverInfo" : {
    "host" : "yuwenyun.local",
    "port" : 27017,
    "version" : "3.4.6",
    "gitVersion" : "c55eb86ef46ee7aede3b1e2a5d184a7df4bfb5b5"
  },
  "ok" : 1
}

db.blog.find({"title":"My Blog Post"}).explain()
{
  "queryPlanner" : {
    "plannerVersion" : 1,
    "namespace" : "test.blog",
    "indexFilterSet" : false,
    "parsedQuery" : {
      "title" : {
        "$eq" : "My Blog Post"
      }
    },
    "winningPlan" : {
      "stage" : "FETCH",
      "inputStage" : {
        "stage" : "IXSCAN", # scan index blog_title_index
        "keyPattern" : {
          "title" : 1
        },
        "indexName" : "blog_title_index",
        "isMultiKey" : false,
        "multiKeyPaths" : {
          "title" : [ ]
        },
        "isUnique" : false,
        "isSparse" : false,
        "isPartial" : false,
        "indexVersion" : 2,
        "direction" : "forward",
        "indexBounds" : {
          "title" : [
            "[\"My Blog Post\", \"My Blog Post\"]"
          ]
        }
      }
    },
    "rejectedPlans" : [ ]
  },
  "serverInfo" : {
    "host" : "yuwenyun.local",
    "port" : 27017,
    "version" : "3.4.6",
    "gitVersion" : "c55eb86ef46ee7aede3b1e2a5d184a7df4bfb5b5"
  },
  "ok" : 1
}
```

3. if mongo is using other index when explain(), we can **hint** mongo to use specific index
```
db.user.find({"title":"My Blog Post"}).hint({"title":1})
```

4. manage index
```
# drop index
db.user.dropIndex("blog_title_index")

# show all the indexes
db.system.indexes.find()
```