package com.e_commerce.Inventory.Management.system.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(min=3, max=100, message = "Emri duhet midis 3 dhe 100 karaktereve")
    private String name;

    @Size(min=3,max=100, message = "description duhet midis 3 dhe 100 karaktereve")
    private  String description;

    @Min(1)
    private Long price;

    @Min(0)
    private Long stockQuantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category")
    private Category category;

    @Column(name="created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "Name is mandatory") @Size(min = 3, max = 100, message = "Emri duhet midis 3 dhe 100 karaktereve") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Name is mandatory") @Size(min = 3, max = 100, message = "Emri duhet midis 3 dhe 100 karaktereve") String name) {
        this.name = name;
    }

    public @Size(min = 3, max = 100, message = "description duhet midis 3 dhe 100 karaktereve") String getDescription() {
        return description;
    }

    public void setDescription(@Size(min = 3, max = 100, message = "description duhet midis 3 dhe 100 karaktereve") String description) {
        this.description = description;
    }

    public @Min(1) Long getPrice() {
        return price;
    }

    public void setPrice(@Min(1) Long price) {
        this.price = price;
    }

    public @Min(0) Long getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(@Min(0) Long stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
