package kalfer.apis_pring.Domain.Common;

import java.util.List;

public class PagedResult<T> {
    private final List<T> items;
    private final int totalCount;
    private final int pageNumber;
    private final int pageSize;

    public PagedResult(List<T> items, int totalCount, int pageNumber, int pageSize) {
        this.items = items;
        this.totalCount = totalCount;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }

    public List<T> getItems() {
        return items;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getTotalPages() {
        return (int) Math.ceil((double) totalCount / pageSize);
    }

    public boolean getHasPreviousPage() {
        return pageNumber > 1;
    }

    public boolean getHasNextPage() {
        return pageNumber < getTotalPages();
    }


    public static class PaginationOptions {
        private final int pageNumber;
        private final int pageSize;

        public PaginationOptions(int pageNumber, int pageSize) {
            this.pageNumber = pageNumber;
            this.pageSize = pageSize;
        }

        public int getPageNumber() {
            return pageNumber;
        }

        public int getPageSize() {
            return pageSize;
        }
    }
}
