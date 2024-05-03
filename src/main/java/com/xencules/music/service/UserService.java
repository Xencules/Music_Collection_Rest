package com.xencules.music.service;

import com.xencules.music.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    public User findByUserName(String userName);

}
