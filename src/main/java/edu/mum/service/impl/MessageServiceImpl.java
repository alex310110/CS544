package edu.mum.service.impl;

import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import edu.mum.dao.MessageDao;
import edu.mum.domain.Message;
import edu.mum.domain.User;
import edu.mum.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageDao messageDao;

//    @Autowired
//    private MailConfig mailConfig;

    @Override
    public Message saveMessage(Message message) {
        return messageDao.save(message);
    }

    @Override
    public List<Message> getMessages() {
        return (List<Message>) messageDao.findAll();
    }

    @Override
    public Message getMessageById(Long id) {
        return messageDao.findOne(id);
    }

    @Override
    public void delete(Message message) {
        messageDao.delete(message.getId());
    }

    @Override
    public void setMessageRead(Long id) {
        Message msg = messageDao.findOne(id);
        if(msg != null){
            msg.setRead(true);
            messageDao.save(msg);
        }
    }

    @Override
    public void sendMessageToUser(User toUser, String content) {
        Message msg = new Message();
        msg.setContent(content);
        msg.setReceivedDate(LocalDateTime.now());
        msg.setUser(toUser);
        msg.setRead(false);
        messageDao.save(msg);
    }

    @Override
    public JsonNode sendEmail(String from, String to, String subject, String content) throws UnirestException {
        return null;
    }


//    @Override
//    public JsonNode sendEmail(String from, String to, String subject, String content) throws UnirestException {
//        HttpResponse<JsonNode> request = Unirest.post(mailConfig.getMailMessageUrl())
//                .basicAuth("api", mailConfig.getApiKey())
//                .queryString("from", from == null ? mailConfig.getNoReplyEmail() : from)
//                .queryString("to", to)
//                .queryString("subject", subject)
//                .queryString("text", content)
//                .asJson();
//        return request.getBody();
//    }
}
