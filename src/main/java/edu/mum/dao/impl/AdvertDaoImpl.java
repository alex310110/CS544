package edu.mum.dao.impl;

import edu.mum.domain.Advert;
import org.springframework.stereotype.Repository;

@Repository
public class AdvertDaoImpl extends GenericDaoImpl<Advert> implements edu.mum.dao.AdvertDao {
    public AdvertDaoImpl() {
        super.setDaoType(Advert.class );
    }
}
