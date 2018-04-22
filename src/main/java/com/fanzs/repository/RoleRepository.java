package com.fanzs.repository;

import com.fanzs.entity.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 *
 * Created by fzs on 2018/4/19.
 */
public interface RoleRepository extends CrudRepository<Role,Long>{
    List<Role> findRoleByUserId(Long userId);
 }
