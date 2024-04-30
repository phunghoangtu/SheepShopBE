package com.sheepshop.repositorys;

import com.sheepshop.entitys.Bill;
import com.sheepshop.model.resp.BillResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer>{



    @Query(value = "select code from bill b order by len(b.code) desc, b.code desc offset 0 row fetch next 1 row only", nativeQuery = true)
    String getBiggestMa();

    @Query(value = "Select b.id , b.code , b.totalPrice,b.status, b.payStatus from Bill b \n" +
            "where b.status = :status order by b.purchaseDate desc")
    List<BillResponse> getBillByStatus(@Param("status") Integer status);


}
