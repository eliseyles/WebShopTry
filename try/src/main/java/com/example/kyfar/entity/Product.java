package com.example.kyfar.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "pls fill title")
    @Length(max = 20, min = 2)
    private String title;
    private Category category;
    private String description;
    private double price;
    private Location location;
    private String name;
    private String phone;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User owner;

    public Product() {
    }

    public Product(String title, User owner) {
        this.title = title;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 &&
                Objects.equals(id, product.id) &&
                Objects.equals(title, product.title) &&
                category == product.category &&
                Objects.equals(description, product.description) &&
                location == product.location &&
                Objects.equals(name, product.name) &&
                Objects.equals(phone, product.phone) &&
                Objects.equals(owner, product.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, category, description, price, location, name, phone, owner);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", category=" + category +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", location=" + location +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", owner=" + owner +
                '}';
    }
}

