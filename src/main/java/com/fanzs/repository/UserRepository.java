package com.fanzs.repository;

import com.fanzs.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by fzs on 2018/4/18.
 */
public interface UserRepository extends CrudRepository<User,Long> {
    User findByName(String userName);
}
