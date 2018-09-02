Write a MongoDB query to display all the documents in the collection restaurants
```
db.restaurants.find().pretty()
```
Write a MongoDB query to display the fields restaurant_id, name, borough and cuisine for all the documents in the collection restaurant
```
db.restaurants.find({}, {"restaurant_id":1, "borough":1, "cuisine":1}).pretty()
```
Write a MongoDB query to display the fields restaurant_id, name, borough and cuisine, but exclude the field _id for all the documents in the collection restaurant
```
db.restaurants.find({}, {"restaurant_id":1, "borough":1, "cuisine":1, "_id":0}).pretty()
```
Write a MongoDB query to display all the restaurant which is in the borough Bronx
```
db.restaurants.find({"borough":"Bronx"}).pretty()
```
Write a MongoDB query to display the next 5 restaurants after skipping first 5 which are in the borough Bronx
```
db.restaurants.find({"borough":"Bronx"}).skip(5).limit(5).pretty()
```
Write a MongoDB query to find the restaurants who achieved a score more than 90
```
db.restaurants.find({"grades.score":{"$gt":90}}).pretty()
```
Write a MongoDB query to find the restaurants that achieved a score, more than 80 but less than 100
```
db.restaurants.find({"grades.score":{"$gt":80, "$lt":100}}).pretty()
```
Write a MongoDB query to find the restaurants which locate in longitude value less than -95.754168
```
db.restaurants.find({"address.coord.0":{"$lt":-95.754168}}).pretty()
```
Write a MongoDB query to find the restaurants that do not prepare any cuisine of 'American' and their grade score more than 70 and latitude less than -65.754168
```
db.restaurants.find({"$and":[{"cuisine":{"$ne":"American"}}, {"grades.score":{"$gt":70}}, {"address.coord.0":{"$lt":-65.754168}}]}).pretty()
```
Write a MongoDB query to find the restaurants which do not prepare any cuisine of 'American ' and achieved a grade point 'A' not belongs to the borough Brooklyn. The document must be displayed according to the cuisine in descending order.
```
db.restaurants.find({"$and":[{"cuisine":{"$ne":"American"}}, {"grades.grade":"A"}, {"borough":{"$ne":"Brooklyn"}}]}).sort({"cuisine":-1}).pretty()
```
Write a MongoDB query to find the restaurant Id, name, borough and cuisine for those restaurants which contain 'Wil' as first three letters for its name
```
db.restaurants.find({"name":/^Wil/}, {"restaurant_id":1, "name":1, "borough":1, "cuisine":1}).pretty()
```
Write a MongoDB query to find the restaurant Id, name, borough and cuisine for those restaurants which contain 'ces' as last three letters for its name
```
db.restaurants.find({"name":/ces$/}, {"restaurant_id":1, "name":1, "cuisine":1}).pretty()
```