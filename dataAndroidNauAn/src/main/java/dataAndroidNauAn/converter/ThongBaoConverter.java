package dataAndroidNauAn.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dataAndroidNauAn.dto.ThongBaoDTO;
import dataAndroidNauAn.dto.UserDTO;
import dataAndroidNauAn.entity.ThongBaoEntity;
import dataAndroidNauAn.entity.UserEntity;
import dataAndroidNauAn.repository.UserRepository;


@Component
public class ThongBaoConverter {

	@Autowired
	UserRepository usRepository;
	public ThongBaoEntity toEntity(ThongBaoDTO dto) {
		ThongBaoEntity entity = new ThongBaoEntity();
		entity.setNoiDung(dto.getNoiDung());
		entity.setStatus(dto.getStatus());
		entity.setMaMon(dto.getMaMon());;
		return entity;
	}
	
	public ThongBaoDTO toDTO(ThongBaoEntity entity) {
		ThongBaoDTO dto = new ThongBaoDTO();
		dto.setId(entity.getId());
		dto.setNoiDung(entity.getNoiDung());
		dto.setStatus(entity.getStatus());
		dto.setMaMon(entity.getId());
		dto.setUser(entity.getUserTB().getUserName());
		return dto;
	}
	
	public ThongBaoEntity toEntity(ThongBaoDTO dto, ThongBaoEntity entity) {
		entity.setId(dto.getId());
		entity.setMaMon(dto.getMaMon());
		entity.setNoiDung(dto.getNoiDung());
		entity.setUserTB(usRepository.findOneByUserName(dto.getUser()));
		entity.setStatus(dto.getStatus());
		return entity;
	}
}
