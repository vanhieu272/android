package dataAndroidNauAn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dataAndroidNauAn.converter.CongThucConverter;
import dataAndroidNauAn.dto.CongThucDTO;
import dataAndroidNauAn.entity.CongThucEntity;
import dataAndroidNauAn.entity.MonAnEntity;
import dataAndroidNauAn.repository.CongThucRepository;
import dataAndroidNauAn.repository.MonAnRepository;
import dataAndroidNauAn.service.ICongThucService;

@Service
public class CongThucService implements ICongThucService{

	@Autowired
	CongThucConverter converter;
	
	@Autowired
	CongThucRepository repository;
	
	@Autowired
	MonAnRepository monAnRepository;
	@Override
	
	public CongThucDTO save(CongThucDTO model) {
		CongThucEntity entity = new CongThucEntity();
		entity = converter.toEntity(model);
		MonAnEntity monAnEntity = monAnRepository.findOneByMaMon(model.getMonCT());
		entity.setMon(monAnEntity);
		repository.save(entity);
		return converter.toDTO(entity);
	}

}
