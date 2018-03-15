package com.bsb.dao;

import com.bsb.model.User;


/**
 * 接口模式
 */
public interface IUserDao {

    //以接口形式定义数据库操作方法 只需要在MyBatis映射文件中对齐进行映射就可使用

    User selectById(int id);

    User selectByName(String username);

}
