index a doc
```
curl -XPUT 'localhost:9200/bank/account/1001' -d '
{
  "name":"yuwenyun",
  "age":25,
  "balance":1000
}'
```
get a doc
```
curl -XGET 'localhost:9200/bank/account/1001'
```
bulk
```
cat data.json
{ "index" : { "_index" : "test", "_type" : "type1", "_id" : "1" } }
{ "field1" : "value1" }
curl -s -XPOST 'localhost:9200/_bulk' --data-binary "@data.json"
```
copy doc to another index
```
curl -XPOST 'localhost:9200/_reindex' -d '
{
  "source":{
    "index":"index_1"
  },
  "dest":{
    "index":"index_2",
    "version_type":"internal"  # create missing, update stale version
    # "version_type":"external" # create missing, ignore exists doc
  },
  "conflicts":"proceed" # by default, conflict abort the _reindex, this tells es ignore conflict
}'
```
reindex from remote
```
curl -XPOST 'localhost:9200/_reindex' -d '
{
  "source":{
    "remote":{
      "host":"myhost1u:9200",
      "username":"yuwenyun",
      "password":"passwd"
    },
    "index":"bank",
    "query":{
      "bool":{
        "must":{
          "exists":{
            "field":"account"
          }
        }
      }
    }
  },
  "dest":{
    "index":"newIndex"
  }
}'
```
