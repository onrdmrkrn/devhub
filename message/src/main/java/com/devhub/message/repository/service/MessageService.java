package com.devhub.message.repository.service;

import com.devhub.common.dtos.MessageDto;
import com.devhub.common.response.MessageListResponse;
import com.devhub.common.response.MessageResponse;
import com.devhub.common.response.Meta;
import com.devhub.message.entities.Message;
import com.devhub.message.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    public MessageListResponse findAllPublisher(Item item) {
        MessageListResponse messageListResponse = new MessageListResponse();
        messageListResponse.messageList = Message.toResourceList(messageRepository.findAllByPublisherContaining(item.nick));
        messageListResponse.meta=new Meta(200,"Gönderici bulundu.");
        return messageListResponse;

    }

    public MessageListResponse findAllConsumer(Item item) {
        MessageListResponse messageListResponse = new MessageListResponse();
        messageListResponse.messageList = Message.toResourceList(messageRepository.findAllByConsumerContaining(item.nick));
        messageListResponse.meta= new Meta(200,"Alıcı bulundu.");
        return messageListResponse;
    }

    public MessageResponse sendMessage(MessageDto messageDto) {
        MessageResponse messageResponse = new MessageResponse();
        Message message = Message.fromResource(messageDto);
        message = messageRepository.save(message);
        if (message == null){
            System.out.println("Mesaj iletilemedi.");
        }
            messageResponse.meta = new Meta(200,"message atıldı");
        return messageResponse;
    }
}
