package edu.mum.dao.impl;

import edu.mum.domain.Message;
import org.springframework.stereotype.Repository;

@Repository
public class MessageDaoImpl extends GenericDaoImpl<Message> implements edu.mum.dao.MessageDao {
    public MessageDaoImpl() {
        super.setDaoType(Message.class );
    }
}
