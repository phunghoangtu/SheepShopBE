package com.spring.sheepshop.repository;

import com.spring.sheepshop.entity.RatingImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingImageRepository extends JpaRepository<RatingImage,Integer> {
}
