package com.example.demo.domain;

import com.example.demo.domain.support.AbstractEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
public class Review extends AbstractEntity {
    @Column(nullable = false)
    private String writer;

    @Column(nullable = false)
    private String comment;
}