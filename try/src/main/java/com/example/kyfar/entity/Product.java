package com.example.kyfar.entity;

import com.example.kyfar.validation.Validation;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;


    private String title;
    private String description;
    private String price;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User owner;

    public Product() {
    }

    public Product(String title, User owner) {
        this.title = title;
        this.owner = owner;
    }

    public Product(String price, String title) {
        this.title = title;
        this.price = price;
    }

    public Product(String price) {
        this.price = price;
    }

    public Product(String title, String description, String price, User owner) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.owner = owner;
    }

    public String getOwnerName() {
        return owner != null ? owner.getUsername() : "<none>";
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public boolean setTitle(String title) {
        if (Validation.isValidTitle(title)) {
            this.title = title;
            return true;
        }
        return false;
    }

    public String getDescription() {
        return description;
    }

    public boolean setDescription(String description) {
        if (Validation.isValidDescription(description)) {
            this.description = description;
            return true;
        }
        return false;
    }

    public String getPrice() {
        return price;
    }

    public boolean setPrice(String price) {
        if (Validation.isValidPrice(price)) {
            this.price = price;
            return true;
        }
        return false;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(title, product.title) &&
                Objects.equals(description, product.description) &&
                Objects.equals(price, product.price) &&
                Objects.equals(owner, product.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, price, owner);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", owner=" + owner +
                '}';
    }
}

