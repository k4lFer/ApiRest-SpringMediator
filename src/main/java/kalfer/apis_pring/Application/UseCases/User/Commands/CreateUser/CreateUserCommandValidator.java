package kalfer.apis_pring.Application.UseCases.User.Commands.CreateUser;

import kalfer.apis_pring.Application.Common.Result;

import kalfer.apis_pring.Application.DTOs.User.Input.CreateUserDto;
import kalfer.apis_pring.Domain.Interfaces.Repositories.IUserRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateUserCommandValidator {
    private final IUserRepository userRepository;
    public boolean isValid(CreateUserDto inputDto) {
        try
        {
            var email = userRepository.GetByEmail(inputDto.getEmail().toLowerCase().trim());
            if(email == null)
            {
                return false;
            }

            Result.Error(null);
            return false; 
        }
        catch (Exception e)
        {
            return false;
        }

    }
    
}
