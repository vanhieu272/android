package dataAndroidNauAn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dataAndroidNauAn.entity.MonAnEntity;

public interface MonAnRepository extends JpaRepository<MonAnEntity, Long>{
//	public List<MonAnEntity> findByMaDMEntities(Long maDM);
}
