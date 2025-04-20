package kalfer.apis_pring.Application.Common.Mediator;

public interface Mediator {
    <T> T send(final IRequest<T> request);
}
