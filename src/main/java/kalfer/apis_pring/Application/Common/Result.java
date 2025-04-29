package kalfer.apis_pring.Application.Common;

import kalfer.apis_pring.Application.Common.Interfaces.IOutput;
import kalfer.apis_pring.Application.DTOs.MessageDto;
import org.springframework.http.HttpStatus;

import java.util.List;

public class Result<T> implements IOutput<T> {

    private final T data;
    private final boolean isSuccess;
    private HttpStatus status;
    private List<MessageDto> messages;

    public Result(T data, boolean isSuccess, HttpStatus status, List<MessageDto> messages) {
        this.data = data;
        this.isSuccess = isSuccess;
        this.status = status;
        this.messages = messages;
    }

    @Override
    public T getData() {
        return data;
    }

    @Override
    public boolean isSuccess() {
        return isSuccess;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return status;
    }

    @Override
    public List<MessageDto> getMessages() {
        return messages;
    }

    @Override
    public void setHttpStatus(HttpStatus status) {
        this.status = status;
    }

    @Override
    public void setMessages(List<MessageDto> messages) {
        this.messages = messages;
    }

    // Métodos para construir respuestas estándar
    public static <T> Result<T> Success(T data, String msg) {
        MessageDto messageDto = new MessageDto();
        messageDto.setType("success");
        messageDto.addMessage((msg == null || msg.isEmpty()) ? "Operation successful" : msg);
        return new Result<>(data, true, HttpStatus.OK, List.of(messageDto));
    }

    public static <T> Result<T> Created(T data, String msg) {
        MessageDto messageDto = new MessageDto();
        messageDto.setType("created");
        messageDto.addMessage((msg == null || msg.isEmpty()) ? "Resource created successfully" : msg);
        return new Result<>(data, true, HttpStatus.CREATED, List.of(messageDto));
    }

    public static <T> Result<T> Error(String msg) {
        MessageDto messageDto = new MessageDto();
        messageDto.setType("error");
        messageDto.addMessage((msg == null || msg.isEmpty()) ? "Something went wrong" : msg);
        return new Result<>(null, false, HttpStatus.BAD_REQUEST, List.of(messageDto));
    }

    public static <T> Result<T> NotFound(String msg) {
        MessageDto messageDto = new MessageDto();
        messageDto.setType("warning");
        messageDto.addMessage((msg == null || msg.isEmpty()) ? "Resource not found" : msg);
        return new Result<>(null, false, HttpStatus.NOT_FOUND, List.of(messageDto));
    }
}
