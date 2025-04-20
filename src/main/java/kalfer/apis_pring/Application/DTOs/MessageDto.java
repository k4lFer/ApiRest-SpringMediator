package kalfer.apis_pring.Application.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MessageDto {
    public String type;
    public List<String> messages;

    public MessageDto(){
        messages = new ArrayList<>();
    }

    public void addMessage(String message)
    {
        messages.add(message);
    }
}
