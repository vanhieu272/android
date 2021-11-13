package dataAndroidNauAn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dataAndroidNauAn.converter.DanhMucConverter;
import dataAndroidNauAn.dto.DanhMucDTO;
import dataAndroidNauAn.entity.DanhMucEntity;
import dataAndroidNauAn.repository.DanhMucRepository;
import dataAndroidNauAn.service.IDanhMucService;

@Service
public class DanhMucSerivice implements IDanhMucService{

	@Autowired
	DanhMucRepository repository;
	
	@Autowired
	DanhMucConverter converter;
	
	@Override
	public DanhMucDTO save(DanhMucDTO model) {
		DanhMucEntity entity = new DanhMucEntity();
		entity = converter.toEntity(model);
		repository.save(entity);
		return converter.toDTO(entity);
	}

}
