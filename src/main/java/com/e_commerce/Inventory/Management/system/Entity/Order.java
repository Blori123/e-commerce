package com.e_commerce.Inventory.Management.system.Entity;

import com.e_commerce.Inventory.Management.system.Enums.OrderStatus;
import com.e_commerce.Inventory.Management.system.Enums.PaymentStatus;
import com.mysql.cj.protocol.ColumnDefinition;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="orders_table")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime orderDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="customer_id")
    private Customer customer;

    private Double totalAmount;


    @Enumerated(EnumType.STRING)
    @Column(name="order_status", columnDefinition ="ENUM('NEW')")
    private OrderStatus orderStatus;

    @Enumerated(EnumType.STRING)
    @Column(name="payment_status")
    private PaymentStatus paymentStatus;

    @CreationTimestamp
    @Column(name="created_at")
    private LocalDateTime createdAt;

    @CreationTimestamp
    @Column(name="updated_at")
    private LocalDateTime updatedAt;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
