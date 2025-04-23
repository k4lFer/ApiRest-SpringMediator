package kalfer.apis_pring.Presentation.Controllers;

import kalfer.apis_pring.Application.DTOs.User.Input.CreateUserDto;
import kalfer.apis_pring.Application.UseCases.User.Commands.CreateUser.CreateUserCommand;
import kalfer.apis_pring.Application.UseCases.User.Queries.GetUser.GetUserQuery;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import kalfer.apis_pring.Application.Common.Mediator.Mediator;
import kalfer.apis_pring.Application.UseCases.User.Queries.GetAllUserPaged.GetAllUserPagedQuery;

import java.util.UUID;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {
    private final Mediator mediator;

    @GetMapping("/GetAll")
    public ResponseEntity<?> GetAllPag(@RequestParam(required = false) Integer page,
                                                    @RequestParam(required = false) Integer size,
                                                  @RequestParam(required = false) String search)
    {
        var result = mediator.send(new GetAllUserPagedQuery(page, size, search));
        return ResponseEntity.status(result.getHttpStatus()).body(result);
    }

    @GetMapping("/Get")
    public ResponseEntity<?> GetUser(@RequestParam UUID id)
    {
        var result = mediator.send(new GetUserQuery(id));
        return  ResponseEntity.status(result.getHttpStatus()).body(result);
    }

    @PostMapping("/Create")
    public ResponseEntity<?> Create(@ModelAttribute CreateUserDto input)
    {
        var result = mediator.send(new CreateUserCommand(input));
        return  ResponseEntity.status(result.getHttpStatus()).body(result);
    }
}
