package com.zhan.gmall.user.service.impl;

import com.zhan.gmall.user.bean.UserInfo;
import com.zhan.gmall.user.mapper.UserMapper;
import com.zhan.gmall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<UserInfo> getUserInfoListAll() {
        return userMapper.selectAll();
    }

    @Override
    public void addUser(UserInfo userInfo) {
        userMapper.insertSelective(userInfo);

    }

    @Override
    public void updateUser(UserInfo userInfo) {
        userMapper.updateByPrimaryKeySelective(userInfo);
    }

    @Override
    public void updateUserByName(String name, UserInfo userInfo) {
        Example example = new Example(UserInfo.class);
        example.createCriteria().andEqualTo("name", name);

        userMapper.updateByExampleSelective(userInfo, example);
    }

    @Override
    public void deleteUser(UserInfo userInfo) {
        userMapper.deleteByPrimaryKey(userInfo.getId());

    }

    @Override
    public UserInfo getUserById(String id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
