package com.e_commerce.Inventory.Management.system.Dto;

public class OrderItemDto {

    private Long productId;
    private Long orderId;
    private Integer quantity;

    public OrderItemDto(Long productId, Long orderId, Integer quantity) {
        this.productId = productId;
        this.orderId = orderId;
        this.quantity = quantity;
    }
    public OrderItemDto() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
