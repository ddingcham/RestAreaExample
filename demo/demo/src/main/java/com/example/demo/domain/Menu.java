package com.example.demo.domain;

import com.example.demo.domain.support.AbstractEntity;
import com.example.demo.domain.support.Price;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@ToString(of = {"name", "price"})
public class Menu extends AbstractEntity {

    @Column(nullable = false)
    @Size(min = 3, max = 30)
    private String name;

    @Embedded
    @Column(nullable = false)
    private Price price;

    @OneToMany
    @JoinColumn(name = "menu_id")
    @OrderBy("created_at ASC")
    private List<Review> reviews = new ArrayList<Review>();

    Menu() {
    }

    @Builder
    Menu(String name, long price) {
        this.name = name;
        this.price = new Price(price);
    }

    public Menu writeReview(String writer, String comment) {
        reviews.add(Review.builder()
                .writer(writer)
                .comment(comment)
                .build());
        return this;
    }

    public int countReviews(){
        return reviews.size();
    }
}
