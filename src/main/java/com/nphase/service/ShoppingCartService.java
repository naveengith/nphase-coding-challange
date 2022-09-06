package com.nphase.service;

import com.nphase.entity.ShoppingCart;

import javax.naming.OperationNotSupportedException;
import java.math.BigDecimal;

public class ShoppingCartService {

    public BigDecimal calculateTotalPrice(ShoppingCart shoppingCart) {
        return shoppingCart.getProducts()
                .stream()
                .map(product -> product.getPricePerUnit().multiply(BigDecimal.valueOf(product.getQuantity())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    public BigDecimal calculateTotalBulkPrice(ShoppingCart shoppingCart) {

        List<Product> products = shoppingCart.getProducts();

        product p1 = products.get(1);
        product p2 = products.get(2);

        BigDecimal total1 =   p1.getPricePerUnit() * p1.getQuantity();
        BigDecimal total2 =   p2.getPricePerUnit() * p2.getQuantity();

        if(p1.getQuantity() >3){
             total1 =   total1 *0.9;
        }
        if(p2.getQuantity() >3){
            total2 =   total2 *0.9;
        }



        return total1 + total2;
    }

    public BigDecimal calculateTotalPriceByCategory(ShoppingCart shoppingCart) {

        List<Product> products = shoppingCart.getProducts();

        product p1 = products.get(1);
        product p2 = products.get(2);
        product p3 = products.get(3);

        BigDecimal total1 =   p1.getPricePerUnit() * p1.getQuantity();
        BigDecimal total2 =   p2.getPricePerUnit() * p2.getQuantity();
        BigDecimal total3 =   p3.getPricePerUnit() * p3.getQuantity();

        String category = p1.getPricePerUnit() * p1.getCategory();
        int p1categoryCount = 0;
        int p2categoryCount = 0;
        int p3categoryCount = 0;

        if(p1.getCategory().equels(p2.getCategory())){
            p1categoryCount = p1.getQuantity() +p2.getQuantity();
            if(p1categoryCount >3){
                total1 =   total1 *0.9;
                total2 =   total2 *0.9;
            }
        }

        if(p2.getCategory().equels(p3.getCategory())){
            p2categoryCount = p2.getQuantity() +p3.getQuantity();
            if(p2categoryCount >3){
                total2 =   total2 *0.9;
                total3 =   total3 *0.9;
            }
        }

        if(p1.getCategory().equels(p3.getCategory())){
            p3categoryCount = p1.getQuantity() +p3.getQuantity();
            if(p3categoryCount >3){
                total3 =   total3 *0.9;
                total1 =   total1 *0.9;
            }
        }

        return total1 + total2 + total3;
    }

    public BigDecimal calculateTotalPriceConfigarable(ShoppingCart shoppingCart,BigDecimal discount) {

        List<Product> products = shoppingCart.getProducts();

        for (product:products) {
            BigDecimal total =   product.getPricePerUnit() * product.getQuantity();
            if(product.getQuantity() >3){
                total = total1 *discount;
            }
            total1 +=   total1;
        }


        return total;
    }

}
