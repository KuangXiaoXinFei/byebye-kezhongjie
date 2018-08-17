package com.cloudyoung.baic.common.model;

import java.io.Serializable;

public class BaseECModel implements Serializable {
    public static final int PAGESIZE_DEFAULT = 10;
    protected int startRow;
    protected int endRow;
    protected int pageIndex;
    protected int pageSize = 10;
    protected String tableName;
    protected boolean autoGenerateTableName = true;

    public BaseECModel() {
    }

    public int getEndRow() {
        return this.endRow;
    }

    public void setEndRow(int endRow) {
        this.endRow = endRow;
    }

    public int getStartRow() {
        if (this.pageSize < 1) {
            this.pageSize = 10;
        }

        if (this.pageIndex < 1) {
            this.pageIndex = 1;
        }

        this.endRow = this.pageSize;
        this.startRow = (this.pageIndex - 1) * this.pageSize;
        return this.startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public String getTableName() {
        return this.tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public int getPageIndex() {
        return this.pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isAutoGenerateTableName() {
        return this.autoGenerateTableName;
    }

    public void setAutoGenerateTableName(boolean autoGenerateTableName) {
        this.autoGenerateTableName = autoGenerateTableName;
    }
}