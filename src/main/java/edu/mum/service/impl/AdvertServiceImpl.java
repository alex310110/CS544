package edu.mum.service.impl;

import edu.mum.dao.AdvertDao;
import edu.mum.domain.Advert;
import edu.mum.service.AdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertServiceImpl implements AdvertService {
    @Autowired
    AdvertDao advertDao;

    @Override
    public List<Advert> getAll() {
        return (List<Advert>)advertDao.findAll();
    }

    @Override
    public Advert saveAdvert(Advert advert) {
        return advertDao.save(advert);
    }

    @Override
    public List<Advert> getAdverts() {
        return (List<Advert>) advertDao.findAll();
    }

    @Override
    public Advert getAdvertById(Long id) {
        return advertDao.findOne(id);
    }

    @Override
    public void deleteAdvert(Advert advert) {
        advertDao.delete(advert.getId());
    }


}
