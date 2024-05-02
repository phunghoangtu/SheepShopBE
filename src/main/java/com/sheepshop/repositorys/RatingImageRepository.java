package com.sheepshop.repositorys;

import com.sheepshop.entitys.RatingImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingImageRepository extends JpaRepository<RatingImage,Integer> {


}
