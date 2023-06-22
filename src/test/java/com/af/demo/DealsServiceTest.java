package com.af.demo;

import com.af.demo.entities.DealsEntity;
import com.af.demo.model.request.DealsRequest;
import com.af.demo.repositories.DealsRepository;
import com.af.demo.service.DealsService;
import com.af.demo.utils.IGenerateUniqueId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@SpringBootTest
public class DealsServiceTest {

    @InjectMocks
    private DealsService dealsService;

    @Mock
    private DealsRepository dealsRepository;

    @Autowired
    private IGenerateUniqueId generateUniqueId;


    @BeforeEach
    void setup() throws Exception{
        MockitoAnnotations.initMocks(this);
    }

    @Test
    final void testSaveDeal(){
        DealsEntity dealsEntity = new DealsEntity();
        dealsEntity.setDealTimestamp(LocalDateTime.now());
        dealsEntity.setDealAmount(BigDecimal.valueOf(30.4));
        dealsEntity.setToCurrencyISOCode("USD");
        dealsEntity.setFromCurrency("JOR");
        dealsEntity.setDealUniqueId(generateUniqueId.generateUniqueID(30));
        Mockito.when(dealsRepository.save(dealsEntity)).thenReturn(dealsEntity);
    }

    @Test
    final void testDealsExists(){
        DealsRequest dealsRequest = new DealsRequest();
        dealsRequest.setDealAmount(BigDecimal.valueOf(123.00));
        dealsRequest.setFromCurrency("SSA");
        dealsRequest.setToCurrencyISOCode("USD");
        Mockito.when(dealsService.existsRecord(dealsRequest)).thenReturn(null);
    }

}
