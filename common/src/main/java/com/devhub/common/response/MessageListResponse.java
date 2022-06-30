package com.devhub.common.response;

import com.devhub.common.dtos.MessageDto;

import java.io.Serializable;
import java.util.List;

public class MessageListResponse extends BaseResponse implements Serializable {
    public List<MessageDto> messageList;
}
