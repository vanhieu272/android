package dataAndroidNauAn.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dataAndroidNauAn.converter.ThongBaoConverter;
import dataAndroidNauAn.dto.ThongBaoDTO;
import dataAndroidNauAn.dto.YeuThichDTO;
import dataAndroidNauAn.entity.MonAnEntity;
import dataAndroidNauAn.entity.ThongBaoEntity;
import dataAndroidNauAn.entity.UserEntity;
import dataAndroidNauAn.entity.YeuThichEntity;
import dataAndroidNauAn.repository.MonAnRepository;
import dataAndroidNauAn.repository.ThongBaoRepository;
import dataAndroidNauAn.repository.UserRepository;
import dataAndroidNauAn.repository.YeuThichRepository;
import dataAndroidNauAn.service.IThongBaoService;

@Service
public class ThongBaoService implements IThongBaoService{

	
	@Autowired
	ThongBaoRepository repository;
	
	@Autowired
	ThongBaoConverter converter;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	YeuThichRepository ytRepository;
	
	@Autowired 
	MonAnRepository monRepository;
	

	@Override
	public ThongBaoDTO save(String user, MonAnEntity mon) {
		ThongBaoEntity entity = new ThongBaoEntity();
		UserEntity userEntity = userRepository.findOneByUserName(user);
		entity.setNoiDung("Món "+mon.getTenMon()+" bạn thích có 1 công thức mới");
		entity.setStatus(0);
		entity.setMaMon(mon.getId());
		entity.setUserTB(userEntity);
		repository.save(entity);
		return converter.toDTO(entity);
	}


	@Override
	public List<ThongBaoDTO> getThongBao(String user) {
		UserEntity userEntity = userRepository.findOneByUserName(user);
		List<YeuThichEntity> listYeuThichEntity = ytRepository.findByUserYT(userEntity);
		//lấy tên các món yêu thích
		String tenMonYT = "";
		for(int i = listYeuThichEntity.size()-1;i>=0;i--) {
			tenMonYT += " " + listYeuThichEntity.get(i);
		}

		//lấy tất cả các mon
		List<MonAnEntity> listMonAn = monRepository.findAll();
		//xem trong 5 món mới nhất có nằm trong yêu thích ko
		
		List<ThongBaoEntity> listTB = new ArrayList<ThongBaoEntity>();
		
		for (int j = listMonAn.size()-1; j>=listMonAn.size()-6; j--) {
			MonAnEntity mon = listMonAn.get(j);
			if(tenMonYT.contains(mon.getTenMon())) {
				ThongBaoEntity thongBaoEntity = new ThongBaoEntity();
				thongBaoEntity.setMaMon(mon.getId());
				thongBaoEntity.setNoiDung("Món "+mon.getTenMon()+" bạn thích có 1 công thức mới ");
				thongBaoEntity.setStatus(0);
				thongBaoEntity.setUserTB(userEntity);
				listTB.add(thongBaoEntity);
			}
		}
		List<ThongBaoDTO> listTbDTO = new ArrayList<ThongBaoDTO>();
		for (ThongBaoEntity thongBaoEntity : listTB) {
			listTbDTO.add(converter.toDTO(thongBaoEntity));
		}
		return listTbDTO;
	}


	@Override
	public List<ThongBaoDTO> getAllThongBao(String user) {
		UserEntity userEntity = userRepository.findOneByUserName(user);
		List<ThongBaoEntity> listEntities = repository.findByuserTB(userEntity);
		List<ThongBaoDTO> listDTO = new ArrayList<>();
		for (ThongBaoEntity entity : listEntities) {
			listDTO.add(converter.toDTO(entity));
		}
		return listDTO;
	}


	@Override
	public ThongBaoDTO update(ThongBaoDTO dto) {
		ThongBaoEntity oldEntity = repository.findOne(dto.getId()); //lấy entity cũ
		ThongBaoEntity newEntity = converter.toEntity(dto, oldEntity); //cập nhật entity
		repository.save(newEntity);
		return converter.toDTO(newEntity);
	}

}
