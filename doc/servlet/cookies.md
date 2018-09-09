1. http cookie
- server send a group of cookies to browser
- browser save those info to local for future use
- browser send request to server and put those cookie in the request, server can identify user via those cookies

2. cookie is set up in http header
```
HTTP/1.1 200 OK
Date: Fri, 04 Feb 2000 21:03:38 GMT
Server: Apache/1.3.9 (UNIX) PHP/4.0b3
Set-Cookie: name=xyz; expires=Friday, 04-Feb-07 22:03:38 GMT; path=/; domain=runoob.com
Connection: close
Content-Type: text/html
```
the **Set-Cookie** will send the cookie to browser, next time browser want to request
```
GET / HTTP/1.0
Connection: Keep-Alive
User-Agent: Mozilla/4.6 (X11; I; Linux 2.2.6-15apmac ppc)
Host: zink.demon.co.uk:1126
Accept-Charset: iso-8859-1,*,utf-8
Cookie: name=xyz
```
the **Cookie** specifies browser's identity

3. http is **stateless**, to maintain a session
- use cookie for an uniq session id, not suggested
- submit hidden form with session id, not proper for <href>
- use **HttpSession**
```
public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
{
    // will create session if not exist, use
    // this session object to identify the client
    HttpSession session = request.getSession(true);
    
    Date createTime = new Date(session.getCreationTime());
    ...
}
```