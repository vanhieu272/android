package dataAndroidNauAn.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dataAndroidNauAn.dto.MonAnDTO;
import dataAndroidNauAn.dto.YeuThichDTO;
import dataAndroidNauAn.service.impl.YeuThichService;

@RestController
public class YeuThichAPI {
	
	@Autowired
	YeuThichService service;
	
	@PostMapping(value = "yeuThich")
	public YeuThichDTO save(@RequestBody YeuThichDTO dto) {
		return service.save(dto);
	}
	
	@GetMapping(value = "yeuThich")
	public List<MonAnDTO> getYeuThichByUser(@RequestParam("userName") String userName){
		return service.getMonYeuThichByUser(userName);
	}
	
	@GetMapping(value = "userYeuThich")
	public List<String> getUser(){
		return service.getAllUser();
	}
	
	@DeleteMapping(value = "yeuThich")
	public void delete(@RequestParam("id") Long id) {
		service.delete(id);
	}
	
	@GetMapping(value = "motYeuThich")
	public YeuThichDTO getYeuThichByMaMon(@RequestParam("maMon") String maMon, @RequestParam("userName") String userName) {
		return service.getYeuThichByMaMon(maMon, userName);
	}

}
