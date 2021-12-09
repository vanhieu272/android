package dataAndroidNauAn.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dataAndroidNauAn.converter.UserConverter;
import dataAndroidNauAn.dto.UserDTO;
import dataAndroidNauAn.entity.UserEntity;
import dataAndroidNauAn.repository.UserRepository;
import dataAndroidNauAn.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private UserConverter converter;
	
	PasswordEncoder passwordEncoder;
	
	@Override
	public UserDTO save(UserDTO model) {
		UserEntity entity;
		if(model.getId() == null) {
			entity = new UserEntity();
			entity = converter.toEntity(model);
		}
		else {
			UserEntity oldEntity = repository.findOne(model.getId()); //lấy entity cũ
			entity = converter.toEntity(model, oldEntity); //cập nhật entity
		}
		passwordEncoder=new BCryptPasswordEncoder();
		String encoderPassword=passwordEncoder.encode(entity.getPassWord());
		entity.setPassWord(encoderPassword);
		repository.save(entity);
		return converter.toDTO(entity);
	}

	@Override
	public UserDTO getUser(String userName) {
		UserEntity entity;
		entity = repository.findOneByUserName(userName);
		return converter.toDTO(entity);
	}

	@Override
	public List<UserDTO> getAllUser() {
		// TODO Auto-generated method stub
		List<UserDTO> listDTO = new ArrayList<>();
		List<UserEntity> listEnity = new ArrayList<>();
		listEnity = repository.findAll();
		for (UserEntity entity : listEnity) {
			listDTO.add(converter.toDTO(entity));
		}
		return listDTO;
	}
	

}
