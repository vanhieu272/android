package dataAndroidNauAn.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dataAndroidNauAn.converter.MonAnConverter;
import dataAndroidNauAn.dto.MonAnDTO;
import dataAndroidNauAn.entity.DanhMucEntity;
import dataAndroidNauAn.entity.MonAnEntity;
import dataAndroidNauAn.repository.DanhMucRepository;
import dataAndroidNauAn.repository.MonAnRepository;
import dataAndroidNauAn.service.IMonAnService;

@Service
public class MonAnService implements IMonAnService{

	@Autowired
	MonAnConverter converter;
	
	@Autowired
	MonAnRepository repository;
	
	@Autowired
	DanhMucRepository dmRepository;
	
	@Override
	public MonAnDTO save(MonAnDTO dto) {
		MonAnEntity entity = new MonAnEntity();
		entity = converter.toEntity(dto);
		DanhMucEntity danhMucEntity = dmRepository.findOneByMaDM(dto.getMaDM());
		entity.setdMuc(danhMucEntity);
		repository.save(entity);
		return converter.toDTO(entity);
	}

	@Override
	public List<MonAnDTO> getByMaDM(String maDM) {
		DanhMucEntity dmEntity = dmRepository.findOneByMaDM(maDM);
		List<MonAnEntity> listEntity = new ArrayList<>();
		List<MonAnDTO> listDTO = new ArrayList<>();
		listEntity = repository.findAll();
		for (MonAnEntity entity : listEntity) {
			if(converter.toDTO(entity).getMaDM()==dmEntity.getMaDM())
				listDTO.add(converter.toDTO(entity));
		}
		return listDTO;
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
