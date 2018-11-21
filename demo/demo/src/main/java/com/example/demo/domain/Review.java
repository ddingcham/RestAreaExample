package com.example.demo.domain;

import com.example.demo.domain.support.AbstractEntity;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class Review extends AbstractEntity {
    @Column(nullable = false)
    private String writer;

    @Column(nullable = false)
    private String comment;

    @Builder
    Review(String writer, String comment){
        this.writer = writer;
        this.comment = comment;
    }
}