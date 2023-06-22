package com.af.demo.service;

import com.af.demo.entities.DealsEntity;
import com.af.demo.model.request.DealsRequest;
import com.af.demo.repositories.DealsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

@Service
public class DealsService {

    @Autowired
    private DealsRepository dealsRepository;

    public void saveDeal(DealsEntity dealsEntity) {
        dealsRepository.save(dealsEntity);
    }

    public DealsEntity existsRecord(DealsRequest dealsRequest){
        return dealsRepository.existsDeal(dealsRequest.getDealAmount(),dealsRequest.getFromCurrency(),dealsRequest.getToCurrencyISOCode());
    }

}
