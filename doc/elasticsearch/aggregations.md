There are many different types of aggregations, each with its own purpose and output. To better understand these types, it is often easier to break them into four main families:

- Bucketing
- Metric
- Matrix
- Pipeline

Aggregation structure:
```
"aggregations" : {
    "<aggregation_name>" : {
        "<aggregation_type>" : {
            <aggregation_body>
        }
        [,"meta" : {  [<meta_data_body>] } ]?
        [,"aggregations" : { [<sub_aggregation>]+ } ]?
    }
    [,"<aggregation_name_2>" : { ... } ]*
}
```
#### Metric aggs
avg
```
# avg based on field
curl -XGET 'localhost:9200/bank/_search?pretty' -d '
{
  "aggs":{
    "avg_age":{
      "avg":{
        "field":"age",
        "missing":10     # if missing, give value 10
      }
    }
  }
}'
# avg based on script
'localhost:9200/bank/_search?pretty' -d '
{
  "aggs":{
    "avg_price":{
      "avg":{
        "script":{
          "source":"doc.age.value"
        }
      }
    }
  }
}'
```
cardinality
```
curl -XGET 'localhost:9200/bank/_search?pretty' -d '
{
  "aggs":{
    "distinct_employer":{
      "cardinality":{
        "field":"employer.keyword",
        "missing":"N/A"
      }
    }
  }
}'
```
extended_stats
```
{
    ...

    "aggregations": {
        "grade_stats": {
           "count": 9,
           "min": 72,
           "max": 99,
           "avg": 86,
           "sum": 774,
           "sum_of_squares": 67028,
           "variance": 51.55555555555556,
           "std_deviation": 7.180219742846005,
           "std_deviation_bounds": {
            "upper": 100.36043948569201,
            "lower": 71.63956051430799
           }
        }
    }
}
```
max, min, sum, stats, percentiles, percentile_ranks
> Percentiles show the point at which a certain percentage of observed values occur. Percentile_ranks
show the percentage of data in the provided rank.
```
curl -XGET 'localhost:9200/bank/_search?pretty' -d '
{
  "aggs":{
    "percentile_age":{
      "percentiles":{
        "field":"age",
        "percents":["90", "95", "99"]
      }
    }
  }
}'

curl -XGET 'localhost:9200/bank/_search?pretty' -d '
{
  "aggs":{
    "per_rank_age":{
      "percentile_ranks":{
        "field":"age",
        "values":[25, 30]
      }
    }
  }
}'
```
value_count, count the number of values(not distinct) of a certain field
