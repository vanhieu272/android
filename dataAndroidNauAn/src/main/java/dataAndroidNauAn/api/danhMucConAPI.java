package dataAndroidNauAn.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dataAndroidNauAn.dto.DanhMucConDTO;
import dataAndroidNauAn.service.impl.DanhMucConService;

@RestController
public class danhMucConAPI {

	@Autowired
	DanhMucConService service;
	
	@PostMapping(value = "/danhMucCon")
	public DanhMucConDTO save(@RequestBody DanhMucConDTO model) {
		return service.save(model);
	}
	
//	@GetMapping(value = "/danhMucCon")
//	public List<DanhMucConDTO> getDanhMucCon(@RequestParam(name = "loaiDM") Long idDM){
//		return service.getByIdDM(idDM);
//	}
}
