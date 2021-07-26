package kr.or.connect.reservation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.DisplayInfo;
import kr.or.connect.reservation.service.DisplayInfoService;

@RestController
@RequestMapping(path="/displayInfo")
public class DisplayInfoApiController {

	@Autowired
	DisplayInfoService displayInfoService;
	
	@GetMapping
	public Map<String, Object> list(@RequestParam(name="id", required=false, defaultValue="0") int id) {
		System.out.println("DisplayInfoApiController.java => list");
		
		List<DisplayInfo> list = displayInfoService.getDisplayInfoList();
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		
		return map;
	}
	
	@GetMapping("/{id}")
	public DisplayInfo select(@PathVariable(name="id") int id) {
		System.out.println("DisplayInfoApiController.java => select");
		
		DisplayInfo select = displayInfoService.selectDisplayInfo(id);
		
		return select;
	}
}
