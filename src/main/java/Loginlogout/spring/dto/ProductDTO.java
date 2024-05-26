package Loginlogout.spring.dto;


import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private int price;
    private UserDto user;
}
