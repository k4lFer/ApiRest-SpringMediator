package kalfer.apis_pring.Application.Common.Interfaces;

public interface IOutput<T>  extends IHttpResponse, IMessageDto
{
    T getData();
    boolean isSuccess();
}
