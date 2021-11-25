package dataAndroidNauAn.service;

import java.util.List;

import dataAndroidNauAn.dto.MonAnDTO;
import dataAndroidNauAn.dto.YeuThichDTO;

public interface IYeuThichService {
	YeuThichDTO save(YeuThichDTO model);
	List<MonAnDTO> getMonYeuThichByUser(String user);
	List<YeuThichDTO> getYeuThichByUser(String user);
	List<String> getAllUser();
	void delete(Long id);
	YeuThichDTO getYeuThichByMaMon(String maMon, String user);
}
