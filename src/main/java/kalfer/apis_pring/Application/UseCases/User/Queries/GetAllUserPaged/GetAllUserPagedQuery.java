package kalfer.apis_pring.Application.UseCases.User.Queries.GetAllUserPaged;

import kalfer.apis_pring.Application.Common.Result;
import kalfer.apis_pring.Application.Common.Mediator.IRequest;
import kalfer.apis_pring.Application.DTOs.Common.PagedResponse;
import kalfer.apis_pring.Application.DTOs.User.Output.UserOutputDto;
import lombok.Getter;

@Getter
public class GetAllUserPagedQuery implements IRequest<Result<PagedResponse<UserOutputDto>>> {
    public int page;
    public int size;
    public String search;

    public GetAllUserPagedQuery(Integer page, Integer size, String search)
    {
        this.page = (page == null || page < 1 )? 1:page;
        this.size = (size == null || size < 1) ? 10:size;
        this.search = (search == null) ? "" : search;
    }

}
