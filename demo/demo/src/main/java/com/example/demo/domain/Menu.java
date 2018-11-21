package com.example.demo.domain;

import com.example.demo.domain.support.AbstractEntity;
import com.example.demo.domain.support.Price;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@ToString(of={"name","price"})
public class Menu extends AbstractEntity {

    @Column(nullable = false)
    @Size(min = 3, max = 30)
    private String name;

    @Embedded
    @Column(nullable = false)
    private Price price;

    Menu(){}
    Menu(String name, long price){
        this.name = name;
        this.price = new Price(price);
    }
}
