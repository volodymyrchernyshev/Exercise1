package org.takehome.exercise.service;

import com.google.common.base.Charsets;

import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

public class EncryptionService {


    private static SecretKeySpec secretKey;

    public EncryptionService(String keyString) throws InvalidKeySpecException, NoSuchAlgorithmException {
//        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
//        random.nextBytes(salt);

        KeySpec keySpec = new PBEKeySpec(keyString.toCharArray(), salt, 65536, 256);

        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] key = f.generateSecret(keySpec).getEncoded();
        secretKey = new SecretKeySpec(key, "AES");

    }

    public String encrypt(String value) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException {
        byte[] bytes = value.getBytes(Charsets.UTF_8);

        return Base64.getEncoder().encodeToString(getCipher(Cipher.ENCRYPT_MODE).doFinal(bytes));
    }

    private Cipher getCipher(int mode) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {

        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(mode, secretKey);
        return cipher;
    }

    public String decrypt(String value) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException {
        byte[] bytes = Base64.getDecoder().decode(value);

        return new String(getCipher(Cipher.DECRYPT_MODE).doFinal(bytes), Charsets.UTF_8);

    }
}
