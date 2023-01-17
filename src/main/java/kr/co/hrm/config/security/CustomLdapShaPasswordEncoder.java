package kr.co.hrm.config.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CustomLdapShaPasswordEncoder extends BCryptPasswordEncoder {
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        // remove the "{CRYPT}" prefix from the encoded password
        encodedPassword = encodedPassword.substring(7);
        return super.matches(rawPassword, encodedPassword);
    }

}