package com.sheepshop.repositorys;

import com.sheepshop.entitys.ProductdetailColorSize;
import com.sheepshop.model.resp.ProductDetailResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDetail_Size_ColorRepository extends JpaRepository<ProductdetailColorSize ,Integer> {
    @Query(value = "Select e from ProductdetailColorSize  e where  e.productDetail.id =:id")
    List<ProductdetailColorSize> getAllById(@Param("id") Integer id);
    @Query(value = "Select p from ProductdetailColorSize p \n" +
            "where p.productDetail.id= :idProduct and p.color.id= :idColor")
    List<ProductdetailColorSize> getAllByIdProductAndIdColor(@Param("idProduct") Integer IdProduct, @Param(("idColor")) Integer IdColor);

    @Query(value = "Select SUM(p.quantity) from ProductdetailColorSize p\n" +
            "where p.productDetail.id = :id")
    Integer getQuantityByProduct(@Param("id") Integer id);
    @Query(value = "Select SUM(p.quantity) from ProductdetailColorSize p\n" +
            "where p.productDetail.id = :id and p.color.id = :idcolor")
    Integer getQuantityByProductAndColor(@Param("id") Integer id,@Param("idcolor") Integer idcolor);
    @Query(value = "Select SUM(p.quantity) from ProductdetailColorSize p\n" +
            "where p.productDetail.id = :id and p.color.id = :idcolor and p.size.id = :idsize and p.productDetail.status = 0")
    Integer getQuantityByProductAndColorAndSize(@Param("id") Integer id,@Param("idcolor") Integer idcolor,@Param("idsize") Integer idsize);
    @Query(value = "Select p from ProductdetailColorSize p\n" +
            "where p.productDetail.id = :id and p.color.id = :idcolor and p.size.id = :idsize")
    ProductdetailColorSize getByProductAndColorAndSize(@Param("id") Integer id,@Param("idcolor") Integer idcolor,@Param("idsize") Integer idsize);

    @Query(value = "Select pdcz.Id,p.Code, p.Name ,s.Name as NameSize,c.Name as NameColor,pdcz.Quantity ,pd.Price\n" +
            "from ProductDetail_Color_Size pdcz\n" +
            "     join Product_Detail pd on pdcz.IdProductDetail = pd.Id\n" +
            "     join Product p on pd.IdProduct = p.Id\n" +
            "     join Color c on pdcz.IdColor = c.Id\n" +
            "     join Size s on pdcz.IdSize = s.Id\n" +
            "where pd.Status = 0 order by pd.CreateDate desc", nativeQuery = true)
    List<ProductDetailResponse> getAll();

    @Query(value = "Select p.Id,p.IdProductDetail,p.IdColor,p.IdSize,p.Quantity from ProductDetail_Color_Size p \n" +
            " join ProductDetail c on p.IdProductDetail = c.Id\n" +
            " where c.Status = 0 and p.Id = :id order by c.CreateDate desc", nativeQuery = true)
    public ProductDetailResponse getByIdd(@Param("id") Integer id);
    @Query(value = "Select p.Id,p.IdProductDetail,p.IdColor,p.IdSize,p.Quantity from ProductDetail_Color_Size p \n" +
            "  join ProductDetail c on p.IdProductDetail = c.Id \n" +
            " join Product pro on pro.Id = c.IdProduct\n" +
            " where c.Status = 0 and (pro.Code like :keyword or pro.Name like :keyword or :keyword is null) and (p.IdColor = :idColor or :idColor is null) and (p.IdSize = :idSize or :idSize is null)  order by c.CreateDate asc", nativeQuery = true)
    List<ProductDetailResponse> getAllByNameAndCodeProduct(@Param("keyword") String keyword, @Param("idColor") Integer idColor , @Param("idSize") Integer idSize);

    @Query(value = "Select p.Id,p.IdProductDetail,p.IdColor,p.IdSize,p.Quantity from ProductDetail_Color_Size p \n" +
            "join ProductDetail c on p.IdProductDetail = c.Id where c.Id = :id", nativeQuery = true)
    List<ProductDetailResponse> getByProduct(@Param("id") Integer id);


}
