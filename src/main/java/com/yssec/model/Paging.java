package com.yssec.model;
//"Paging": {
//        "pageIndex": 1,
//        "pageSize": 100,
//        "total": 30
//        }
public class Paging {
    private Integer pageIndex;
    private Integer pageSize;
    private Integer total;

    public Integer getPageIndex() {
        return pageIndex;
    };

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

}
