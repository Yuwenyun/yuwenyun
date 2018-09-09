1. **servlet filters** can dynamically intercept request/response to transfer/get info in request/response

2. commonly used filters
- authentication filters
- data compression filters
- logging and audition filters
- ...
> note: filters are registered in the **web.xml** file, filter instances are created when web server is launched,

3. filter is an instance implemented **javax.servlet.Filter** interface
- init(FilterConfig config)
- doFilter(ServletRequest, ServletResponse, FilterChain)
- destroy()

4. register filter in web.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>  
<web-app> 
<!-- define filters in front of every servlet --> 
<filter>
  <filter-name>LogFilter</filter-name>
  <filter-class>com.runoob.test.LogFilter</filter-class>
  <!-- define FilterConfig -->
  <init-param>
    <param-name>Site</param-name>
    <param-value>Baidu</param-value>
  </init-param>
</filter>
<!-- filter-mapping's order here depends the filter's order applied for each
     request, to adjust the order, just adjust the mapping's order
-->
<filter-mapping>
  <filter-name>LogFilter</filter-name>
  <url-pattern>/*</url-pattern>
</filter-mapping>
<servlet>  
  <servlet-name>DisplayHeader</servlet-name>
  <servlet-class>com.runoob.test.DisplayHeader</servlet-class>  
</servlet>  
<servlet-mapping>  
  <servlet-name>DisplayHeader</servlet-name>
  <url-pattern>/TomcatTest/DisplayHeader</url-pattern>  
</servlet-mapping>  
</web-app>  
```