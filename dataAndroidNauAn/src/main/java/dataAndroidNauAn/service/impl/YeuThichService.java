package dataAndroidNauAn.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dataAndroidNauAn.converter.MonAnConverter;
import dataAndroidNauAn.converter.YeuThichConverter;
import dataAndroidNauAn.dto.MonAnDTO;
import dataAndroidNauAn.dto.YeuThichDTO;
import dataAndroidNauAn.entity.MonAnEntity;
import dataAndroidNauAn.entity.UserEntity;
import dataAndroidNauAn.entity.YeuThichEntity;
import dataAndroidNauAn.repository.MonAnRepository;
import dataAndroidNauAn.repository.UserRepository;
import dataAndroidNauAn.repository.YeuThichRepository;
import dataAndroidNauAn.service.IYeuThichService;

@Service
public class YeuThichService implements IYeuThichService{

	@Autowired
	YeuThichConverter converter;
	
	@Autowired
	YeuThichRepository repository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	MonAnRepository monAnRepository;
	
	@Autowired
	MonAnConverter monConverter;
	
	@Override
	public YeuThichDTO save(YeuThichDTO model) {
		YeuThichEntity entity = converter.toEntity(model);
		UserEntity userEntity = userRepository.findOneByUserName(model.getUser());
		entity.setUserYT(userEntity);
		repository.save(entity);
		return converter.toDTO(entity);
	}

	@Override
	public List<MonAnDTO> getMonYeuThichByUser(String user) {
		UserEntity userEntity = userRepository.findOneByUserName(user);
		List<YeuThichEntity> listEntities = repository.findByUserYT(userEntity);
		List<MonAnDTO> listMonDTO = new ArrayList<>();
		for (YeuThichEntity entity : listEntities) {
			MonAnEntity monAnEntity = new MonAnEntity();
			monAnEntity = monAnRepository.findOneByMaMon(entity.getMaMon());
			listMonDTO.add(monConverter.toDTO(monAnEntity));
			
		}
		return listMonDTO;
	}

	@Override
	public List<String> getAllUser() {
		List<YeuThichEntity> listEntities = repository.findAll();
		String tmpUser="";
		List<String> listUser = new ArrayList<>();
		for (YeuThichEntity entity : listEntities) {
			if(!tmpUser.contains(entity.getUserYT().getUserName())) {
				listUser.add(entity.getUserYT().getUserName());
				tmpUser+=" "+entity.getUserYT().getUserName();
			}
		}
		return listUser;
	}

	@Override
	public List<YeuThichDTO> getYeuThichByUser(String user) {
		UserEntity userEntity = userRepository.findOneByUserName(user);
		List<YeuThichEntity> listEntities = repository.findByUserYT(userEntity);
		List<YeuThichDTO> listDTO = new ArrayList<>();
		for (YeuThichEntity entity : listEntities) {
			listDTO.add(converter.toDTO(entity));
		}
		return listDTO;
	}

	@Override
	public void delete(Long id) {
		repository.delete(id);
	}

	@Override
	public YeuThichDTO getYeuThichByMaMon(String maMon, String user) {
		List<YeuThichDTO> yeuThichDTOs = getYeuThichByUser(user);
		for (YeuThichDTO yeuThichDTO : yeuThichDTOs) {
			if(yeuThichDTO.getMaMon().equals(maMon)) {
				return yeuThichDTO;
			}
		}
		return null;
	}

}
