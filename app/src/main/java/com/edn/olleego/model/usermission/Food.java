package com.edn.olleego.model.usermission;

import java.util.List;

/**
 * Created by Antonio on 2016-07-21.
 */
public class Food {


    int _id;

    String title;
    List<FdList> fd_list;


    public int get_id() {
        return this._id;
    }
    public void set_id(int _id) {
        this._id = _id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public List<FdList> getFd_list() {
        return this.fd_list;
    }
    public void setFd_list(List<FdList> fd_list) {
        this.fd_list = fd_list;
    }
}


