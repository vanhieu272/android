package dataAndroidNauAn.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dataAndroidNauAn.dto.LichSuTimKiemDTO;
import dataAndroidNauAn.service.impl.LichSuTimKiemService;

@RestController
public class LichSuTimKiemAPI {

	@Autowired
	LichSuTimKiemService service;
	
	@GetMapping("/lichsu")
	public List<LichSuTimKiemDTO> getLichSuByUserId(@RequestParam("username") String username){
		List<LichSuTimKiemDTO> listDTO = service.getLichSuByUserId(username);
		return listDTO;
	}
	
	@PostMapping("/lichsu")
	public LichSuTimKiemDTO add(@RequestBody LichSuTimKiemDTO dto) {
		return service.add(dto);
	}
	
	@DeleteMapping("/lichsu")
	public void delete(@RequestParam("id") Long id) {
		service.delete(id);
	}
	
	@DeleteMapping("/lichsuAll")
	public void deleteAll(@RequestParam("username") String username) {
		service.deleteAll(username);;
	}
	
}
