package dataAndroidNauAn.converter;

import org.springframework.stereotype.Component;

import dataAndroidNauAn.dto.LichSuTimKiemDTO;
import dataAndroidNauAn.entity.LichSuTimKiemEntity;

@Component
public class LichSuTimKiemConverter {

	public LichSuTimKiemEntity toEntity(LichSuTimKiemDTO dto) {
		LichSuTimKiemEntity entity = new LichSuTimKiemEntity();
		entity.setNoiDung(dto.getNoiDung());
		return entity;
	}
	
	public LichSuTimKiemDTO toDTO(LichSuTimKiemEntity entity) {
		LichSuTimKiemDTO dto = new LichSuTimKiemDTO();
		dto.setId(entity.getId());
		dto.setNoiDung(entity.getNoiDung());
		dto.setUserName(entity.getUserLS().getUserName());;
		return dto;
	}
}
