package com.sheepshop.repositorys;

import com.sheepshop.entitys.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long>{

    @Query(value = "Select p from Bill p where p.payStatus = 0")
    List<Bill> getBillChuaThanhToan();

    @Query(value = "select code from bill b order by len(b.code) desc, b.code desc offset 0 row fetch next 1 row only", nativeQuery = true)
    String getBiggestMa();

}
