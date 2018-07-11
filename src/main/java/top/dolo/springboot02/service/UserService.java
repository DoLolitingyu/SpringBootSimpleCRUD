package top.dolo.springboot02.service;


import top.dolo.springboot02.entities.User;

public interface UserService {

    public boolean save(User user);

    public boolean login(User user);

}
