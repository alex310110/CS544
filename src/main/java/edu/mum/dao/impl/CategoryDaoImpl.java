package edu.mum.dao.impl;

import edu.mum.domain.Category;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDaoImpl extends GenericDaoImpl<Category> implements edu.mum.dao.CategoryDao {
    public CategoryDaoImpl() {
        super.setDaoType(Category.class );

    }
}
