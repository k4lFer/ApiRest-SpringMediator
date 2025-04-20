package kalfer.apis_pring.Application.DTOs.Common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PagedResponse<Dto> {
    private int pageNumber;
    private int pageSize;
    private int totalPages;
    private int totalItems;
    private List<Dto> data;

    public static <Dto> PagedResponse<Dto> ok(PaginationResponseDto<Dto> model) {
        PagedResponse<Dto> response = new PagedResponse<>();
        response.setData(model.getData());
        response.setPageNumber(model.getPageNumber());
        response.setPageSize(model.getPageSize());
        response.setTotalItems(model.getTotalCount());
        response.setTotalPages((int) Math.ceil(model.getTotalCount() / (double) model.getPageSize()));
        return response;
    }
}