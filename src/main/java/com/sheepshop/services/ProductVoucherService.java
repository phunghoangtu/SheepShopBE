package com.sheepshop.services;

import com.sheepshop.entitys.Product;
import com.sheepshop.entitys.ProductVoucher;
import com.sheepshop.entitys.Voucher;
import com.sheepshop.model.req.ProductVoucherRequest;
import com.sheepshop.repositorys.ProductVoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductVoucherService {
    @Autowired
    private ProductVoucherRepository repository;

    public ProductVoucher add(ProductVoucherRequest request){
        ProductVoucher product_voucher = new ProductVoucher();
        product_voucher.setVoucher(Voucher.builder().Id(request.getIdVoucher()).build());
        product_voucher.setProduct(Product.builder().Id(request.getIdProduct()).build());
        return  repository.save(product_voucher);
    }
    public void delete(Integer id){
        List<ProductVoucher> product_vouchers = repository.getByProduct(id);
        for (ProductVoucher product_voucher: product_vouchers) {
            repository.delete(product_voucher);
        }
    }
    public List<ProductVoucher> getAllByProduct(Integer id){
        return repository.getByProduct(id);
    }

}
