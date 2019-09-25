package edu.mum.dao;

import edu.mum.domain.Message;
import edu.mum.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserDao extends GenericDao<User>{

    User findByEmail(String email);

    List<Message> getLast5UnreadNotifyMessageByUserEmail(String email);

}
