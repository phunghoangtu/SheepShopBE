package com.sheepshop.repositorys;

import com.sheepshop.entitys.Bill;
import com.sheepshop.model.resp.*;
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

    @Query(value = "Select COUNT(b.Id) as 'SoLuong', SUM(b.TotalPrice - b.TotalPriceLast) as 'DoanhThu' from Bill b\n" +
            "where b.Status = 3 and CONVERT(DATE, b.PurchaseDate) = CONVERT(DATE, GETDATE())", nativeQuery = true)
    TKNgay getThongKeNgay();

    @Query(value = "SELECT COUNT(b.Id) as 'SoLuong', SUM(b.TotalPrice - b.TotalPriceLast) as 'DoanhThu'\n" +
            "FROM Bill b\n" +
            "WHERE b.Status = 3 AND MONTH(b.PurchaseDate) = MONTH(GETDATE()) AND YEAR(b.PurchaseDate) = YEAR(GETDATE())", nativeQuery = true)
    TKThang getThongKeThang();
    @Query(value = "Select SUM(bi.Quantity) as 'SoLuong' from BillDetail bi\n" +
            "join Bill b on b.Id = bi.IdOrder\n" +
            "WHERE b.Status = 3 AND MONTH(b.PurchaseDate) = MONTH(GETDATE()) AND YEAR(b.PurchaseDate) = YEAR(GETDATE())",nativeQuery = true)
    TKSLThang getThongKeSoLuongThang();

    @Query(value = "WITH DateTable AS (\n" +
            "    SELECT \n" +
            "        DATEADD(DAY, number, :tungay) AS DateInInterval\n" +
            "    FROM master.dbo.spt_values\n" +
            "    WHERE type = 'P'\n" +
            "        AND DATEADD(DAY, number, :tungay) <= :denngay\n" +
            ")\n" +
            "SELECT \n" +
            "    CAST(DateTable.DateInInterval AS DATE) AS PurchaseDay,\n" +
            "    COUNT(CASE WHEN Bill.Status = 0 THEN 1 ELSE NULL END) AS NumberOfBillsStatus0,\n" +
            "    COUNT(CASE WHEN Bill.Status = 1 THEN 1 ELSE NULL END) AS NumberOfBillsStatus1,\n" +
            "    COUNT(CASE WHEN Bill.Status = 2 THEN 1 ELSE NULL END) AS NumberOfBillsStatus2,\n" +
            "    COUNT(CASE WHEN Bill.Status = 3 THEN 1 ELSE NULL END) AS NumberOfBillsStatus3,\n" +
            "    COUNT(CASE WHEN Bill.Status = 4 THEN 1 ELSE NULL END) AS NumberOfBillsStatus4\n" +
            "FROM DateTable\n" +
            "LEFT JOIN Bill ON CONVERT(DATE, Bill.PurchaseDate) = DateTable.DateInInterval\n" +
            "GROUP BY CAST(DateTable.DateInInterval AS DATE)\n" +
            "ORDER BY PurchaseDay;\n", nativeQuery = true)
    public List<TKSoLuongHD> getTKSoLuongHD(@Param("tungay") String tungay, @Param("denngay") String denngay);


    @Query(value = "WITH DateTable AS (\n" +
            "    SELECT \n" +
            "        DATEADD(DAY, number, :tungay) AS DateInInterval\n" +
            "    FROM master.dbo.spt_values\n" +
            "    WHERE type = 'P'\n" +
            "        AND DATEADD(DAY, number, :tungay) <= :denngay\n" +
            ")\n" +
            "\n" +
            "SELECT \n" +
            "    CAST(DateTable.DateInInterval AS DATE) AS PurchaseDay,\n" +
            "    COALESCE(SUM(bi.Quantity), 0) AS SoLuong,\n" +
            "    COALESCE(SUM(b.TotalPrice - b.TotalPriceLast), 0) AS DoanhThu\n" +
            "FROM DateTable\n" +
            "LEFT JOIN Bill b ON CONVERT(DATE, b.PurchaseDate) = DateTable.DateInInterval AND b.Status = 3\n" +
            "LEFT JOIN BillDetail bi ON bi.IdOrder = b.Id\n" +
            "GROUP BY CAST(DateTable.DateInInterval AS DATE)\n" +
            "ORDER BY PurchaseDay",nativeQuery = true)
    List<TKSoLuongSanPham> getTKSoLuongSanPham(@Param("tungay")String tungay, @Param("denngay") String denngay);
    @Query(value = "WITH DateTable AS (\n" +
            "    SELECT \n" +
            "        DATEADD(DAY, number, :tungay) AS DateInInterval\n" +
            "    FROM master.dbo.spt_values\n" +
            "    WHERE type = 'P'\n" +
            "        AND DATEADD(DAY, number, :tungay) <= :denngay\n" +
            ")\n" +
            "\n" +
            "SELECT \n" +
            "    COUNT(CASE WHEN Bill.Status = 0 THEN 1 ELSE NULL END) AS NumberOfBillsStatus0,\n" +
            "    COUNT(CASE WHEN Bill.Status = 1 THEN 1 ELSE NULL END) AS NumberOfBillsStatus1,\n" +
            "    COUNT(CASE WHEN Bill.Status = 2 THEN 1 ELSE NULL END) AS NumberOfBillsStatus2,\n" +
            "    COUNT(CASE WHEN Bill.Status = 3 THEN 1 ELSE NULL END) AS NumberOfBillsStatus3,\n" +
            "    COUNT(CASE WHEN Bill.Status = 4 THEN 1 ELSE NULL END) AS NumberOfBillsStatus4\n" +
            "FROM DateTable\n" +
            "LEFT JOIN Bill ON CONVERT(DATE, Bill.PurchaseDate) = DateTable.DateInInterval;\n",nativeQuery = true)
    List<TKHoaDonStatus> getTKSoLuongHDStatus(@Param("tungay")String tungay, @Param("denngay") String denngay);


}
