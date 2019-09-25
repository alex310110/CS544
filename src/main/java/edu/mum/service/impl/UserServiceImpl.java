package edu.mum.service.impl;

import edu.mum.dao.UserDao;
import edu.mum.domain.Message;
import edu.mum.domain.User;
import edu.mum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Boolean validatePassword(String password, User user) {
        return bCryptPasswordEncoder.matches(password, user.getPassword());
    }

    @Override
    public User addUser(User user) {
        String hashPassword = bCryptPasswordEncoder.encode(user.getPassword());
        // change to hashed password
        user.setPassword(hashPassword);
        user.setConfirmPassword(hashPassword);
        user.setRegisterDate(LocalDate.now());
        // persisted user to db.
        return userDao.save(user);
    }

    @Override
    public User updateUser(User user) {
        // does this user change the password.
        User existsUser = userDao.findOne(user.getId());
        boolean isMatches  = bCryptPasswordEncoder.matches(user.getPassword(), existsUser.getPassword());
        if(!isMatches){
            // update the password.
            String hashPassword = bCryptPasswordEncoder.encode(user.getPassword());
            user.setPassword(hashPassword);
        }

        // persisted user to db.
        return userDao.save(user);
    }

    @Override
    public User changePassword(String newRawPassword, User user) {
        String hashedPassword = bCryptPasswordEncoder.encode(newRawPassword);
        user.setPassword(hashedPassword);
        return userDao.save(user);
    }

//    @Override
//    public List<User> getUsers() {
//        return (List<User>)userDao.findAll();
//    }

//    @Override
//    public User getUserById(Long id) {
//        return userDao.findOne(id);
//    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }


    @Override
    public List<Message> getLast5UnreadNotifyMessageByUserEmail(String email) {
        return userDao.getLast5UnreadNotifyMessageByUserEmail(email);
    }
}
