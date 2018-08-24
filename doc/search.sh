# fast check for matching doc numbers, set size to 0
curl -XGET 'localhost:9200/bank/_search?q=age:25&size=0&pretty'
{
  "took" : 3,
  "timed_out" : false,
  "_shards" : {
    "total" : 5,
    "successful" : 5,
    "skipped" : 0,
    "failed" : 0
  },
  "hits" : {
    "total" : 42,
    "max_score" : 0.0,
    "hits" : [ ]          # there will be no result
  }
}

###
by default, field values are indexed to make them searchable, they are not stored, 
only the whole doc is as value of _source field.
if we want to retrieve a single field or a few fields:
1. add source filter("_source":["age", "name"])
2. store the field
PUT my_index
{
  "mappings": {
    "_doc": {
      "properties": {
        "name": {
          "type": "text",
          "store": true      # this is false by default
        }
      }
    }
  }
}

PUT my_index/_doc/1
{
  "name":   "Yuwenyun"
}

GET my_index/_search
{
  "stored_fields": [ "name" ] 
}

doc_values are on-disk data structure, built at index time for sorting, aggregations and access to field values
in scripts. stored fields and doc_values are different for:
1. stored fields are designed for optimal storage whereas doc values are designed the access field values quickly
2. During the execution of query many of doc values fields are accessed for candidate hits, so the access must be fast
stored fields are only used for return field values for the top matching documents and won't involve query process

# basic params
curl -XGET 'localhost:9200/bank/_search?pretty' -d '
{
  "query":{
    "term":{
      "age":25
    }
  },
  "_source":false,  # won't return the source
  "from": 0,
  "size": 10,
  "stored_fields": ["age", "male"],   # load specific stored fields
  "script_fields":{
    "myScriptFields":{
      "script":{
        "lang":"painless",
        "source":"doc['age'].value * param"
        "params":{
          "param": 2
        }
      }
    }
  },
  "version":true,
  "explain":true,
  "min_score":0.5,   # exclude docs that have _score less than this value
}'

###
search_type:
1. query_then_fetch: 
  1> query forwarded to all shards, and coordinating node resort the shard level results into globally sorted results
  2> get doc from relevant shards
2. dfs_query_then_fetch:
  results of different shards will be involved into the relevance calculation with global frequency.
  
# pre-render search requests and fill existing templates with parameters
curl -XGET 'localhost:9200/_search/template?pretty' -d '
{
  "source":｛
    "query":{"match":{ "{{my_field}}" : "{{my_value}},
    "size":"{{my_size}}"
  },
  "params":{
    "my_field":"age",
    "my_value":25,
    "my_size":10
  }
}'
