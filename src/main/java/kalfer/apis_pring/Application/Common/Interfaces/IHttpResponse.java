package kalfer.apis_pring.Application.Common.Interfaces;

import kalfer.apis_pring.Application.DTOs.MessageDto;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface IHttpResponse {
    HttpStatus getHttpStatus();
    List<MessageDto> getMessage();
}
