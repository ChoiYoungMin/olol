package com.edn.olleego.model;

import com.edn.olleego.model.notices.Result;

import java.util.List;

/**
 * Created by Antonio on 2016-08-18.
 */
public class NoticesModel {

    boolean success;
    List<Result> result;

    public boolean getSuccess() {
        return this.success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<Result> getResult() {
        return this.result;
    }
    public void setResult(List<Result> result) {
        this.result = result;
    }
}
