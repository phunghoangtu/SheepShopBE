package com.sheepshop.services;

import com.sheepshop.entitys.Cart;
import com.sheepshop.entitys.CartDetail;
import com.sheepshop.entitys.Customer;
import com.sheepshop.entitys.ProductDetail;
import com.sheepshop.model.req.CartDetailRequest;
import com.sheepshop.model.req.CartRequest;
import com.sheepshop.repositorys.CartDetailRepository;
import com.sheepshop.repositorys.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartDetailService {
    @Autowired
    private CartDetailRepository repository;
    @Autowired
    private CartRepository cartRepository;
    public List<CartDetail> getCartByCustomer(Integer Id){
        return repository.getCartByCustomer(Id);
    }
    public void deleteAllCart(Integer Id){
        List<CartDetail> cartDetails = repository.getCartByCustomer(Id);
        for (CartDetail cartDetail: cartDetails) {
            repository.delete(cartDetail);
        }
    }
    public CartDetail addToCart(CartDetailRequest request){
        CartDetail cartDetail = new CartDetail();
        cartDetail.setCart(Cart.builder().Id(request.getIdCart()).build());
        cartDetail.setProductDetail(ProductDetail.builder().Id(request.getIdProductDetail()).build());
        cartDetail.setIdColor(request.getIdColor());
        cartDetail.setIdSize(request.getIdSize());
        cartDetail.setQuantity(request.getQuantity());
        cartDetail.setUnitPrice(request.getUnitPrice());
        return repository.save(cartDetail);
    }
    public void deleteToCart(Integer Id){
        CartDetail cartDetail = repository.getById(Id);
         repository.delete(cartDetail);
    }
    public CartDetail updateToCart(CartDetailRequest request , Integer id){
        CartDetail cartDetail = repository.getById(id);
        cartDetail.setCart(Cart.builder().Id(request.getIdCart()).build());
        cartDetail.setProductDetail(ProductDetail.builder().Id(request.getIdProductDetail()).build());
        cartDetail.setIdColor(request.getIdColor());
        cartDetail.setIdSize(request.getIdSize());
        cartDetail.setQuantity(request.getQuantity());
        cartDetail.setUnitPrice(request.getUnitPrice());
        return repository.save(cartDetail);
    }
    public Integer getQuantityByCartDetail(Integer id){
        return repository.getQuantityByCartDetail(id);
    }

    public Cart getByIdCart(Integer id){
        return cartRepository.getByIdCart(id);
    }
    public Cart getByIdCustomer(Integer id){
        return cartRepository.getByIdCustomer(id);
    }

    public  Cart addCart(CartRequest
                         request){
        Cart cart = new Cart();
        cart.setCustomer(Customer.builder().Id(request.getIdCustomer()).build());
        return cartRepository.save(cart);
    }


}
