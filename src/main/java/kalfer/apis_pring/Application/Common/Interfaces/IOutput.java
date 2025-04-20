package kalfer.apis_pring.Application.Common.Interfaces;

public interface IOutput<T>  extends IHttpResponse
{
    T getData();
    boolean isSuccess();
}
