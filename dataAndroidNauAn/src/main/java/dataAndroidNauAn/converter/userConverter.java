package dataAndroidNauAn.converter;

import org.springframework.stereotype.Component;

import dataAndroidNauAn.dto.userDTO;
import dataAndroidNauAn.entity.UserEntity;

@Component
public class userConverter {

	public UserEntity toEntity(userDTO dto) {
		UserEntity entity = new UserEntity();
		entity.setUserName(dto.getUserName());
		entity.setPassWord(dto.getPassWord());
		entity.setStatus(dto.getStatus());
		return entity;
	}
	
	public userDTO toDTO(UserEntity entity) {
		userDTO dto = new userDTO();
		if(entity.getId() != null) {
			dto.setId(entity.getId());
		}
		dto.setUserName(entity.getUserName());
		dto.setPassWord(entity.getPassWord());
		dto.setStatus(entity.getStatus());
		return dto;
	}
	
	public UserEntity toEntity(userDTO dto, UserEntity entity) {
		entity.setUserName(dto.getUserName());
		entity.setPassWord(dto.getPassWord());
		entity.setStatus(dto.getStatus());
		return entity;
	}
	
}
