package com.example.demo.domain.repository;

import com.example.demo.domain.Menu;
import org.springframework.data.repository.CrudRepository;


public interface MenuRepository extends CrudRepository<Menu, Long> {
}