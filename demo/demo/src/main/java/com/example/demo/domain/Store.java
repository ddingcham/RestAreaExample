package com.example.demo.domain;

import com.example.demo.domain.support.AbstractEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.time.LocalTime;
import java.util.Set;

@Entity
@ToString(of = {"name"})
@Data
@Builder
public class Store extends AbstractEntity {

    @Column(nullable = false)
    @Size(min = 3, max = 30)
    private String name;

    @Builder.Default
    private LocalTime openTime = LocalTime.MIN;

    @Builder.Default
    private LocalTime closeTime = LocalTime.MAX;

    @OneToMany
    @JoinColumn(name = "store_id")
    private Set<Menu> menus;

}
