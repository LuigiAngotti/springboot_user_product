package Loginlogout.spring.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int price;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private User user;

}
