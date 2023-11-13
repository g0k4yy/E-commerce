package com.ecommerce.ecommerce.repository;

import com.ecommerce.ecommerce.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

   // @LocalServerPort
   // private int port;

    @Test
    public void testAddProduct() throws InterruptedException {

        //System.out.println("Application started on port: " + port);

        // Create a new product
        Product product = new Product();
        product.setName("Sample Product");
        product.setDescription("This is a sample product");
        product.setPrice(19.99);

        // Save the product to the database
        Product savedProduct = productRepository.save(product);

        // Assertions
        assertNotNull(savedProduct.getId());
        assertEquals("Sample Product", savedProduct.getName());
        assertEquals("This is a sample product", savedProduct.getDescription());
        assertEquals(19.99, savedProduct.getPrice());

        Thread.sleep(10);

    }
}
