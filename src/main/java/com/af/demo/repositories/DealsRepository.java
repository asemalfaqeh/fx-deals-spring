package com.af.demo.repositories;

import com.af.demo.entities.DealsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealsRepository extends CrudRepository<DealsEntity,Long> {
}
