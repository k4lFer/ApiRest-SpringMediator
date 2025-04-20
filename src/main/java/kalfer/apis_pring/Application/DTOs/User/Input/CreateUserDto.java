package kalfer.apis_pring.Application.DTOs.User.Input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserDto
{
    public String name;
    public String email;
}