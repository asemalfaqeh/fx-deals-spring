package com.af.demo.service;

import com.af.demo.entities.DealsEntity;
import com.af.demo.repositories.DealsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DealsService {

    @Autowired
    private DealsRepository dealsRepository;

    public void saveDeal(DealsEntity dealsEntity){
        dealsRepository.save(dealsEntity);
    }

}
