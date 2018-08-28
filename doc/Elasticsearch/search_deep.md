1. *term* is used to query numbers, booleans, dates and text, *term* helps to query the exact value we provide, if we don't want to calculate the similarity score, wrap it with *constant_score*.
```
{
  "query":{
    "constant_score":{
      "filter":{
        "term":{"price":20}  # term has to be wrapped with filter->constant_score
      }
    }
  }
}'
```
note: no-similarity-calculation term query will happen in below process:
- query inverted index for price with value 20;
- create a bitset indicates which doc contains value 20 in field price;
- iterate the bitset for all the queried doc

2. nested bool query
```
{
  "query":{
    "bool":{
      "should":[{
        "term":{"soeid":"jl18212"}
      },{
        "bool":{
          "must_not":{
            "term":{"uploader":"jl18212}
          }
        }
      }]
    }
  }
}
```

3. multi-value query(same field)
```
{
  "query":{
    "constant_score":{
      "filter":{
        "terms":{
          "firstname":["Owen", "Ricy"]
        }
      }
    }
  }
}'
```
> note: *term* and *terms* are contain operation instead of equals operation. when the field is an array, once the value(s) exists, it matches.

4. range query
```
{
  "query":{
    "constant_score":{
      "filter":{
        "range":{
          "age":{
            "gt":30,
            "lte":35
          }
        }
      }
    }
  }
}'
```

5. exists query will query those that has a certain field and value is not null, if value is of type array and one value in the array is null, that doc will match too
```
{
  "query":{
    "constant_score":{
      "filter":{
        "exists":{
          "field":"tags"
        }
      }
    }
  }
}

# to query the missing field doc or field with null value, use missing
{
  "query":{
    "constant_score":{
      "filter":{
        "missing":{
          "field":"tags"
        }
      }
    }
  }
}
```

6. Similarity is expressed by *_score*, basically influenced by :
- Term Frequency(TF): higher term frequency means higher similarity
- Inverse Document Frequency(IDF): higher frequency of term in different indices means it's not that important.
- Field Length: longer field means lower similarity. term exists in longer field is less relative to that in shorter field.

note: match query will happen in below process:
- check whether the query field is analyzed field
- analyze the provided term
- query inverted index for the documents
- consider TF, IDF, length of field and calculate the similarity for each doc

7. multi-term query, the provided string will be tokenized and construct a bool query with *or* operation
```
{
  "query": {
    "match": {
      "title": {      
        "query":"BROWN DOG!",
        "operator": "and",      # use operator to control the logic relation of each term in query
        # "minimum_should_match": "75%" # 75% of the terms in query shall match
      }
    }
  }
}
```

8. *_score* calculation of bool query
```
{
  "query": {
    "bool": {
      "should":[{ 
        "match": { "title": "Brown fox" }},{ 
        "match": { "body":  "Brown fox" }
      }]
    }
  }
}
```
- execute each branch(must, should, must_not)
- sum all the docs' score
- multiply number of matched fields
- divide number of all the query fields

say we have total below docs
```
{
    "title": "Quick brown rabbits",
    "body":  "Brown rabbits are commonly seen."
}
{
    "title": "Keeping pets healthy",
    "body":  "My quick brown fox eats rabbits on a regular basis."
}
```
the second one is more related to the query condition because body field has both brown and fox, but the truth is total score is lower the doc 1.
This is the result of overall score calculation, doc 2's title field has no queried term, lowering the final score.

9. if we want the best matched field doc score higher, we need to use *Disjunction Max Query*
```
{
  "query": {
    "dis_max": {
      "queries": [
        { "match": { "title": "Brown fox" }},
        { "match": { "body":  "Brown fox" }}
      ],
      # simply using dis_max will score the doc by highest scored field, which ignored other query fields.
      # use tie_breaker to take 30% of other fields score into consideration.
      "tie_breaker":0.3
    }
  }
}

# we can simplify dis_max query as below multi_match
{
    "multi_match": {
        "query":                "Quick brown fox",
        # best_fields: use highest scored field as doc's score
        # most_fields: every scored field shall be taken into consideration for final score
        # cross_fields
        "type":                 "best_fields", 
        "fields":               [ "title", "body" ],
        "tie_breaker":          0.3,
        "minimum_should_match": "30%" 
    }
}
```


