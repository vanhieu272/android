package dataAndroidNauAn.service;

import java.util.List;

import dataAndroidNauAn.dto.LichSuTimKiemDTO;

public interface ILichSuTimKiem {

	List<LichSuTimKiemDTO> getLichSuByUserId(String username);
	
	LichSuTimKiemDTO add(LichSuTimKiemDTO model);
	
	void delete(Long id);
	
	void deleteAll(String username);
	
}
