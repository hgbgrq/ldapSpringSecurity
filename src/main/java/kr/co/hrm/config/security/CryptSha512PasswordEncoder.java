package kr.co.hrm.config.security;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class CryptSha512PasswordEncoder implements PasswordEncoder {

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        try {
            // extract the salt value from the encoded password
            String[] parts = encodedPassword.split("\\$");
            byte[] saltByte = Base64.getDecoder().decode(parts[1]);
            byte[] hashByte = Base64.getDecoder().decode(parts[2]);
            // get the bytes of the raw password
            byte[] passwordBytes = rawPassword.toString().getBytes();

            // create the key specification
            PBEKeySpec spec = new PBEKeySpec(rawPassword.toString().toCharArray(), saltByte, 10000, 512);

            // create the secret key factory
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");

            // generate the key
            byte[] hash = factory.generateSecret(spec).getEncoded();
            //encode the byte arrays into strings using Base64 encoding
            String encodedSalt = Base64.getEncoder().encodeToString(saltByte);
            String encodedHash = Base64.getEncoder().encodeToString(hash);
            // construct the encoded raw password
            String encodedRawPassword = "{CRYPT}" + encodedHash + "$" + encodedSalt;
            // compare the re-encoded raw password with the encoded password
            return encodedRawPassword.equals(encodedPassword);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            throw new IllegalStateException("Error while encoding the password", ex);
        }
    }

    @Override
    public String encode(CharSequence rawPassword) {
        throw new UnsupportedOperationException("This encoder only support match operation, not encoding");
    }
}