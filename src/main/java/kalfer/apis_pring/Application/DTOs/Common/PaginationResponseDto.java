package kalfer.apis_pring.Application.DTOs.Common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PaginationResponseDto<T>{
    private List<T> data;
    private int totalCount;
    private int pageNumber;
    private int pageSize;

}
