package com.example.dddstart.order;

import com.example.dddstart.product.Product;

// OrderLine
// 구매 항목
public class ProductOrder {

    private Product product;
    private Money price;    // 가격
    private int quantity; // 개수
    private Money amounts;  // 구매 수량 (price * quantity)

    public ProductOrder(final Product product, final Money price, final int quantity) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.amounts = calculateAmounts();
    }

    private Money calculateAmounts() {
        return price.multiply(quantity);
    }

    public int getAmounts() {

    }
}
