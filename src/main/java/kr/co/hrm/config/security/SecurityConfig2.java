package kr.co.hrm.config.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.ContextSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.ldap.DefaultSpringSecurityContextSource;
import org.springframework.security.ldap.server.UnboundIdContainer;
import org.springframework.security.web.SecurityFilterChain;

@Slf4j
@Configuration
@EnableWebSecurity
public class SecurityConfig2 {

    @Value("${spring.ldap.urls}")
    private String ldapUrl;

    @Value("${spring.ldap.username}")
    private String ldapUsername;

    @Value("${spring.ldap.password}")
    private String ldapPassword;

    @Value("${spring.ldap.base}")
    private String ldapBase;


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {


        auth.ldapAuthentication()
                .contextSource()
                .url(ldapUrl)
                .managerDn(ldapUsername)
                .managerPassword(ldapPassword)
                .and()
                .userSearchBase(ldapBase)
                .userSearchFilter("(uid={0})")
                .groupSearchBase(ldapBase)
                .groupSearchFilter("(member={0})")
                .passwordCompare()
                .passwordEncoder(new CryptSha512PasswordEncoder())
                .passwordAttribute("userPassword");

    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasRole("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll();
        return http.build();
    }


    ContextSource contextSource(UnboundIdContainer container) {
        return new DefaultSpringSecurityContextSource("ldap://localhost:53389/dc=springframework,dc=org");
    }
}