package com.cloudyoung.baic.common.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author 1.0 刘风栓
 */
public class Pagination<T extends Serializable> implements Serializable {


    public static final int DEFAULT_PAGE_INDEX = 1;
    public static final int DEFAULT_PAGE_SIZE=10;

    protected int page;
    protected int pageSize;
    private int totalPage;
    private long dataNumber;
    private List<T> content;

    public Pagination() {
        this(DEFAULT_PAGE_INDEX, DEFAULT_PAGE_SIZE);
    }

    public Pagination(int pageIndex, int pageSize) {
        this.page = pageIndex;
        this.pageSize = pageSize;
    }

    public Pagination(int page, int pageSize, List<T> content) {
        this.page = page;
        this.pageSize = pageSize;
        this.content = content;
    }

    public int getPage() {
        return this.page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalPage() {
        return this.totalPage != 0 ? (long)this.totalPage : (this.pageSize > 0 ? (this.dataNumber + (long)this.pageSize - 1L) / (long)this.pageSize : 0L);
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public long getDataNumber() {
        return dataNumber;
    }

    public void setDataNumber(long dataNumber) {
        this.dataNumber = dataNumber;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }
}
