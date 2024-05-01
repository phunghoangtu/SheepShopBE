package com.sheepshop.services;

import com.sheepshop.entitys.Color;
import com.sheepshop.entitys.ProductDetail;
import com.sheepshop.entitys.ProductdetailColorSize;
import com.sheepshop.entitys.Size;
import com.sheepshop.model.req.ProductDetail_Size_ColorRequest;
import com.sheepshop.model.resp.ProductDetailResponse;
import com.sheepshop.repositorys.ProductDetail_Size_ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDetail_Size_ColorService {
    @Autowired
    private ProductDetail_Size_ColorRepository repository;

    public List<ProductdetailColorSize> getByColor(Integer IdProduct, Integer IdColor){
        return repository.getAllByIdProductAndIdColor(IdProduct,IdColor);
    }
    public List<ProductDetailResponse> getAll(){
        return repository.getAll();
    }
    public List<ProductDetailResponse> getAllByNameAndCodeProduct(String keyword,Integer idColor,Integer IdSize){
        String key = null;
        if(keyword != null){
            key = '%'+keyword+'%';
        }
        return repository.getAllByNameAndCodeProduct(key,idColor,IdSize);
    }
    public ProductDetailResponse getByIdd(Integer id){
        return repository.getByIdd(id);
    }

    public ProductdetailColorSize add(ProductDetail_Size_ColorRequest request){
        ProductdetailColorSize productDetail_size_color = new ProductdetailColorSize();
        productDetail_size_color.setProductDetail(ProductDetail.builder().id(request.getIdProductDetail()).build());
        productDetail_size_color.setColor(Color.builder().id(request.getIdColor()).build());
        productDetail_size_color.setSize(Size.builder().id(request.getIdSize()).build());
        productDetail_size_color.setQuantity(request.getQuantity());
        return repository.save(productDetail_size_color);
    }
    public ProductdetailColorSize updateQuantity(Integer id,Integer IdColor, Integer IdSize,Integer quanity){
        ProductdetailColorSize productDetail_size_color =repository.getByProductAndColorAndSize(id,IdColor,IdSize);
        productDetail_size_color.setQuantity(quanity);
        return repository.save(productDetail_size_color);
    }

    public void delete(Integer idProductDetail){
        List<ProductdetailColorSize> list = repository.getAllById(idProductDetail);
        for(ProductdetailColorSize p : list){
            repository.delete(p);
        }
    }

    public Integer getQuantityByProduct(Integer id){
        return repository.getQuantityByProduct(id);
    }
    public Integer getQuantityByProductAndColor(Integer id,Integer IdColor){
        return repository.getQuantityByProductAndColor(id,IdColor);
    }
    public Integer getQuantityByProductAndColorAndSize(Integer id,Integer IdColor, Integer IdSize){
        return repository.getQuantityByProductAndColorAndSize(id,IdColor,IdSize);
    }
    public List<ProductDetailResponse> getByProduct(Integer id){
        return repository.getByProduct(id);
    }

}
