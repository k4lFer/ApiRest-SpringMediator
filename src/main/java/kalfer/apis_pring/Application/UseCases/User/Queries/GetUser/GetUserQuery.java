package kalfer.apis_pring.Application.UseCases.User.Queries.GetUser;

import kalfer.apis_pring.Application.Common.Mediator.IRequest;
import kalfer.apis_pring.Application.Common.Result;
import kalfer.apis_pring.Application.DTOs.User.Output.UserOutputDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class GetUserQuery implements IRequest<Result<Optional<UserOutputDto>>> {
    public final UUID id;
}
