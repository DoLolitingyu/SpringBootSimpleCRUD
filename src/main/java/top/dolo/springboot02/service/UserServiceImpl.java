package top.dolo.springboot02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.dolo.springboot02.dao.UserDAO;
import top.dolo.springboot02.entities.User;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDAO userDAO;

    @Override
    public boolean save(User user) {
        String name = user.getName();
        User result = userDAO.findByName(name);
        if(result == null){
            userDAO.save(user);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean login(User user) {
        String name = user.getName();
        String password = user.getPassword();
        User result = userDAO.findByName(name);
        if(result!=null && name.equals(result.getName()) && password.equals(result.getPassword())){
            return true;
        }else{
            return false;
        }
    }
}
