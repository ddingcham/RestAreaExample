package com.example.demo.domain.support;

import org.junit.Test;

public class PriceTest {

    @Test(expected = IllegalArgumentException.class)
    public void genereateNotValidPrice(){
        new Price(-1L);
    }
}
