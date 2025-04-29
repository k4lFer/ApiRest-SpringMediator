package kalfer.apis_pring.Application.Common.Interfaces;

import org.springframework.http.HttpStatus;


public interface IHttpResponse {
    HttpStatus getHttpStatus();
    void setHttpStatus(HttpStatus status);
}
