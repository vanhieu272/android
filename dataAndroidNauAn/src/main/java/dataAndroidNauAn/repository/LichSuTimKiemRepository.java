package dataAndroidNauAn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dataAndroidNauAn.entity.LichSuTimKiemEntity;
import dataAndroidNauAn.entity.UserEntity;

public interface LichSuTimKiemRepository extends JpaRepository<LichSuTimKiemEntity, Long>{
	List<LichSuTimKiemEntity> findByUserLS(UserEntity user);
}
