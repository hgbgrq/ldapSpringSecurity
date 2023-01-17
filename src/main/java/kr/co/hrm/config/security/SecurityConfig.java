//package kr.co.hrm.config.security;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.LdapDataEntry;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
//import org.springframework.security.crypto.password.LdapShaPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Slf4j
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig{
//
//    @Value("${spring.ldap.urls}")
//    private String ldapUrl;
//
//    @Value("${spring.ldap.username}")
//    private String ldapUsername;
//
//    @Value("${spring.ldap.password}")
//    private String ldapPassword;
//
//    @Value("${spring.ldap.base}")
//    private String ldapBase;
//
////    @Value("${spring.ldap.urls}")
////    private String ldapUrls;
////
////    @Value("${spring.ldap.base}")
////    private String ldapBaseDn;
////
////    @Value("${spring.ldap.username}")
////    private String ldapSecurityPrincipal;
////
////    @Value("${spring.ldap.password}")
////    private String ldapPrincipalPassword;
////
////    @Value("${spring.ldap.user.dn.pattern}")
////    private String ldapUserDnPattern;
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
////        auth
////                .ldapAuthentication()
////                .contextSource()
////                .url(ldapUrls + ldapBaseDn)
////                .managerDn(ldapSecurityPrincipal)
////                .managerPassword(ldapPrincipalPassword)
////                .and()
////                .userDnPatterns(ldapUserDnPattern);
//
////        auth
////                .ldapAuthentication()
////                .userDnPatterns("uid={0},ou=people")
////                .groupSearchBase("ou=groups")
////                .contextSource()
////                .url("ldap://localhost:8389/dc=springframework,dc=org")
////                .and()
////                .passwordCompare()
////                .passwordEncoder(new BCryptPasswordEncoder())
////                .passwordAttribute("userPassword");
//
////        auth
////                .ldapAuthentication()
////                .userDnPatterns("uid={0},cn=users,dc=abacussw,dc=co,dc=kr")
////                .groupSearchBase("ou=pwpolicies")
////                .contextSource()
////                .url("ldap://ldap.abacussw.co.kr:389/dc=abacussw,dc=co,dc=kr")
////                .managerDn("uid=root,cn=users,dc=abacussw,dc=co,dc=kr")
////                .managerPassword("Abacus10!@")
////                .and()
////                .passwordCompare()
////                .passwordEncoder(new BCryptPasswordEncoder())
////                .passwordAttribute("userPassword");
////        Map<String, PasswordEncoder> encoders = new HashMap<>();
////        encoders.put("CRYPT", new CryptSha512PasswordEncoder("3244345745706b36"));
////        encoders.put("bcrypt", new BCryptPasswordEncoder());
////
//
//
//        auth.ldapAuthentication()
//                .contextSource()
//                .url(ldapUrl)
//                .managerDn(ldapUsername)
//                .managerPassword(ldapPassword)
//                .and()
//                .userSearchBase(ldapBase)
//                .userSearchFilter("(uid={0})")
//                .groupSearchBase(ldapBase)
//                .groupSearchFilter("(member={0})")
//                .passwordCompare()
//                .passwordEncoder(new CryptSha512PasswordEncoder())
//                .passwordAttribute("userPassword");
//
////        auth
////                .ldapAuthentication()
////                .contextSource()
////                .url(ldapUrls + ldapBaseDn)
////                .managerDn(ldapSecurityPrincipal)
////                .managerPassword(ldapPrincipalPassword)
////                .and()
////                .userDnPatterns(ldapUserDnPattern);
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers("/user/**").hasRole("USER")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .permitAll();
////        http
////                .authorizeRequests()
////                .antMatchers("/sample/login**").anonymous()
////                .antMatchers("/resources/**").permitAll()
////                .antMatchers("/api-docs/**").permitAll()
////                .antMatchers("/assets/**").permitAll()
////                .antMatchers("/").authenticated()
////                .antMatchers("/home").authenticated()
////                .and()
////                .formLogin()
////                .loginPage("/sample/login")
////                .permitAll()
////                .and()
////                .logout()
////                .permitAll()
////                .and()
////                .csrf()
////                .disable();
//        return http.build();
//    }
//
//}