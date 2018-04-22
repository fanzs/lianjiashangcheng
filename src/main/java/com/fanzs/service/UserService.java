package com.fanzs.service;

import com.fanzs.entity.User;

/**
 * Created by fzs on 2018/4/19.
 */
public interface UserService {
    User findUserByName(String userName);
}
