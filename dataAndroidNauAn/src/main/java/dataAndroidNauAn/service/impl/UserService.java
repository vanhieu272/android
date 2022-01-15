package dataAndroidNauAn.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
//			passwordEncoder=new BCryptPasswordEncoder();
//			String encoderPassword=passwordEncoder.encode(entity.getPassWord());
//			entity.setPassWord(encoderPassword);
		}
		else {
			UserEntity oldEntity = repository.findOne(model.getId()); //lấy entity cũ
			entity = converter.toEntity(model, oldEntity); //cập nhật entity
		}
		
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
	
	public UserDTO uploadFile(MultipartFile file, String userName) throws IllegalStateException, IOException {
		file.transferTo(new File("D:\\Nam3_Ki1\\LTDT_Android\\android\\dataAndroidNauAn\\src\\main\\resources\\static\\image\\"+file.getOriginalFilename()));
		
		UserEntity entity = repository.findOneByUserName(userName);
		entity.setAnh(file.getOriginalFilename());
		repository.save(entity);
		return converter.toDTO(entity);
	}
	
	

}
