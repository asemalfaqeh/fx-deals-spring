package com.af.demo;


import com.af.demo.utils.IGenerateUniqueId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UtilsTest {

    @Autowired
    private IGenerateUniqueId generateUniqueId;

    @BeforeEach
    void setup() throws Exception{

    }

    @Test
    final void testGeneratedUniqueID(){
        String generatedId = generateUniqueId.generateUniqueID(30);
        Assertions.assertNotNull(generatedId);
        Assertions.assertEquals(generatedId.length(),30);
    }

}
