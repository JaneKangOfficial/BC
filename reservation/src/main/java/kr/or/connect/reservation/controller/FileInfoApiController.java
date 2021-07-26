package kr.or.connect.reservation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.FileInfo;
import kr.or.connect.reservation.service.FileInfoService;

@RestController
@RequestMapping(path="/fileInfo")
public class FileInfoApiController {

	@Autowired
	FileInfoService fileInfoService;
	
	@GetMapping
	public Map<String, Object> list(@RequestParam(name="id", required=false, defaultValue="0") int id) {
		System.out.println("FileInfoApiController.java => list");
		
		List<FileInfo> list = fileInfoService.getFileInfoList();
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		
		return map;
	}
	
}
