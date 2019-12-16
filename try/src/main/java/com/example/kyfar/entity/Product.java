package com.example.kyfar.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String title;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User owner;
//    private double price;
//    private Location location;
//    private String name;
//    private String phoneNumber;
    //    private User owner;
    //    private Category category;
//    private String description;

//    public Product(Integer id, User owner, String title, String description, double price, String name, String phoneNumber) {
//        this.id = id;
//        this.owner = owner;
//        this.title = title;
//        this.description = description;
//        this.price = price;
//        this.name = name;
//        this.phoneNumber = phoneNumber;
//    }
//

    public Product() {
    }

    public Product(String title, User owner) {
        this.title = title;
        this.owner = owner;
//        this.price = price;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(title, product.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}

