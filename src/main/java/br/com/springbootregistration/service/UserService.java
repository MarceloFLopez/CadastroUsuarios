package br.com.springbootregistration.service;

import java.util.List;

import br.com.springbootregistration.dto.UserRegistrationDTO;
import br.com.springbootregistration.model.User;

public interface UserService {

	List<UserRegistrationDTO> getUsers();
	User saveUser(UserRegistrationDTO dto); 
	UserRegistrationDTO getUserById(long id);
	void deleteUserRegistrationDTO(long id);
}
