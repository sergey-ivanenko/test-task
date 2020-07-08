package by.itechart.testtask.config;

//@Configuration
//@EnableOAuth2Client
public class WebSecurityConfig/* extends WebSecurityConfigurerAdapter*/ {
    /*@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/", "/login**")
                .permitAll()
                .anyRequest()
                .authenticated()
                *//*.and()
                .oauth2Login()*//*;
    }*/
}
