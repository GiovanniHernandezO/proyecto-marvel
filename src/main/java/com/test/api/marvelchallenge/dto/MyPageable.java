package com.test.api.marvelchallenge.dto;

public class MyPageable {
    private long offset;
    private long limit;

    public MyPageable(long offset, long limit) {
        this.offset = offset;
        this.limit = limit;
    }

    public long getOffset() {
        return offset;
    }

    public void setOffset(long offset) {
        this.offset = offset;
    }

    public long getLimit() {
        return limit;
    }

    public void setLimit(long limit) {
        this.limit = limit;
    }
}
