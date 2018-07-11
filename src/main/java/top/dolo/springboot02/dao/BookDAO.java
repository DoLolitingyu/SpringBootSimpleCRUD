package top.dolo.springboot02.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import top.dolo.springboot02.entities.Book;

import java.util.Optional;


public interface BookDAO extends JpaRepository<Book,Integer>{


}
