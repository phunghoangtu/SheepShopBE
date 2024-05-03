package com.sheepshop.services;


import com.sheepshop.entitys.Material;
import com.sheepshop.entitys.ProductDetail;
import com.sheepshop.entitys.ProductdetailMaterial;
import com.sheepshop.model.req.ProductDetail_MaterialRequest;
import com.sheepshop.repositorys.ProductDetail_MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDetail_MaterialService {
    @Autowired
    private ProductDetail_MaterialRepository repository;

    public ProductdetailMaterial add(ProductDetail_MaterialRequest request){
        ProductdetailMaterial productDetail_material = new ProductdetailMaterial();
        productDetail_material.setProductDetail(ProductDetail.builder().Id(request.getIdProductDetail()).build());
        productDetail_material.setMaterial(Material.builder().Id(request.getIdMaterial()).build());
        return repository.save(productDetail_material);
    }
    public void delete(Integer idProductDetail){
        List<ProductdetailMaterial> list = repository.getAllById(idProductDetail);
        for(ProductdetailMaterial p : list){
            repository.delete(p);
        }
    }

    public ProductdetailMaterial getById(Integer id) {
        return repository.findById(id).get();
    }
}
