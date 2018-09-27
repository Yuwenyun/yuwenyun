show verbose output
```
curl -XGET 'localhost:9200/_cat/master?v'
```
show column specification
```
curl -XGET 'localhost:9200/_cat/master?help'
```
show specific columns
```
curl -XGET 'localhost:9200/_cat/nodes?h=ip,port,cpu,heap.percent'
```
_cat api
```
curl -XGET 'localhost:9200/_cat/nodes'
curl -XGET 'localhost:9200/_cat/health'
curl -XGET 'localhost:9200/_cat/indices'
```