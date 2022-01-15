package dataAndroidNauAn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dataAndroidNauAn.entity.ThongBaoEntity;
import dataAndroidNauAn.entity.UserEntity;

public interface ThongBaoRepository extends JpaRepository<ThongBaoEntity, Long>{
	List<ThongBaoEntity> findByuserTB(UserEntity user);

}
