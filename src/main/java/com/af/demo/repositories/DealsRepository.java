package com.af.demo.repositories;

import com.af.demo.entities.DealsEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.websocket.server.PathParam;
import java.math.BigDecimal;
import java.util.List;

@Repository
public interface DealsRepository extends CrudRepository<DealsEntity,Long> {
    @Query(value = "SELECT * FROM deals WHERE deal_amount=:dealAmount AND from_currency=:fromCurrencyISOCode AND to_currencyisocode=:toCurrencyISOCode", nativeQuery = true)
    DealsEntity existsDeal(@Param("dealAmount") BigDecimal dealAmount, @Param("fromCurrencyISOCode") String fromCurrencyISOCode, @Param("toCurrencyISOCode") String toCurrencyISOCode);
}
