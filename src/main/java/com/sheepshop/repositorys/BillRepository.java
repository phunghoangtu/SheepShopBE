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

    @Query(value =
            "SELECT b.Id, b.Code, b.PurchaseDate, b.EstimatedDate, b.PaymentDate, b.DeliveryDate, " +
                    "b.TotalPrice, b.ShipPrice, b.TotalPriceLast, b.Note, b.PayType, b.PayStatus, b.TypeStatus, " +
                    "b.Status, b.CodeGHN, b.IdCoupon, b.IdAddress, b.IdEmployee, b.IdVoucher, b.IdCustomer " +
                    "FROM Bill b WHERE b.Status = :status ORDER BY b.PurchaseDate DESC", nativeQuery = true)
    List<BillResponse> getBillByStatus(@Param("status") Integer status);



}
