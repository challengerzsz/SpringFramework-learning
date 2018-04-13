package com.bsb.service.impls;

import com.bsb.common.ServerResponse;
import com.bsb.common.UserType;
import com.bsb.dao.UserMapper;
import com.bsb.pojo.User;
import com.bsb.service.IUserService;
import com.bsb.util.MD5Util;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ServerResponse<User> login(String username, String password) {
        int resultCount = userMapper.checkUserName(username);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMsg("用户名不存在");
        }

        //todo MD5加密
        String md5Password = MD5Util.MD5EncodeUtf8(password);
        User user = userMapper.selectLogin(username, md5Password);
        if (user == null) {
            return ServerResponse.createByErrorMsg("密码错误");
        }
        //登陆成功的密码制空
        user.setPassword(StringUtils.EMPTY);
        return ServerResponse.createBySuccess("登陆成功", user);
    }

    @Override
    public ServerResponse<String> register(User user) {
        int resultCount = userMapper.checkUserName(user.getUserName());
        if (resultCount > 0) {
            return ServerResponse.createByErrorMsg("用户名已存在");
        }
        resultCount = userMapper.checkEmail(user.getEmail());
        if (resultCount > 0) {
            return ServerResponse.createByErrorMsg("email已存在");
        }
        user.setUserType(UserType.User.getType());

        //todo MD5加密

        user.setPassword(MD5Util.MD5EncodeUtf8(user.getPassword()));
        resultCount = userMapper.insert(user);

        if (resultCount == 0) return ServerResponse.createByErrorMsg("注册失败");
        return ServerResponse.createBySuccessMsg("注册成功");
    }

//    public ServerResponse<String> checkValid(String str, String type) {
//
//    }
}
