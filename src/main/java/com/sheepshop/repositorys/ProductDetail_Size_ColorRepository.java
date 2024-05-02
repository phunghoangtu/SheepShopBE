package com.sheepshop.repositorys;

import com.sheepshop.entitys.ProductdetailColorSize;
import com.sheepshop.model.resp.ProductDetailResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDetail_Size_ColorRepository extends JpaRepository<ProductdetailColorSize,Integer> {

    @Query(value = "Select e from ProductdetailColorSize  e where  e.productDetail.Id =:id")
    List<ProductdetailColorSize> getAllById(@Param("id") Integer id);
    @Query(value = "Select p from ProductdetailColorSize p \n" +
            "where p.productDetail.Id= :idProduct and p.color.Id= :idColor")
    List<ProductdetailColorSize> getAllByIdProductAndIdColor(@Param("idProduct") Integer IdProduct, @Param(("idColor")) Integer IdColor);

    @Query(value = "Select SUM(p.Quantity) from ProductdetailColorSize p\n" +
            "where p.productDetail.Id = :id")
    Integer getQuantityByProduct(@Param("id") Integer id);
    @Query(value = "Select SUM(p.Quantity) from ProductdetailColorSize p\n" +
            "where p.productDetail.Id = :id and p.color.Id = :idcolor")
    Integer getQuantityByProductAndColor(@Param("id") Integer id,@Param("idcolor") Integer idcolor);
    @Query(value = "Select SUM(p.Quantity) from ProductdetailColorSize p\n" +
            "where p.productDetail.Id = :id and p.color.Id = :idcolor and p.size.Id = :idsize and p.productDetail.Status = 0")
    Integer getQuantityByProductAndColorAndSize(@Param("id") Integer id,@Param("idcolor") Integer idcolor,@Param("idsize") Integer idsize);
    @Query(value = "Select p from ProductdetailColorSize p\n" +
            "where p.productDetail.Id = :id and p.color.Id = :idcolor and p.size.Id = :idsize")
    ProductdetailColorSize getByProductAndColorAndSize(@Param("id") Integer id,@Param("idcolor") Integer idcolor,@Param("idsize") Integer idsize);

    @Query(value = "Select p.Id,p.IdProductDetail,p.IdColor,p.IdSize,p.Quantity from ProductDetail_Color_Size p \n" +
            " join ProductDetail c on p.IdProductDetail = c.Id\n" +
            " where c.Status = 0 order by c.CreateDate desc", nativeQuery = true)
    List<ProductDetailResponse> getAll();
    @Query(value = "Select p.Id,p.IdProductDetail,p.IdColor,p.IdSize,p.Quantity from ProductDetail_Color_Size p \n" +
            " join ProductDetail c on p.IdProductDetail = c.Id\n" +
            " where c.Status = 0 and p.Id = :id order by c.CreateDate desc", nativeQuery = true)
    ProductDetailResponse getByIdd(@Param("id") Integer id);
    @Query(value = "Select p.Id,p.IdProductDetail,p.IdColor,p.IdSize,p.Quantity from ProductDetail_Color_Size p \n" +
            "  join ProductDetail c on p.IdProductDetail = c.Id \n" +
            " join Product pro on pro.Id = c.IdProduct\n" +
            " where c.Status = 0 and (pro.Code like :keyword or pro.Name like :keyword or :keyword is null) and (p.IdColor = :idColor or :idColor is null) and (p.IdSize = :idSize or :idSize is null)  order by c.CreateDate asc", nativeQuery = true)
    List<ProductDetailResponse> getAllByNameAndCodeProduct(@Param("keyword") String keyword,@Param("idColor") Integer idColor , @Param("idSize") Integer idSize);

    @Query(value = "Select p.Id,p.IdProductDetail,p.IdColor,p.IdSize,p.Quantity from ProductDetail_Color_Size p \n" +
            "join ProductDetail c on p.IdProductDetail = c.Id where c.Id = :id", nativeQuery = true)
    List<ProductDetailResponse> getByProduct(@Param("id") Integer id);


}
