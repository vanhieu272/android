package dataAndroidNauAn.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "congThuc")
public class CongThuctEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "congThuc")
	private String congThuc;
	
	@OneToMany(mappedBy = "cThuc")
	private List<AnhCongThucEntity> listAnh = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "mon")
	private MonAnEntity monCT;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCongThuc() {
		return congThuc;
	}

	public void setCongThuc(String congThuc) {
		this.congThuc = congThuc;
	}

	public List<AnhCongThucEntity> getListAnh() {
		return listAnh;
	}

	public void setListAnh(List<AnhCongThucEntity> listAnh) {
		this.listAnh = listAnh;
	}

	public MonAnEntity getMon() {
		return monCT;
	}

	public void setMon(MonAnEntity mon) {
		this.monCT = mon;
	}
	
	
}
