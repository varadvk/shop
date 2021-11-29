package com.eclinical.shop.model;

public class Order {

    private Integer orderId;
    private Product product;
    private Integer productQuantity;
    private Double orderAmount;
    private String orderStatus;

    public Order(Integer orderId, Product product, Integer productQuantity, Double orderAmount, String orderStatus) {
        this.orderId = orderId;
        this.product = product;
        this.productQuantity = productQuantity;
        this.orderAmount = orderAmount;
        this.orderStatus = orderStatus;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "product=" + product +
                ", productQuantity=" + productQuantity +
                ", orderAmount=" + orderAmount +
                '}';
    }
}
