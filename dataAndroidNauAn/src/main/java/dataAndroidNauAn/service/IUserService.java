package dataAndroidNauAn.service;

import dataAndroidNauAn.dto.UserDTO;

public interface IUserService {
	UserDTO save(UserDTO model);
	UserDTO getUser(String userName);
}
