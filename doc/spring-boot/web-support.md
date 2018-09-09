1. add starter of **spring-boot-starter-web**

2. @Controller and @RestController is to handle incoming http requests via @RequestMapping

3. auto-configuration of spring mvc in spring boot will add lots of default features.
- Inclusion of **ContentNegotiatingViewResolver** and **BeanNameViewResolver** beans.
- Support for serving static resources, including support for WebJars (covered later in this document)).
- Automatic registration of Converter, GenericConverter, and Formatter beans.
- Support for **HttpMessageConverters** (covered later in this document).
- Automatic registration of **MessageCodesResolver** (covered later in this document).
- Static index.html support.
- Custom Favicon support (covered later in this document).
- Automatic use of a ConfigurableWebBindingInitializer bean (covered later in this document).

we can enable below
- add @Configuration class of type **WebMvcConfgurer** but **without** @EnableWebMvc to add additional config
- declare **WebMvcRegistrationsAdapter** instance to provide custom instance of RequestMappingHandlerMapping, RequestMapingHandlerAdapter or ExceptionHadnlerExceptionResolver
- add @Configuration class with @EnableWebMvc to take full control of configuring spring mvc

4. **HttpMessageConverters** is a bunches of **HttpMessageConverter** interface to convert HTTP requests and responses. obj <-> json/xml
```
@Configuration
public class MyConfiguration {

	@Bean
	public HttpMessageConverters customConverters() {
		HttpMessageConverter<?> additional = ...
		HttpMessageConverter<?> another = ...
		return new HttpMessageConverters(additional, another);
	}
}
```
5. spring boot uses **ResourceHttpRequestHandler** to handle client request by default, we can override **addResourceHandlers()** of **WebMvcConfigurer** to add our own



