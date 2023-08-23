package com.coding.cho;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyCoffeApplicationTests {

	@Test
	void contextLoads() {
	}

   @Test
    void jasypt() {
        String url = "my_db_url";
        String username = "my_db_username";
        String password = "my_db_password";

        //암호화 진행
        System.out.println(jasyptEncoding(url));
        System.out.println(jasyptEncoding(username));
        System.out.println(jasyptEncoding(password));
    }

    public String jasyptEncoding(String value) {

        String key = "my_jasypt_key";
        StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
        pbeEnc.setAlgorithm("PBEWithMD5AndDES");//알고리즘 설정
        pbeEnc.setPassword(key);//패스워드 설정
        return pbeEnc.encrypt(value);
    }
}
