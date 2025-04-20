package kalfer.apis_pring.Application.UseCases.User.Queries.GetAllUserPaged;

import kalfer.apis_pring.Application.Common.Result;
import kalfer.apis_pring.Application.Common.Mediator.IRequestHandler;
import kalfer.apis_pring.Application.DTOs.Common.PagedResponse;
import kalfer.apis_pring.Application.DTOs.User.Output.UserOutputDto;
import kalfer.apis_pring.Domain.Interfaces.Repositories.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class GetAllUserPagedQueryHandler implements IRequestHandler<GetAllUserPagedQuery, Result<PagedResponse<UserOutputDto>>> {
    private final IUserRepository userRepository;

    @Override
    public Result<PagedResponse<UserOutputDto>> handle(GetAllUserPagedQuery request) {
        var pagedResult = userRepository.GetAllUserPaged(request.getPage(), request.getSize(), request.getSearch());

        // Verificación de si se obtuvieron resultados
        if (pagedResult != null && pagedResult.getItems() != null) {
            // Mapeo de los datos de dominio a DTOs
            List<UserOutputDto> userOutputDtos = pagedResult.getItems().stream()
                    .map(user -> new UserOutputDto(user.getId(), user.getName(), user.getEmail()))
                    .collect(Collectors.toList());

            // Creación de la respuesta paginada
            PagedResponse<UserOutputDto> pagedResponse = new PagedResponse<>(
                    pagedResult.getPageNumber(),
                    pagedResult.getPageSize(),
                    pagedResult.getTotalCount(),
                    pagedResult.getTotalPages(),
                    userOutputDtos
            );

            // Devolver el resultado con éxito
            return Result.Success(pagedResponse, "Users fetched successfully");
        }

        // Si no se obtuvieron resultados, se retorna un error
        return Result.Error("No users found.");
    }
}
