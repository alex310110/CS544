package edu.mum.dao.impl;

import edu.mum.domain.Message;
import edu.mum.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements edu.mum.dao.UserDao {
    public UserDaoImpl() {
        super.setDaoType(User.class );
    }

    @Override
    public User findByEmail(String email) {
            Query query = entityManager.createQuery("select u from User u where u.email = :email ");
        try {
            return (User) query.setParameter("email", email).getSingleResult();
        } catch (Exception e){
            return null;
        }
    }

    @Override
    public List<Message> getLast5UnreadNotifyMessageByUserEmail(String email) {
        Query query = entityManager.createQuery("select m from Message m join User u on m.user = u.id where m.isRead = 0 and  u.email = :email and rownum < 5 order by m.receivedDate desc");
        return (List<Message>) query.setParameter("email", email).getResultList();
    }
}
