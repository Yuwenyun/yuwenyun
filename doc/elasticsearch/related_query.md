1. *match_phrase* is used to query position sensitive terms
```
{
  "query":{
    "match_phrase":{
      "title":{
        # quick<1>, brown<2>, fox<3>
        # the matched doc's title field has to have value of each term with relative position
        # like below
        "query":"quick brown fox",
        # if relative position is more than 1, consider it matches too
        "slop": 1
      }
    }
  }
}
```

2. say we have doc like below
```
{
    "names": [ "John Abraham", "Lincoln Smith"]
}
```
when index the doc, john<1>, abraham<2>, lincoln<3>, smith<4>, below query will get this doc
```
{
  "query":{
    "match_phrase":{
      "name":{
        "query":"Abranham Lincoln"
      }
    }
  }
}
```
to avoid this wrong answer, we need to reconstruct the mapping
```
{
  "mappings":{
    "doc":{
      "properties":{
        "name":{
          "type":"text",
          "position_increment_gap":100
        }
      }
    }
  }
}
```
thus john<1>, abraham<2>, lincoln<103>, smith<104>
