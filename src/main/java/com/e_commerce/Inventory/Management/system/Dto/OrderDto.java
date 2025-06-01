package com.e_commerce.Inventory.Management.system.Dto;

import com.e_commerce.Inventory.Management.system.Entity.Customer;
import com.e_commerce.Inventory.Management.system.Enums.OrderStatus;

public class OrderDto {

    private Customer customer;

    private OrderStatus orderStatus;

    public OrderDto(Customer customer, OrderStatus orderStatus) {
        this.customer = customer;
        this.orderStatus = orderStatus;
    }
    public OrderDto() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
