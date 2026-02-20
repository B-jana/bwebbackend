package com.example.demo.serv;


import java.nio.file.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Product;
import com.example.demo.repo.ProductRepository;


@Service
public class  ProductService {

    private static final String UPLOAD_DIR = "uploads/";

    @Autowired
    private ProductRepository repo;

 
    public Product addProduct(String name,
                              Double price,
                              String description,
                              MultipartFile image) throws Exception {

        String fileName = System.currentTimeMillis() + "_" + image.getOriginalFilename();

        Path filePath = Paths.get(UPLOAD_DIR + fileName);
        Files.createDirectories(filePath.getParent());
        Files.write(filePath, image.getBytes());

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setDescription(description);
        product.setImageName(fileName);

        return repo.save(product);
    }

  
    public List<Product> getAllProducts() {
        return repo.findAll();
    }


    public void deleteProduct(Long id) {
        repo.deleteById(id);
    }
}

