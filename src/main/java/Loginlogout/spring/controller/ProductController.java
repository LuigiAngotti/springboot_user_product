package Loginlogout.spring.controller;

import Loginlogout.spring.dto.ProductDTO;
import Loginlogout.spring.entity.User;
import Loginlogout.spring.mapper.UserMapper;
import Loginlogout.spring.service.ProductService;
import Loginlogout.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ProductDTO>> getProductsByUserId(@PathVariable Long userId) {
        return new ResponseEntity<>(productService.getProductsByUserId(userId), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createProduct(@RequestBody ProductDTO productDTO) {



        productDTO.setUser(userMapper.toDto((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()));
        productService.saveProduct(productDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        productDTO.setId(id);
        productService.updateProduct(productDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}