package dataAndroidNauAn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dataAndroidNauAn.entity.DanhMucEntity;

public interface DanhMucRepository extends JpaRepository<DanhMucEntity, Long>{
	public DanhMucEntity findOneByMaDM(String maDM);
}
