package dataAndroidNauAn.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dataAndroidNauAn.converter.DanhMucConConverter;
import dataAndroidNauAn.dto.DanhMucConDTO;
import dataAndroidNauAn.entity.DanhMucConEntity;
import dataAndroidNauAn.entity.DanhMucEntity;
import dataAndroidNauAn.repository.DanhMucConRepository;
import dataAndroidNauAn.repository.DanhMucRepository;
import dataAndroidNauAn.service.IDanhMucConService;

@Service
public class DanhMucConService implements IDanhMucConService{

	@Autowired
	DanhMucConConverter converter;
	
	@Autowired
	DanhMucConRepository repository;
	
	@Autowired
	DanhMucRepository dmRepository;
	
	@Override
	public DanhMucConDTO save(DanhMucConDTO dto) {
		DanhMucConEntity entity = new DanhMucConEntity();
		entity = converter.toEntity(dto);
		DanhMucEntity danhMucEntity = dmRepository.findOneByMaDM(dto.getMaDM());
		entity.setDanhMuc(danhMucEntity);
		repository.save(entity);
		return converter.toDTO(entity);
	}

//	@Override
//	public List<DanhMucConDTO> getByIdDM(Long idDM) {
//		List<DanhMucConDTO> listDTO = new ArrayList<>();
//		List<DanhMucConEntity> listEntities = new ArrayList<>();
//		DanhMucEntity danhMucEntity = dmRepository.findOneById(idDM);
//		listEntities = repository.findByDanhMucEntities(danhMucEntity);
//		for (DanhMucConEntity danhMucConEntity : listEntities) {
//			listDTO.add(converter.toDTO(danhMucConEntity));
//		}
//		return listDTO;
//	}

	
}
