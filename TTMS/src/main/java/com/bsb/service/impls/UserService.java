package com.bsb.service.impls;

import com.bsb.common.ServerResponse;
import com.bsb.mapper.UserMapper;
import com.bsb.pojo.User;
import com.bsb.service.IUserService;
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

        User user = userMapper.selectLogin(username, password);
        if (user == null) {
            return ServerResponse.createByErrorMsg("密码错误");
        }
        //登陆成功的密码制空
        user.setPassword(StringUtils.EMPTY);
        return ServerResponse.createBySuccess("登陆成功", user);
    }
}
