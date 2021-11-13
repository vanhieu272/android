package dataAndroidNauAn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "danhMucCon")
public class DanhMucConEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "tenDMC")
	private String tenDMC;
	
	@Column(name = "anh")
	private String anh;
	
	@ManyToOne
	@JoinColumn(name = "maDM")
	private DanhMucEntity dMuc;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTenDMC() {
		return tenDMC;
	}

	public void setTenDMC(String tenDMC) {
		this.tenDMC = tenDMC;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public DanhMucEntity getDanhMuc() {
		return dMuc;
	}

	public void setDanhMuc(DanhMucEntity danhMuc) {
		this.dMuc = danhMuc;
	}
	
	
	
}
