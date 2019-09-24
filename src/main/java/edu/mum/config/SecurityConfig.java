package edu.mum.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import edu.mum.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Value("${spring.queries.users-query}")
    private String usersQuery;

    @Value("${spring.queries.roles-query}")
    private String rolesQuery;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication()
                .usersByUsernameQuery(usersQuery)
                .authoritiesByUsernameQuery(rolesQuery)
                .dataSource(dataSource)
                .passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // ignored homepage, account area from authentication. and h2 database console
        http.authorizeRequests()
            .antMatchers("/", "/account/**", "/register/**", "/h2-console/**").permitAll()
            // allow access to all area until security module finish
//            .antMatchers("/admin/**", "/buyer/**", "/seller/**").permitAll()
            // checking permission on areas
            .antMatchers("/admin/**").hasAuthority("ADMIN")
            .antMatchers("/seller/**").hasAuthority("SELLER")
            .antMatchers("/buyer/**").hasAuthority("BUYER")
            .and()
            .formLogin()
            .loginPage("/account/login")
            .failureUrl("/account/login?error=true")
            .defaultSuccessUrl("/")
            .usernameParameter("email")
            .passwordParameter("password")
            .and()
            .rememberMe()
            .rememberMeParameter("remember-me")
            .rememberMeCookieName("remember-me")
            .tokenValiditySeconds(86400)
            .and()
            .logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/account/logout"))
            .logoutSuccessUrl("/")
            .and()
            .exceptionHandling()
            .accessDeniedPage("/403")
            .and()
            .csrf()
            .disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
           .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/img/**", "/h2-console/**");
    }
    
    @Bean(name = "bCryptPasswordEncoder")
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
