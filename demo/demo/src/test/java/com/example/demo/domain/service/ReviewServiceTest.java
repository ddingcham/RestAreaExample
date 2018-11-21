package com.example.demo.domain.service;

import com.example.demo.domain.Menu;
import com.example.demo.domain.repository.MenuRepository;
import com.example.demo.domain.repository.ReviewRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ReviewServiceTest {
    @Autowired
    private MenuRepository menuRepository;

    private Menu menu;

    @Before
    public void setUp(){
        menu = defaultMenu()
                .writeReview("리뷰어1", "코멘트1")
                .writeReview("리뷰어2", "코멘트2");
        menuRepository.save(menu);
    }

    @Test
    public void writeReview(){
        menu.writeReview("리뷰어3", "코멘트3");
        Menu actualMenu = menuRepository.save(menu);
        Assertions.assertThat(menu.countReviews()).isEqualTo(actualMenu.countReviews());
    }

    private Menu defaultMenu(){
        return Menu.builder()
                .name("치즈라면")
                .price(70000L)
                .build();
    }

}
