package com.example.demo.domain.repository;

import com.example.demo.domain.Store;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StoreRepositoryTest {

    @Autowired
    private StoreRepository storeRepository;

    private Store defaultStore;

    @Before
    public void setUp() {
        defaultStore = defaultStore();
        storeRepository.save(defaultStore);
    }

    @Test
    public void showStore_1() {
        Assertions.assertThat(storeRepository.findAll()).containsOnly(defaultStore);
    }

    @Test
    public void showStore_2() {
        Assertions.assertThat(storeRepository.findAll()).containsOnly(defaultStore);
    }

    private Store defaultStore() {
        return Store.builder()
                .name("부산(서울)")
                .build();
    }
}
