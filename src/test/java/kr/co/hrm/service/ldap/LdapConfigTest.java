package kr.co.hrm.service.ldap;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.EqualsFilter;

import java.util.List;

@SpringBootTest
class LdapConfigTest {

    public LdapTemplate ldapTemplate() {
        return new LdapTemplate(contextSource());
    }

    @Test
    List<String> ldapTest() {
        LdapTemplate ldapTemplate = ldapTemplate();

        AndFilter filter = new AndFilter();
        filter.and(new EqualsFilter("objectClass", "person"));

        List<String> result = ldapTemplate.search("", filter.encode(),
                (AttributesMapper<String>) attrs -> (String) attrs.get("cn").get());

        System.out.printf("%s", result.toString());

        return result;
    }

    public LdapContextSource contextSource() {
        LdapContextSource contextSource = new LdapContextSource();

        contextSource.setUrl("ldap://ldap.abacussw.co.kr:389/");
        contextSource.setBase("dc=abacussw,dc=co,dc=kr");
        contextSource.setUserDn("uid=root,cn=users,dc=abacussw,dc=co,dc=kr");
        contextSource.setPassword("Abacus10!@");

        return contextSource;
    }
}
