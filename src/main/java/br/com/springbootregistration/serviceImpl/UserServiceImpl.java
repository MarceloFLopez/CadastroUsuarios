package br.com.springbootregistration.serviceImpl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.springbootregistration.dto.UserRegistrationDTO;
import br.com.springbootregistration.model.Role;
import br.com.springbootregistration.model.User;
import br.com.springbootregistration.repository.UserRepository;
import br.com.springbootregistration.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	@Override
	public List<UserRegistrationDTO> getUsers() {
		return null;
	}

	@Override
	public User saveUser(UserRegistrationDTO dto) {
		User user = new User(dto.getFirstName(), dto.getLastName(), dto.getEmail(), dto.getPassword(),
				Arrays.asList(new Role( "ROLE_USER")));
		return userRepository.save(user);

	}

	@Override
	public UserRegistrationDTO getUserById(long id) {
		return null;
	}

	@Override
	public void deleteUserRegistrationDTO(long id) {

	}

}
