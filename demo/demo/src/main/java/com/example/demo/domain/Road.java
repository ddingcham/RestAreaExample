package com.example.demo.domain;

import com.example.demo.domain.support.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Road extends AbstractEntity {
    @Column(nullable=false)
    private String name;

    @OneToMany
    @JoinColumn(name = "road_id")
    private List<Direction> directions;

}
