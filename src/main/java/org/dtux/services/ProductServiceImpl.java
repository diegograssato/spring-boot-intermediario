package org.dtux.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.dtux.entity.Product;
import org.dtux.entity.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepostory;

    public ProductServiceImpl(ProductRepository productRepostory) {
        this.productRepostory = productRepostory;
    }


    @Override
    public List<Product> findAll() {
        return this.productRepostory.findAll();
    }

    @Override
    public Product find(Long id) {
        return this.productRepostory.findById(id).orElse(null);
    }

    @Override
    public Product create(Product product) {
        this.productRepostory.save(product);
        return product;
    }

    @Override
    public Product update(Long id, Product product) {
        Product productExists = this.productRepostory.findById(id).orElse(null);

        if (productExists != null) {
            product.setId(productExists.getId());
            this.productRepostory.save(product);
            return product;
        }

        return null;
    }

    @Override
    public void delete(Long id) {
        Product product = this.productRepostory.findById(id).orElse(null);

        if (product != null) this.productRepostory.delete(product);
    }

}