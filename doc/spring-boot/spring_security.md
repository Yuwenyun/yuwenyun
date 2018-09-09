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
