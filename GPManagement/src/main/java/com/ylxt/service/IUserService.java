package com.ylxt.service;

import com.ylxt.common.ServerResponse;
import com.ylxt.pojo.User;

public interface IUserService {

    ServerResponse<User> login(String number, String password);

    ServerResponse<String> resetPassword(String number, String newPassword);

    ServerResponse<User> updateInformation(User user, String phone, String email);

    ServerResponse<User> getGuideTeacher(String number);
}
