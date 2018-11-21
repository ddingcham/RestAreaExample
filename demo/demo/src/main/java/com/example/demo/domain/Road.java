package com.example.demo.domain;

import com.example.demo.domain.support.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Map;

@Entity
public class Road extends AbstractEntity {
    @OneToMany
    private Map<String, Store> stores;


}
