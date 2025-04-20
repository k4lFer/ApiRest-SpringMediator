package kalfer.apis_pring.Application.Common;

import kalfer.apis_pring.Application.Common.Interfaces.IOutput;
import kalfer.apis_pring.Application.DTOs.MessageDto;
import org.springframework.http.HttpStatus;

import java.util.List;

public class Result<T> implements IOutput<T> {

    private final T data;
    private final boolean isSuccess;
    private final HttpStatus status;
    private final List<MessageDto> message;

    public Result(T Data, boolean isSuccess, HttpStatus status, List<MessageDto> message) {
        data = Data;
        this.isSuccess = isSuccess;
        this.status = status;
        this.message = message;
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
    public List<MessageDto> getMessage() {
        return message;
    }


    public static <T> Result<T> Success(T data, String msg) {
        MessageDto messageDto = new MessageDto();
        messageDto.setType("success");
        messageDto.addMessage((msg == null || msg.isEmpty()) ? "Operation successful" : msg);
        return new Result<T>(data, true, HttpStatus.OK, List.of(messageDto));
    }

    public static <T> Result<T> Created(T data, String msg) {
        MessageDto messageDto = new MessageDto();
        messageDto.setType("created");
        messageDto.addMessage((msg == null || msg.isEmpty()) ? "Operation created" : msg);
        return new Result<T>(data, true, HttpStatus.CREATED, List.of(messageDto));
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
