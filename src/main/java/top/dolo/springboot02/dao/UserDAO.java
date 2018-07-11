package top.dolo.springboot02.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.dolo.springboot02.entities.User;

public interface UserDAO extends JpaRepository<User, Integer>{

    public User findByName(String name);

}
