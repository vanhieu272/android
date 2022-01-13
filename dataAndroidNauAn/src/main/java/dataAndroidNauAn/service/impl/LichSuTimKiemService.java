package dataAndroidNauAn.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dataAndroidNauAn.converter.LichSuTimKiemConverter;
import dataAndroidNauAn.dto.LichSuTimKiemDTO;
import dataAndroidNauAn.entity.LichSuTimKiemEntity;
import dataAndroidNauAn.entity.UserEntity;
import dataAndroidNauAn.repository.LichSuTimKiemRepository;
import dataAndroidNauAn.repository.UserRepository;
import dataAndroidNauAn.service.ILichSuTimKiem;

@Service
public class LichSuTimKiemService implements ILichSuTimKiem{

	@Autowired
	LichSuTimKiemConverter converter;
	
	@Autowired
	LichSuTimKiemRepository repository;
	
	@Autowired 
	UserRepository userRepository;
	
	
	
	@Override
	public List<LichSuTimKiemDTO> getLichSuByUserId(String username) {
		UserEntity user = userRepository.findOneByUserName(username);
		List<LichSuTimKiemEntity> listentity = repository.findByUserLS(user);
		List<LichSuTimKiemDTO> listDTO = new ArrayList<LichSuTimKiemDTO>();
		for (LichSuTimKiemEntity lichSuTimKiemEntity : listentity) {
			listDTO.add(converter.toDTO(lichSuTimKiemEntity));
		}
		return listDTO;
	}



	@Override
	public LichSuTimKiemDTO add(LichSuTimKiemDTO model) {
		LichSuTimKiemEntity entity = converter.toEntity(model);
		UserEntity userEntity = userRepository.findOneByUserName(model.getUserName());
		entity.setUserLS(userEntity);
		repository.save(entity);
		return converter.toDTO(entity);
	}



	@Override
	public void delete(Long id) {
		repository.delete(id);
	}



	@Override
	public void deleteAll(String username) {
		UserEntity userEntity = userRepository.findOneByUserName(username);
		List<LichSuTimKiemEntity> listLSEntity = repository.findByUserLS(userEntity);
		for (LichSuTimKiemEntity lichSuTimKiemEntity : listLSEntity) {
			repository.delete(lichSuTimKiemEntity);
		}
	}

}
