package dataAndroidNauAn.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dataAndroidNauAn.dto.MonAnDTO;
import dataAndroidNauAn.dto.ThongBaoDTO;
import dataAndroidNauAn.dto.UserDTO;
import dataAndroidNauAn.service.impl.ThongBaoService;

@RestController
public class ThongBaoAPI {
	
	@Autowired
	ThongBaoService service;
	
	@GetMapping(value = "thongBao")
	public List<ThongBaoDTO> getThongBaoByUser(@RequestParam("userName") String userName){
		return service.getAllThongBao(userName);
	}
	
	@PutMapping(value = "/thongBao/{id}")
	public ThongBaoDTO updateUser(@RequestBody ThongBaoDTO model, @PathVariable("id") long id) {
		model.setId(id);
		return service.update(model);
	}
}
