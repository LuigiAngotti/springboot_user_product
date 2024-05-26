package Loginlogout.spring.service;



import Loginlogout.spring.dto.UserDto;

import Loginlogout.spring.entity.User;
import Loginlogout.spring.mapper.UserMapper;
import Loginlogout.spring.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class UserService implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Transactional
    public UserDto registerUser(UserDto userDTO) {
        User user = userMapper.toEntity(userDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return userMapper.toDto(user);
    }
    @Transactional
    public boolean authenticateUser(UserDto userDTO) {
        User user = userRepository.findByUsername(userDTO.getUsername());
        System.out.println(userDTO.getPassword()+" "+user.getPassword());
        return passwordEncoder.matches(userDTO.getPassword(), user.getPassword());
    }
    @Transactional
    public UserDto getUserByUsername(String username) {

        return userMapper.toDto(userRepository.findByUsername(username));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;

    }
}
