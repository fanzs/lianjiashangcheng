package com.fanzs.repository;

import com.fanzs.entity.SupportAddress;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by fzs on 2018/4/20.
 */
public interface SupportAddressRepository extends CrudRepository<SupportAddress,Long>{
    /**
     * 获取所有的行政级别的信息
     * @return
     */
    List<SupportAddress> findAllByLevel(String level);
}
