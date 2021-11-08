package dataAndroidNauAn.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name="user")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "userName")
	private String userName;
	
	@Column(name = "passWord")
	private String passWord;
	
	@Column
	private int status;
	
	@OneToMany(mappedBy = "userYT")
	private List<YeuThichEntity> listYeuThich = new ArrayList<>();
	
	@OneToMany(mappedBy = "userTB")
	private List<ThongBaoEntity> listThongBao = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<YeuThichEntity> getListYeuThich() {
		return listYeuThich;
	}

	public void setListYeuThich(List<YeuThichEntity> listYeuThich) {
		this.listYeuThich = listYeuThich;
	}

	public List<ThongBaoEntity> getListThongBao() {
		return listThongBao;
	}

	public void setListThongBao(List<ThongBaoEntity> listThongBao) {
		this.listThongBao = listThongBao;
	}
	
	
	
	
}
