package dataAndroidNauAn.service;

import dataAndroidNauAn.dto.userDTO;

public interface IUserService {
	userDTO save(userDTO model);
	userDTO getUser(String userName);
}
