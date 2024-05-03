package com.spring.sheepshop.repository;

import com.spring.sheepshop.entity.ProductDetail;
import com.spring.sheepshop.entity.Voucher;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail,Integer> {

    @Query(value = "Select e from ProductDetail e where e.Id = :id")
    public ProductDetail getById(@Param("id") Integer id);
    @Query(value = "Select e from ProductDetail e where e.Status = 0 Order by e.CreateDate desc")
    public List<ProductDetail> getAll();
    @Query(value = "Select e from ProductDetail e where e.Status = 1 Order by e.CreateDate desc")
    public List<ProductDetail> getAll1();
    @Query(value = "SELECT e.Id, e.Price, e.Discount, e.Description, e.CreateDate, e.UpdateDate, e.CreateBy, e.UpdateBy, e.Status, e.IdProduct, e.IdBrand, e.IdCategory, e.IdDesign, e.DiscountDate\n" +
            "            FROM ProductDetail e\n" +
            "           JOIN BillDetail bd ON bd.IdProductDetail = e.Id\n" +
            "            JOIN Bill b ON b.Id = bd.IdOrder\n" +
            "            WHERE e.Status = 0 AND b.Status = 3 AND b.PaymentDate >= DATEADD(DAY, -30, GETDATE()) \n" +
            "            GROUP BY e.Id, e.Price, e.Discount, e.Description, e.CreateDate, e.UpdateDate, e.CreateBy, e.UpdateBy, e.Status, e.IdProduct, e.IdBrand, e.IdCategory, e.IdDesign, e.DiscountDate\n" +
            "            ORDER BY SUM(bd.Quantity) DESC",nativeQuery = true)
    public List<ProductDetail> getAllBanChay();
    @Query(value = "Select e.Id,e.Price,e.Discount,e.Description,e.CreateDate,e.UpdateDate,e.CreateBy,e.UpdateBy,e.Status,e.IdProduct,e.IdBrand,e.IdCategory,e.IdDesign,e.DiscountDate from ProductDetail e \n" +
            "join Product p on p.Id = e.IdProduct\n" +
            "where e.Status = 0\n" +
            "and (p.Name like :name) OR (p.Code like :name)" , nativeQuery = true)
    public List<ProductDetail> getAllByProductName(@Param("name") String name);

    @Query("Select e from ProductDetail  e where e.product.Code = :code")
    public ProductDetail getByCode(@Param("code") String code);
    @Query(value = "SELECT e FROM ProductDetail e " +
            "WHERE e.Status = 0 " +
            "AND (e.category.Id = :id OR e.brand.Id = :idBrand OR e.design.Id = :idDesign) " +
            "AND e.Id <> :idProduct " +
            "ORDER BY e.CreateDate DESC")
    public List<ProductDetail> getProductByCategory(@Param("id") Integer id,
                                                    @Param("idBrand") Integer idBrand,
                                                    @Param("idDesign") Integer idDesign,
                                                    @Param("idProduct") Integer idProduct);
    @Query(value = "Select SUM(b.Quantity) from BillDetail b \n" +
            "join Bill  c on c.Id = b.bill.Id \n" +
            "where b.productDetail.Id = :id and c.Status = 3")
    public Integer quantitySold(@Param("id") Integer id);
    @Query(value = "Select SUM (b.Quantity * b.UnitPrice) from BillDetail b \n" +
            "join Bill  c on c.Id = b.bill.Id \n" +
            "where b.productDetail.Id = :id and c.Status = 3")
    public Double totalSale(@Param("id") Integer id);
    @Query(value = "Select e from Voucher e \n" +
            "where e.IsVoucher = true\n" +
            "and e.Status = 0")
    public List<Voucher> getVoucher();

    @Query(value = "Select e from Voucher  e " +
            "where e.Status = 0")
    public List<Voucher> getAllVoucher();

    @Modifying
    @Transactional
    @Query(value = "Update ProductDetail set Discount = 0 , DiscountDate = null WHERE DiscountDate <= GETDATE() + 1",nativeQuery = true)
    public void updateDiscount();

}
