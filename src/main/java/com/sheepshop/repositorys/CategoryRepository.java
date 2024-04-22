package com.sheepshop.repositorys;

import com.sheepshop.entitys.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category , Long>{

    @Query(value = "Select c from Category c where c.status = 0")
    List<Category> getAllAPI();

}
