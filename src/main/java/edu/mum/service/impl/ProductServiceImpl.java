package edu.mum.service.impl;

import edu.mum.dao.ProductDao;
import edu.mum.domain.Category;
import edu.mum.domain.Product;
import edu.mum.domain.Seller;
import edu.mum.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> getAll() {
        return (List<Product>) productDao.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productDao.findOne(id);
    }

    @Override
    public Product save(Product product) {
        return productDao.save(product);
    }

    @Override
    public void delete(Product product) {
        productDao.delete(product.getId());
    }

    @Override
    public List<Product> getProductsByCategory(Category category) {
        return productDao.findProductsByCategory(category);
    }

    @Override
    public List<Product> getProductsBySeller(Seller seller) {
        return productDao.findProductsBySeller(seller);
    }

    @Override
    public List<Product> getProductsByName(String name) {
        return productDao.findProductsByName(name);
    }
}
