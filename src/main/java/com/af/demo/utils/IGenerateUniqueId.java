package com.af.demo.utils;


import org.springframework.stereotype.Component;
import java.util.Random;

@Component
public class IGenerateUniqueId {

    private final Random secureRandom = new Random();
    private final String ALPHAPET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public String generateUniqueID(int length){
        return generateRandomString(length);
    }

    private String generateRandomString(int length){

        StringBuilder stringBuilder = new StringBuilder(length);

        for(int i = 0; i < length; i++){
            stringBuilder.append(ALPHAPET.charAt(secureRandom.nextInt(ALPHAPET.length())));
        }

        return new String(stringBuilder);

    }

}
