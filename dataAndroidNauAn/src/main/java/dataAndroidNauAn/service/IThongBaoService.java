package dataAndroidNauAn.service;

import java.util.List;

import dataAndroidNauAn.dto.ThongBaoDTO;
import dataAndroidNauAn.entity.MonAnEntity;

public interface IThongBaoService {
	ThongBaoDTO save(String user, MonAnEntity mon);
	
	List<ThongBaoDTO> getThongBao(String user);
	List<ThongBaoDTO> getAllThongBao(String user);
	
	ThongBaoDTO update(ThongBaoDTO dto);

}
