package dataAndroidNauAn.api;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import dataAndroidNauAn.dto.MonAnDTO;
import dataAndroidNauAn.service.impl.MonAnService;

@RestController
public class MonAnAPI {

	@Autowired
	MonAnService service;
	
	@PostMapping(value = "/monAn")
	public MonAnDTO save(@RequestBody MonAnDTO model) {
		return service.save(model);
	}
	@GetMapping(value = "/monAn")
	public List<MonAnDTO> getDanhMucCon(@RequestParam("maDM") String maDM){
		return service.getByMaDM(maDM);
	}
	
}
