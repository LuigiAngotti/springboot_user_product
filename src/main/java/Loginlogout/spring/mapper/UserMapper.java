package Loginlogout.spring.mapper;

import Loginlogout.spring.dto.UserDto;
import Loginlogout.spring.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {


    public User toEntity(UserDto dto)
    {
        if (dto == null) {
            // Gestisci il caso in cui l'utente è null
            return null;
        }
     User user=new User();
     user.setUsername(dto.getUsername());
     user.setPassword(dto.getPassword());
     user.setId(dto.getId());

     return user;

    }

    public UserDto toDto(User entity)
    {
        if (entity == null) {
            // Gestisci il caso in cui l'utente è null
            return null;
        }
        UserDto userdto=new UserDto();
        System.out.println(entity.getId());
        userdto.setId(entity.getId());
        userdto.setPassword(entity.getPassword());
        userdto.setUsername(entity.getUsername());

        return userdto;
    }
}
