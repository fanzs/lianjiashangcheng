package com.fanzs.service.user;

import com.fanzs.entity.Role;
import com.fanzs.entity.User;
import com.fanzs.repository.RoleRepository;
import com.fanzs.repository.UserRepository;
import com.fanzs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fzs on 2018/4/19.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User findUserByName(String userName) {
        User user = userRepository.findByName(userName);
        if(user==null){
            return null;
        }
        List<Role> roles = roleRepository.findRoleByUserId(user.getId());
        if(roles==null || roles.isEmpty()){
            throw new DisabledException("非法权限");
        }

        List<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
        roles.forEach(role -> authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName())));
        user.setAuthorityList(authorities);
        return user;
    }
}
