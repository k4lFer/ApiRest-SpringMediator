package kalfer.apis_pring.Application.DTOs.User.Output;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class UserOutputDto {
    public UUID id;
    public String name;
    public String email;
}
