package dataAndroidNauAn.converter;

import org.springframework.stereotype.Component;

import dataAndroidNauAn.dto.UserDTO;
import dataAndroidNauAn.entity.UserEntity;

@Component
public class UserConverter {

	public UserEntity toEntity(UserDTO dto) {
		UserEntity entity = new UserEntity();
		entity.setUserName(dto.getUserName());
		entity.setPassWord(dto.getPassWord());
		entity.setStatus(dto.getStatus());
		return entity;
	}
	
	public UserDTO toDTO(UserEntity entity) {
		UserDTO dto = new UserDTO();
		if(entity.getId() != null) {
			dto.setId(entity.getId());
		}
		dto.setUserName(entity.getUserName());
		dto.setPassWord(entity.getPassWord());
		dto.setStatus(entity.getStatus());
		return dto;
	}
	
	public UserEntity toEntity(UserDTO dto, UserEntity entity) {
		entity.setUserName(dto.getUserName());
		entity.setPassWord(dto.getPassWord());
		entity.setStatus(dto.getStatus());
		return entity;
	}
	
}
