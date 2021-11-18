package dataAndroidNauAn.service;

import dataAndroidNauAn.dto.ThongBaoDTO;
import dataAndroidNauAn.entity.MonAnEntity;
import dataAndroidNauAn.entity.UserEntity;

public interface IThongBaoService {
	ThongBaoDTO save(String user, MonAnEntity mon);
}
