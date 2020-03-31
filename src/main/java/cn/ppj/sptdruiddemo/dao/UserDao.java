package cn.ppj.sptdruiddemo.dao;

import cn.ppj.sptdruiddemo.model.User;

public interface UserDao {
    //增
    public void add(User user);

    //删
    public void delete(int id);

    //改
    public void update(User user);

    //查
    public User get(int id);


    //TODO

}
