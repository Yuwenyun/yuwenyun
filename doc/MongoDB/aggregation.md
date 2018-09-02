```
# count doc
db.consumer.count()
db.consumer.count({"age":25})

# distinct
db.runCommand({"distinct":"consumer", "key":"age"})


```