package kalfer.apis_pring.Application.UseCases.User.Commands.CreateUser;

import kalfer.apis_pring.Application.Common.Mediator.IRequestHandler;
import kalfer.apis_pring.Application.DTOs.User.Input.CreateUserDto;
import kalfer.apis_pring.Application.Common.Result;
import kalfer.apis_pring.Application.Common.Interfaces.IInputValidator;
import kalfer.apis_pring.Domain.Entities.TUser;
import kalfer.apis_pring.Domain.Interfaces.Repositories.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreateUserHandler implements IRequestHandler<CreateUserCommand, Result<Object>> {
    private final IUserRepository userRepository;
    private final IInputValidator<CreateUserDto> validator;

    @Override
    public Result<Object> handle(CreateUserCommand request) {
        if(!validator.isValid(request.getInput())) {
            return new Result<Object>(null, false, validator.getHttpStatus(), validator.getMessages());
        }

        var user = TUser.create(request.getInput().getName(), request.getInput().getEmail());
        var result = userRepository.Create(user);
        if(result != null)
        {
            return Result.Success(null,"User Created!");
        }
        return Result.Error("Error");
    }
}
