package dataAndroidNauAn.converter;

import org.springframework.stereotype.Component;

import dataAndroidNauAn.dto.DanhMucConDTO;
import dataAndroidNauAn.entity.DanhMucConEntity;

@Component
public class DanhMucConConverter {
	
	public DanhMucConEntity toEntity(DanhMucConDTO dto) {
		DanhMucConEntity entity = new DanhMucConEntity();
		entity.setTenDMC(dto.getTenDMC());
		entity.setAnh(dto.getAnh());
		return entity;
	}
	
	public DanhMucConDTO toDTO(DanhMucConEntity entity) {
		DanhMucConDTO dto = new DanhMucConDTO();
		if(entity.getId() != null) {
			dto.setId(entity.getId());
		}
		dto.setTenDMC(entity.getTenDMC());
		dto.setAnh(entity.getAnh());
		dto.setMaDM(entity.getDanhMuc().getMaDM());
		return dto;
	}
	
}
