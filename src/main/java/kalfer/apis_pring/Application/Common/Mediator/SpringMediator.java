package kalfer.apis_pring.Application.Common.Mediator;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

/**
 * Implementación concreta del patrón Mediator que utiliza el contenedor de Spring
 * para gestionar el enrutamiento de requests a sus respectivos handlers.
 * 
 * Esta clase centraliza la comunicación entre componentes, reduciendo las dependencias directas.
 */
@Component
@AllArgsConstructor
public class SpringMediator implements Mediator {
    
    // Contexto de Spring para la búsqueda de beans
    private final AbstractApplicationContext context;

    /**
     * Procesa una petición enviándola al handler correspondiente registrado en Spring.
     *
     * @param <T> Tipo de retorno esperado
     * @param request Petición a procesar
     * @return Resultado del procesamiento
     * @throws NullPointerException Si el request es nulo
     * @throws IllegalArgumentException Si el tipo de respuesta no es soportado
     * @throws IllegalStateException Si no hay handlers o hay múltiples para el request
     */
    @Override
    @SuppressWarnings("unchecked")
    public <T> T send(IRequest<T> request) {
        // Validación básica del request
        if (request == null) {
            throw new NullPointerException("The given request object cannot be null");
        }

        // Obtiene el tipo concreto del request
        final Class<?> requestType = request.getClass();
        
        // Extrae el tipo de respuesta declarado en la interfaz IRequest<T>
        Type responseType = ((ParameterizedType) 
                requestType.getGenericInterfaces()[0]).getActualTypeArguments()[0];
        
        // Valida que el tipo de respuesta sea soportado (Class o ParameterizedType)
        if (!(responseType instanceof ParameterizedType || responseType instanceof Class)) {
            throw new IllegalArgumentException("Unsupported response type: " + responseType);
        }

        // Crea un ResolvableType que representa IRequestHandler<RequestType, ResponseType>
        ResolvableType handlerType = ResolvableType.forClassWithGenerics(
            IRequestHandler.class, 
            ResolvableType.forClass(requestType),
            ResolvableType.forType(responseType)
        );

        // Busca los beans que coincidan con el tipo de handler requerido
        String[] beanNames = context.getBeanNamesForType(handlerType);

        // Valida que exista exactamente un handler registrado
        if (beanNames.length == 0) {
            throw new IllegalStateException("No handlers registered for request type: " + requestType.getName());
        }

        if (beanNames.length > 1) {
            throw new IllegalStateException("Multiple handlers found for request type: " + requestType.getName());
        }

        // Obtiene el handler adecuado del contexto de Spring
        IRequestHandler<IRequest<T>, T> requestHandler = 
            (IRequestHandler<IRequest<T>, T>) context.getBean(beanNames[0]);

        // Ejecuta el handler y retorna el resultado
        return requestHandler.handle(request);
    }
}