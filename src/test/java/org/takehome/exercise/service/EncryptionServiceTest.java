package org.takehome.exercise.service;

import org.junit.Assert;
import org.junit.Test;


public class EncryptionServiceTest {

    @Test
    public void testEncryption() throws Exception{

        EncryptionService service = new EncryptionService("test");

        String result = service.encrypt("test");

        Assert.assertEquals("NGPKshFOi7Ohwp1QXzReQA==", result);

    }


    @Test
    public void testDencryption() throws Exception{

        EncryptionService service = new EncryptionService("test");

        String result = service.decrypt("NGPKshFOi7Ohwp1QXzReQA==");

        Assert.assertEquals("test", result);


    }

    @Test
    public void testEncryptionDencryption() throws Exception{

        EncryptionService service = new EncryptionService("test");

        String encrypted = service.encrypt("test");

        String value = service.decrypt(encrypted);

        Assert.assertEquals("test", value);

    }

}
