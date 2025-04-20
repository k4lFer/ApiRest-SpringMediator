package kalfer.apis_pring.Application.UseCases.User.Commands.CreateUser;

import kalfer.apis_pring.Application.Common.Mediator.IRequestHandler;
import kalfer.apis_pring.Application.Common.Result;
import kalfer.apis_pring.Domain.Entities.TUser;
import kalfer.apis_pring.Domain.Interfaces.Repositories.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreateUserHandler implements IRequestHandler<CreateUserCommand, Result<Object>> {
    private final IUserRepository userRepository;
    @Override
    public Result<Object> handle(CreateUserCommand request) {
        var user = TUser.create(request.getInput().getName(), request.getInput().getEmail());
        var result = userRepository.Create(user);
        if(result != null)
        {
            return Result.Success(null,"User Created!");
        }
        return Result.Error("Error");
    }
}
