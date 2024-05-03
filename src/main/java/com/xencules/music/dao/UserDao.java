package com.xencules.music.dao;

import com.xencules.music.entity.User;

public interface UserDao {

    User findByUserName(String userName);

}
