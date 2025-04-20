package kalfer.apis_pring.Application.UseCases.User.Commands.CreateUser;


import kalfer.apis_pring.Application.Common.Result;
import kalfer.apis_pring.Application.Common.Mediator.IRequest;
import kalfer.apis_pring.Application.DTOs.User.Input.CreateUserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateUserCommand implements IRequest<Result<Object>>{
    public final CreateUserDto input;
    
}
