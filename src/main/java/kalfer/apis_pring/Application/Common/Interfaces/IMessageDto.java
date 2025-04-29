package kalfer.apis_pring.Application.Common.Interfaces;

import kalfer.apis_pring.Application.DTOs.MessageDto;

import java.util.List;

public interface IMessageDto {
    List<MessageDto> getMessages();
    void setMessages(List<MessageDto> messages);
}
