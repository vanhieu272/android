package dataAndroidNauAn.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dataAndroidNauAn.dto.CongThucDTO;
import dataAndroidNauAn.service.impl.CongThucService;

@RestController
public class CongThucAPI {

	@Autowired
	CongThucService service;
	
	@GetMapping(value = "/congThuc")
	public CongThucDTO createCongThuc(@RequestBody CongThucDTO model) {
		return service.save(model);
	}
}
