package ru.gb.rest.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status = "not empty";

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinTable(name = "orders_product",
            joinColumns = @JoinColumn(name = "orders_id"),
            inverseJoinColumns = @JoinColumn(name = "orders_id"))
    private List<Product> products = new ArrayList<>();

    public boolean addProduct(Product product) {
        return products.add(product);
    }

    public void deleteProduct(Product product) {
        int itemp = -1;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(product.getId())){
                itemp = i;
                break;
            }
        }
        products.remove(itemp);
    }

    public List<Product> getProducts(){
        return products;
    }
}
