package com.sheepshop.repositorys;


import com.sheepshop.entitys.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating,Integer> {


}
