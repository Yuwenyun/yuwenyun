1. http is based on tcp/ip protocol, it's used for client-server framework
- http is connection-less, every connection is able to handle only one request
- media independent, any type of data can be sent via http with proper **MIME-type**
- http is stateless, server won't keep any info of a session
- http using **URI** to transfer data and build connection

2. data format of a http request
```
request_method url protocol_version
key_1 : value_1
key_2 : value_2
...
key_n : value_n

request_data
```
sample request
```
GET /hello.txt HTTP/1.1
User-Agent: curl/7.16.3 libcurl/7.16.3 OpenSSL/0.9.7l zlib/1.2.3
Host: www.example.com
Accept-Language: en, mi
```
sample response
```
HTTP/1.1 200 OK
Date: Mon, 27 Jul 2009 12:28:53 GMT
Server: Apache
Last-Modified: Wed, 22 Jul 2009 19:15:56 GMT
ETag: "34aa387-d-1568eb00"
Accept-Ranges: bytes
Content-Length: 51
Vary: Accept-Encoding
Content-Type: text/plain
```

3. http response state code

type | description | sample
---- | ---- | ----
1** | data/request received | 
2** | handled success | 200, request success
3** | redirect | 301, source moved to other url
4** | client error | 404, resource not exists
5** | server error | 500, server internal error