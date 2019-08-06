package com.sevincfurkan.airlineticketingsystem.repository;

import com.sevincfurkan.airlineticketingsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    List<User> findAllByFirstName(String firstName);
    List<User> findAllByLastName(String lastName);
    User findByMail(String mail);
    User findByUserName(String userName);
    User findById(long id);

}
