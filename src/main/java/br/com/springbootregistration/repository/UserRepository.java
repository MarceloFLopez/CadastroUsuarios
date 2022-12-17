package br.com.springbootregistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.springbootregistration.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
