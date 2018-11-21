package com.example.demo.domain.support;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
@ToString
@EqualsAndHashCode(of = "price")
@Data
public class Price {
    private BigDecimal price;

    Price(){}
    public Price(long price){
        if(price < 0){
            throw new IllegalArgumentException();
        }
        this.price = new BigDecimal(price);
    }

}