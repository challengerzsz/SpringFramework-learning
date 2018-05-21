package com.ylxt.service.impls;

import com.ylxt.common.ServerResponse;
import com.ylxt.dao.UserMapper;
import com.ylxt.pojo.User;
import com.ylxt.service.IUserService;
import com.ylxt.util.MD5Util;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ServerResponse<User> login(String number, String password) {
        int resultCount = userMapper.checkUserNumber(number);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMsg("用户不存在");
        }
        String md5EncodingPassword = MD5Util.MD5EncodeUtf8(password);
        User user = userMapper.login(number, md5EncodingPassword);
        if (user == null) {
            return ServerResponse.createByErrorMsg("密码错误");
        }

        user.setPassword(StringUtils.EMPTY);
        return ServerResponse.createBySuccess("登陆成功", user);
    }

    @Override
    public ServerResponse<String> resetPassword(String number, String newPassword) {

        String MD5EncodingPassword = MD5Util.MD5EncodeUtf8(newPassword);

        int resultCount = userMapper.resetPassword(number, MD5EncodingPassword);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMsg("修改密码失败");
        }

        return ServerResponse.createBySuccessMsg("修改密码成功");
    }

    @Override
    public ServerResponse<User> updateInformation(User user, String phone, String email) {
        int emailResultCount = userMapper.checkEmail(phone);
        int phoneResultCount = userMapper.checkPhone(email);

        if (emailResultCount > 0 || phoneResultCount > 0) {
            return ServerResponse.createBySuccessMsg("email或phone已存在，更新用户信息失败");
        }


        int updateCount = userMapper.updateUser(user.getNumber(), phone, email);

        if (updateCount > 0) {
            user.setPhone(phone);
            user.setEmail(email);
            return ServerResponse.createBySuccess("更新个人信息成功", user);
        }

        return ServerResponse.createByErrorMsg("更新个人信息失败");
    }

}
