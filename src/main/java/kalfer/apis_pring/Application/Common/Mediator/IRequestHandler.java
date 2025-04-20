package kalfer.apis_pring.Application.Common.Mediator;

public interface IRequestHandler<TRequest extends IRequest<TResponse>, TResponse> {
    TResponse handle(final TRequest request);
}
