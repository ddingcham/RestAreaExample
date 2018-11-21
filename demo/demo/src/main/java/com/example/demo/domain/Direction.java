package com.example.demo.domain;

import com.example.demo.domain.support.AbstractEntity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Direction extends AbstractEntity {
    @Column(nullable = false)
    private String name;

    @OneToMany
    @JoinColumn(name = "direction_id")
    private List<Store> stores;
}
