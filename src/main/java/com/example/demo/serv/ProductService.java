package com.example.demo.serv;


import java.nio.file.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Product;
import com.example.demo.repo.ProductRepository;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.util.Map;


@Service
public class  ProductService {

    

    @Autowired
    private ProductRepository repo;

    @Autowired
private Cloudinary cloudinary;
 
    public Product addProduct(String name,
                          Double price,
                          String description,
                          MultipartFile image) throws Exception {

    // 🔥 Upload image to Cloudinary
    Map uploadResult = cloudinary.uploader().upload(
            image.getBytes(),
            ObjectUtils.emptyMap()
    );

    String imageUrl = uploadResult.get("secure_url").toString();

    // 🔥 Save product with Cloudinary URL
    Product product = new Product();
    product.setName(name);
    product.setPrice(price);
    product.setDescription(description);
    product.setImageUrl(imageUrl);   // IMPORTANT CHANGE

    return repo.save(product);
}

  
    public List<Product> getAllProducts() {
        return repo.findAll();
    }


    public void deleteProduct(Long id) {
        repo.deleteById(id);
    }
}


