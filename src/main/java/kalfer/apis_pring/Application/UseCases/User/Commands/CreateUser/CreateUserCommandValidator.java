package kalfer.apis_pring.Application.UseCases.User.Commands.CreateUser;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import kalfer.apis_pring.Application.Common.Interfaces.IInputValidator;
import kalfer.apis_pring.Application.DTOs.MessageDto;
import kalfer.apis_pring.Application.DTOs.User.Input.CreateUserDto;
import kalfer.apis_pring.Domain.Interfaces.Repositories.IUserRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class CreateUserCommandValidator implements IInputValidator<CreateUserDto> {
    private final IUserRepository userRepository;
    private HttpStatus status = HttpStatus.OK; 
    private List<MessageDto> messages = new ArrayList<>();

    public CreateUserCommandValidator (IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return status;
    }

    @Override
    public void setHttpStatus(HttpStatus status) {
        this.status = status;
    }

    @Override
    public List<MessageDto> getMessages() {
        return messages;
    }

    @Override
    public void setMessages(List<MessageDto> messages) {
        this.messages = messages;
    }

    @Override
    public boolean isValid(CreateUserDto inputDto) {
        try {
            // Reiniciar mensajes
            messages.clear();
            status = HttpStatus.OK;

            var email = userRepository.GetByEmail(inputDto.getEmail().toLowerCase().trim());
            if (email != null) {

                MessageDto messageDto = new MessageDto();
                messageDto.setType("error");
                messageDto.addMessage("Email already exists");
                messages.add(messageDto);

                status = HttpStatus.BAD_REQUEST;
                return false;
            }

            return true;
        } catch (Exception e) {
            MessageDto messageDto = new MessageDto();
            messageDto.setType("error");
            messageDto.addMessage("Validation error: " + e.getMessage());
            messages.add(messageDto);

            status = HttpStatus.INTERNAL_SERVER_ERROR;
            return false;
        }
    }
}
