package com.owmax.service;

import com.owmax.model.User;

public interface UserService extends BaseService<User>{

    public User scrapyUser(User user);

    public void setState1(String userName);

}
