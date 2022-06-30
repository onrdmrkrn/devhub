package com.devhub.message.entities;

import com.devhub.common.dtos.MessageDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int messageId;

    private String publisher;
    private String consumer;

    private int readStatus;

    private String messageInclude;

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getConsumer() {
        return consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer;
    }

    public int getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(int readStatus) {
        this.readStatus = readStatus;
    }

    public String getMessageInclude() {
        return messageInclude;
    }

    public void setMessageInclude(String messageInclude) {
        this.messageInclude = messageInclude;
    }

    public Message() {
    }

    public Message(int messageId, String publisher, String consumer, int readStatus, String messageInclude) {
        this.messageId = messageId;
        this.publisher = publisher;
        this.consumer = consumer;
        this.readStatus = readStatus;
        this.messageInclude = messageInclude;
    }

    public static Message fromResource(MessageDto messageDto){
        Message message = new Message();

        message.setConsumer(messageDto.consumer);
        message.setPublisher(messageDto.publisher);
        message.setMessageInclude(messageDto.messageInclude);
        message.setReadStatus(messageDto.readStatus);
        return message;
    }
    public static MessageDto toResource(Message message){
        MessageDto dto = new MessageDto();
        dto.messageInclude = message.getMessageInclude();
        dto.publisher = message.getPublisher();
        dto.consumer = message.getConsumer();
        dto.readed = message.readStatus == 0 ? false:true;
        dto.messageId = message.getMessageId();
        return dto;
    }

    public static List<MessageDto> toResourceList(List<Message> messageList){
        List<MessageDto> dtos = new ArrayList<>();
        for (Message message: messageList){
            dtos.add(toResource(message));
        }
        return dtos;

    }
}
