package kalfer.apis_pring.Application.UseCases.User.Queries.GetAllUserPaged;

import kalfer.apis_pring.Application.Common.Result;
import kalfer.apis_pring.Application.Common.Mediator.IRequestHandler;
import kalfer.apis_pring.Application.DTOs.Common.PagedResponse;
import kalfer.apis_pring.Application.DTOs.User.Output.UserOutputDto;
import kalfer.apis_pring.Domain.Interfaces.Repositories.IUserRepository;
import lombok.AllArgsConstructor;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class GetAllUserPagedQueryHandler implements IRequestHandler<GetAllUserPagedQuery, Result<PagedResponse<UserOutputDto>>> {
    private final IUserRepository userRepository;

    @Override
    public Result<PagedResponse<UserOutputDto>> handle(GetAllUserPagedQuery request) {
        Pageable pageable = PageRequest.of(request.getPage()-1, request.getSize());
        var page = userRepository.GetAllUserPaged(pageable, request.getSearch());
        
        if(page.getTotalElements() == 0) return Result.Error("Users not found !");

        List<UserOutputDto> dtos = page.getContent().stream()
            .map(user -> new UserOutputDto(user.getId(), user.getName(), user.getEmail()))
            .collect(Collectors.toList());
    
        PagedResponse<UserOutputDto> response = new PagedResponse<>(
            page.getNumber() + 1,
            page.getSize(),
            page.getTotalPages(),
            (int) page.getTotalElements(),
            dtos
        );
        return Result.Success(response, "Users fetched successfully");
    }
}
