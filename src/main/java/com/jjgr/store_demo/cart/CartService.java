package com.jjgr.store_demo.cart;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class CartService {
    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository){
        this.cartRepository = cartRepository;
    }

    //GET all
    public List<Cart> getCarts(){
        return cartRepository.findAll();
    }

    //POST
    public void addCart(Cart cart){
        Optional<Cart> cartIsPresent = cartRepository.findById(cart.getId());

        if(cartIsPresent.isPresent()){
            throw new IllegalStateException("Id is already taken");
        }
        cartRepository.save(cart);
    }

    //DELETE
    public void deleteCart(Long id){
        boolean cartExists = cartRepository.existsById(id);
        if(cartExists){
            throw new IllegalStateException("Cart with id "+id+"does not exist");
        }
        cartRepository.deleteById(id);
    }
}
