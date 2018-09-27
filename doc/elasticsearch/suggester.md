request for suggestion from es for specific query. es provides 4 suggesters:
- term suggester
- phrase suggester
- completion suggester
- context suggester

#### term suggester
es give suggestion based on each term
```
curl -XPOST 'localhost:9200/bank/_search?pretty' -d '
{
  "suggest":{
    "my_suggest":{
      "text":"hell Own",     # suggest text
      "term":{
        "suggest_mode":"missing"
        # missing: if the token/term from text is acurrate enough,
        #          it would be treat as default and provide no suggestion
        # popular: suggest a similar token in field
        "field":"employer"   # which field to suggest
      }
    }
  }
}'
```
#### phrase suggester
this is going to consider the text as phrase and take relative position/relationship of each
term into consideration.
```
curl -XPOST 'localhost:9200/bank/_search?pretty' -d '
{
  "suggest":{
    "my_suggest":{
      "text":"Hell Owen",
      "phrase":{
        "field":"content",
        "highlight":{
          "pre_tag":"<em>"
          "post_tag":"</em>"
        }
      }
    }
  }
}'
```
#### completion suggester
this is used for prefix suggestion, the field shall be type completion
```
curl -XPUT 'localhost:9200/bank?pretty' -d '
{
  "mappings":{
    "doc":{
      "properties":{
        "content":{
          "type":"completion"
        }
      }
    }
  }
}'
```
the content field is not using inverted index, a coded structure FST instead.
FST is loaded in memory, making it fast, FST process also needs analyzer to analyze.
```
curl -XPOST 'localhost:9200/bank/_search?pretty' -d '
{
  "suggest":{
    "my_suggest":{
      "prefix":"hello o"
      "completion":{
        "field":"content"
      }
    }
  }
}'
```