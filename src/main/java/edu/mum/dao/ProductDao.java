package edu.mum.dao;

import edu.mum.domain.Category;
import edu.mum.domain.Product;
import edu.mum.domain.Seller;

import java.util.List;

public interface ProductDao extends GenericDao<Product> {
    List<Product> findProductsByCategory(Category category);
    List<Product> findProductsBySeller(Seller seller);
    List<Product> findProductsByName(String name);
}
