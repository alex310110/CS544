package edu.mum.dao;

import edu.mum.domain.Message;
import edu.mum.domain.User;

import java.util.List;

public interface UserDao extends GenericDao<User>{

    User findByEmail(String email);

    List<Message> getLast5UnreadNotifyMessageByUserEmail(String email);

}
