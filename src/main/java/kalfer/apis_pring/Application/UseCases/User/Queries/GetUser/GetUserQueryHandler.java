package kalfer.apis_pring.Application.UseCases.User.Queries.GetUser;

import kalfer.apis_pring.Application.Common.Mediator.IRequestHandler;
import kalfer.apis_pring.Application.Common.Result;
import kalfer.apis_pring.Application.DTOs.User.Output.UserOutputDto;
import kalfer.apis_pring.Domain.Entities.TUser;
import kalfer.apis_pring.Domain.Interfaces.Repositories.IUserRepository;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class GetUserQueryHandler implements IRequestHandler<GetUserQuery, Result<Optional<UserOutputDto>>> {
    private final IUserRepository userRepository;


    @Override
    public Result<Optional<UserOutputDto>> handle(GetUserQuery request) {
        var userOptional = userRepository.Get(request.getId());

        if(userOptional.isPresent()) {
            Optional<UserOutputDto> userMap = userOptional.map(user ->
                    new UserOutputDto(
                            user.getId(),
                            user.getName(),
                            user.getEmail()
                    )
            );
            return Result.Success(userMap, "User fetched successfully");
        }
        return Result.Error("User not found");

    }
}
