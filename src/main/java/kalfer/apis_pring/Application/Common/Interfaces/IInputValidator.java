package kalfer.apis_pring.Application.Common.Interfaces;


public interface IInputValidator<T> extends IHttpResponse, IMessageDto {
    boolean isValid(T inputDto);
}
