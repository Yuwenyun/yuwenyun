```aidl
# insert a doc
> db.foo.insert({"bar":"baz"})

# delete all the docs without deleting collections,
# indexes will be kept
> db.foo.remove()

# delete everything including collections and indexes
> db.drop_collection("foo")

# delete all the docs that bar is baz
> db.foo.remove({"bar":"baz"})

# update a doc, this is going to replace the entire doc
> db.blog.update({"url":"www.example.com"},
... {"visit":1}
... )

# increase the visit field
# using modifier($), _id is not allowed to change
> db.blog.update({"url":"www.example.com"},
... {"$inc":{"visit":1}}
... )

# create if not exist, otherwise update
# $set is able to change type of a certain key
> db.blog.update({"url":"www.example.com"},
... {"$set":{"favorite book":"war and peace"}}
... )
> db.blog.update({"url":"www.example.com"},
... {"$set":{"favorite book":["war and peace","ender's game"]}}
... )

# delete a key
> db.blog.update({"url":"www.example.com"},
... {"$unset":{"favorite book"}}
... )

# $push to add data to array
> db.blog.update({"url":"www.example.com"},
... {"$push":{"favorite book":"hello owen"}}
... )

# add data when not exist
> db.blog.update({"url":{"$ne":"www.baidu.com"}},
... {"$push":{"url":"www.google.com"}}
... )
> db.blog.update({"url":"www.baidu.com"},
... {"$addToSet":{"url":"www.google.com"}}
... )

# add multi data
> db.blog.update({"url":"www.baidu.com"},
... {"$addToSet":{"url":{"$each":["www.google.com","www.tps.com"]}}}
... )

# delete data from array tail
{"$pop":{"url":1}}
# delete data from array head
{"$pop":{"url":-1}}

# delete all the 1
> db.list.update({}, {"$pull":{"num":1}})

# update the first element of an array
> db.blog.update({"post":"post_id"},
... {"$inc":{"comments.0.votes":2}}
... )

# update array element of the first matched doc
> db.blog.update({"post":"post_id"},
... {"set":{"comments.$.author":"Jim"}}
... )
```