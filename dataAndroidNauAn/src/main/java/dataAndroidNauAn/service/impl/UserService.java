package dataAndroidNauAn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dataAndroidNauAn.converter.UserConverter;
import dataAndroidNauAn.dto.UserDTO;
import dataAndroidNauAn.entity.UserEntity;
import dataAndroidNauAn.repository.userRepository;
import dataAndroidNauAn.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private userRepository repository;
	
	@Autowired
	private UserConverter converter;
	
	@Override
	public UserDTO save(UserDTO model) {
		UserEntity entity = new UserEntity();
		entity = converter.toEntity(model);
		repository.save(entity);
		return converter.toDTO(entity);
	}

	@Override
	public UserDTO getUser(String userName) {
		UserEntity entity;
		entity = repository.findOneByUserName(userName);
		return converter.toDTO(entity);
	}

}
