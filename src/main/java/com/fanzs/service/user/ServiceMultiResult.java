package com.fanzs.service.user;

import java.util.List;

/**
 * Created by fzs on 2018/4/20.
 */
public class ServiceMultiResult<T> {
    private Long total;
    private List<T> result;

    public ServiceMultiResult(Long total, List<T> result) {
        this.total = total;
        this.result = result;
    }

    public ServiceMultiResult() {
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    public Long getTotal() {

        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public int getResultSize(){
        if(this.result==null){
            return 0;
        }
        return this.result.size();
    }
}
