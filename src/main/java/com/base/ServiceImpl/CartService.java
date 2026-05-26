package com.base.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.base.models.*;
import com.base.Repository.*;

@Service
public class CartService {

    private final FoodOrderRepository orderRepo;
    private final OderItemRepository itemRepo;
    private final FoodItemRepository foodRepo;
    private final UserRepository userRepo;

    public CartService(FoodOrderRepository orderRepo,
                       OderItemRepository itemRepo,
                       FoodItemRepository foodRepo,
                       UserRepository userRepo) {
        this.orderRepo = orderRepo;
        this.itemRepo = itemRepo;
        this.foodRepo = foodRepo;
        this.userRepo = userRepo;
    }

    // ✅ Create / Get Cart
    public FoodOrder getCart(Long userId) {

        Optional<FoodOrder> cart =
                orderRepo.findByUser_IdAndStatus(userId, "CART");

        if (cart.isPresent()) {
            return cart.get();
        }

        User user = userRepo.findById(userId).orElseThrow();

        FoodOrder newCart = new FoodOrder();
        newCart.setUser(user);
        newCart.setStatus("CART");
        newCart.setTotalamount(0);

        return orderRepo.save(newCart);
    }

    // ✅ Add Item
    public FoodOrder addItem(Long userId, Long foodId, int qty) {

        FoodOrder cart = getCart(userId);

        FoodItem food = foodRepo.findById(foodId).orElseThrow();

        OderItem item = new OderItem();
        item.setOrder(cart);
        item.setFoodItem(food);
        item.setQuantity(qty);
        item.setPrice(food.getPrice());

        itemRepo.save(item);

        updateTotal(cart);

        return orderRepo.save(cart);
    }

    // ✅ View Cart
    public FoodOrder viewCart(Long userId) {
        return orderRepo.findByUser_IdAndStatus(userId, "CART")
                .orElse(null);
    }

    // ✅ Remove Item
    public FoodOrder removeItem(Long userId, Long itemId) {

        FoodOrder cart = getCart(userId);

        itemRepo.deleteById(itemId);

        updateTotal(cart);

        return orderRepo.save(cart);
    }

    // ✅ Checkout
    public FoodOrder checkout(Long userId) {

        FoodOrder cart = orderRepo
                .findByUser_IdAndStatus(userId, "CART")
                .orElseThrow();

        cart.setStatus("PLACED");

        return orderRepo.save(cart);
    }

    // ✅ Update Total
    private void updateTotal(FoodOrder cart) {

        List<OderItem> items =
                itemRepo.findByOrder_Id(cart.getId());

        double total = 0;

        for (OderItem i : items) {
            total += i.getPrice() * i.getQuantity();
        }

        cart.setTotalamount(total);
    }
}