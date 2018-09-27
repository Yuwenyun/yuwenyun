```
# query username owen and age 25
> db.user.find({"username":"owen", "age":25})

# show only username and email
> db.user.find({"age":25}, {"username":1, "email":1})

# don't show _id
> db.user.find({"age":25}, {"_id":0})

# range query
> db.user.find({"age":{"$gte":18, "$lte":30}})

# find user not named Joe
> db.user.find({"name":{"$ne":"Joe"}})

# multi-value
> db.user.find({"name":{"$in":["123", "Joe"]}})
> db.user.find({"name":{"$nin":["Owen", "Janney"]}})

# or
> db.user.find({"$or":[{"name":"Owen"}, {"age":25}]})

# find user whose age mod 5 and result 1
> db.user.find({"age":{"$mod":[5, 1]}})
# on the contrary
> db.user.find({"age":{"$not":{"$mod":[5, 1]}}})
```
> note: condition usage $ is inside the field, {"age":{"$lt":20}} while
setter usage $ is outside the file, {"$inc":{"age":1}}

$not, $ne

```
# query null and field that not exists
> db.user.find({"age":null})

# query null and field exist
> db.user.find({"age":{"$in":[null], "$exists":true}})

# query array for multi values
> db.user.find({"fruit":{"$all":["apple", "banana"]}})

# query array's n'th element
> db.user.find({"fruit.0":"apple"})

# query whose array is of length 3
> db.user.find({"fruit":{"$size": 3}})

# query head 10 elements of an array
> db.user.find({}, {"fruit":{"$slice":10}})
# query tail 10 elements of an array
> db.user.find({}, {"fruit":{"$slice":-10}})
# query 10 elements from 23th
> db.user.find({}, {"fruit":{"$slice":[23, 10]}})

# query nested key
> db.user.find({"name.first":"Joe"})

{
  "comments":[{
    "author":"joe",
    "score":3
  },{
    "author":"owen",
    "score":6
  }]
}

# query joe's comment scored greater than 5
# wrong query
> db.user.find({"comments":{"author":"joe", "score":{"$gt":5}}})
> db.user.find({"comments.author":"joe", "comments.score":{"$gt":5}})

# correct query
> db.user.find({"comments":{"$elemMatch":{"author":"joe", "score":{"$gt":5}}}})

# use cursor, cursor won't query db util it really required the data
> var cursor=db.collections.find();
> while(cursor.hasNext()){
... obj=cursor.next();
... // do sth
... }

> cursor.forEach(function(x){
... print(x.name);
... })

# below query are the same
> db.foo.find().sort({"name":1}).limit(1).skip(10)
> db.foo.find().limit(1).sort({"name":1}).skip(10)
> db.foo.find().skip(10).limit(1).sort({"name":1})
```