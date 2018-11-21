package com.example.demo.domain.repository;

import com.example.demo.domain.Review;
import org.springframework.data.repository.CrudRepository;


public interface ReviewRepository extends CrudRepository<Review, Long> {
}
