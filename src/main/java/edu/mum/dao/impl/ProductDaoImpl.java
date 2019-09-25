package edu.mum.dao.impl;

import edu.mum.domain.Category;
import edu.mum.domain.Product;
import edu.mum.domain.Seller;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class ProductDaoImpl extends GenericDaoImpl<Product> implements edu.mum.dao.ProductDao {

    public ProductDaoImpl() {
        super.setDaoType(Product.class );
    }

    @Override
    public List<Product> findProductsByCategory(Category category) {
        Query query = entityManager.createQuery("select p from Product p where p.category = :category ");
        return (List<Product>) query.setParameter("category", category).getResultList();
    }

    @Override
    public List<Product> findProductsBySeller(Seller seller) {
        Query query = entityManager.createQuery("select p from Product p where p.seller = :seller ");
        return (List<Product>) query.setParameter("seller", seller).getResultList();
    }

    @Override
    public List<Product> findProductsByName(String name) {
        Query query = entityManager.createQuery("select p from Product p where p.name = :name ");
        return (List<Product>) query.setParameter("name", name).getResultList();
    }
}
