1. servlet run in memory of web server, no independent process for client request.

2. servlet is platform independent since it's implemented with Java

3. tasks of servlet:
- read html form from client browser
- read html data (cookies, media type) from client browser
- send doc back to browser(html, xml, gif...)
- send html response back to client browser

> note: servlet is running on web server who has java servlet interpreter, Servlet instance
can be created by **javax.servlet** and **javax.servlet.http**

4. life cycle of servlet
- init(): only call once when initialize the object, won't call again each request later
- service(): servlet container(which is web server) call this method to handle client request and call doGet(), doPost(), etc.
later according to the request type
- destroy()
- collect by gc

5. create a servlet
```java
public class HelloWorld extends HttpServlet {
 
  private String message;

  public void init() throws ServletException
  {
      message = "Hello World";
  }

  public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
  {
      response.setContentType("text/html");

      PrintWriter out = response.getWriter();
      out.println("<h1>" + message + "</h1>");
  }
  
  public void destroy()
  {
  }
}
```
register this servlet in **web.xml** of web server(if tomcat, <Tomcat-install-dir>/webapps/ROOT/WEB-INF/)
```xml
<web-app>      
    <servlet>
        <servlet-name>HelloWorld</servlet-name>
        <servlet-class>HelloWorld</servlet-class>
    </servlet>

    <servlet-mapping>
        <servlet-name>HelloWorld</servlet-name>
        <url-pattern>/HelloWorld</url-pattern>
    </servlet-mapping>
</web-app>
```
put the HelloWorld.class under <Tomcat-install-dir>/webapps/ROOT and access
**http://localhost:8080/HelloWorld

6. servlet is able to handle get request and post request
- get: params and values are in url explicitly
- post: data are not in url