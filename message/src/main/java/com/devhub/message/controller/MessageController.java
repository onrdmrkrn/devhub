package com.devhub.message.controller;

import com.devhub.common.dtos.MessageDto;
import com.devhub.common.response.MessageListResponse;
import com.devhub.common.response.MessageResponse;
import com.devhub.message.repository.service.MessageService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/message")
public class MessageController {

   private MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }


    @PostMapping("/publisher")
    public MessageListResponse publisher(@RequestBody Item item){
        return messageService.findAllPublisher(item);
    }

    @PostMapping("/consumer")
    public MessageListResponse consumer(@RequestBody Item item){
        return messageService.findAllConsumer(item);
    }

    @PostMapping("/sendMessage/")
    public MessageResponse sendMessage(@RequestBody MessageDto messageDto){
        return messageService.sendMessage(messageDto);
    }
}
