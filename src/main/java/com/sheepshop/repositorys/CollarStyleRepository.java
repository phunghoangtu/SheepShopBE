package com.sheepshop.repositorys;

import com.sheepshop.entitys.CollarStyle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollarStyleRepository extends JpaRepository<CollarStyle, Integer>{

}
