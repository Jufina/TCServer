package com.complete.repository;

import com.complete.domain.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByLoginAndPassword(String login,String password);
    List<User> findByToken(String  token);

}
