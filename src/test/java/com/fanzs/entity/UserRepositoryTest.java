package com.fanzs.entity;

import com.fanzs.LianjiaApplicationTests;
import com.fanzs.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by fzs on 2018/4/18.
 */
public class UserRepositoryTest extends LianjiaApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindOne() throws Exception {
        User user=userRepository.findOne(1L);
        Assert.assertEquals("wali",user.getName());

    }
}
