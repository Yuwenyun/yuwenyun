1. add starter **spring-boot-starter-security**

2. take spring security's web security support as an example
```
@Configuration
// enable web security
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/home").permitAll()  // not required
                .anyRequest().authenticated()  // other path required
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
             User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();

        // sets up an in-memory user store with a single user
        return new InMemoryUserDetailsManager(user);
    }
}
```
3. spring security = authentication + authorization

authentication
```
public interface AuthenticationManager {
  Authentication authenticate(Authentication authentication) throws AuthenticationException;
}
```
- will return an Authentication object(with authenticated=true) if input authentication obj is valid
- commonly used implementation of **AuthenticationManager** is  **ProviderManager**, this class delegates to a chain of **AuthenticationProvider**
- a ProviderManager has an optional parent to consult if all the providers in the chain return null, if parent can't decide, it returns null
- groups of protected resources may have bunches of AuthenticationManagers(which commonly are ProviderManager), they share the same parent that holds global resource

authorization is basically implemented by **AccessDecisionManager**
- commonly used 3 implementations of AccessDecisionManager delegate to a chain of **AccessDecisionVoter**.

4. Spring Security in the web tier (for UIs and HTTP back ends) is based on **Servlet Filters**, it is a single physical Filter with a fixed name **springSecurityFilterChain** but delegates processing to a chain of internal filters




