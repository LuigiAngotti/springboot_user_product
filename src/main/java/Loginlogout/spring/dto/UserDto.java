package Loginlogout.spring.dto;


import Loginlogout.spring.entity.Product;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {

    private Long id;
    private String username;
    private String password;


}
