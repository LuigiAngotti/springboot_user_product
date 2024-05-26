package Loginlogout.spring.service;

import Loginlogout.spring.dto.ProductDTO;
import Loginlogout.spring.mapper.ProductMapper;

import Loginlogout.spring.repository.ProductRepository;
import Loginlogout.spring.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public List<ProductDTO> getAllProducts() {
        return productMapper.toDtoList(productRepository.findAll());
    }

    @Transactional
    public ProductDTO getProductById(Long id) {
        return productMapper.toDto(productRepository.findById(id).orElse(null));
    }

    @Transactional
    public void saveProduct(ProductDTO productDTO) {
        productRepository.save(productMapper.toEntity(productDTO));
    }

    @Transactional
    public void updateProduct(ProductDTO productDTO) {
        productRepository.save(productMapper.toEntity(productDTO));
    }


    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Transactional
    public List<ProductDTO> getProductsByUserId(Long userId) {
        return productMapper.toDtoList(productRepository.findAllByUserId(userId));
    }
}