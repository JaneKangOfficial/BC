package kr.or.connect.reservation.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.ReservationInfo;
import kr.or.connect.reservation.service.ReservationInfoService;

@RestController
@RequestMapping(path="/reservation")
public class ReservationApiController {
	
	@Autowired
	ReservationInfoService reservationInfoService;
	
	@GetMapping
	public Map<String, Object> list(@RequestParam(name="id", required = false, defaultValue = "0") int id) {
		System.out.println("ReservationApiController.java => list");
		
		List<ReservationInfo> list = reservationInfoService.getReservationInfoList();
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		
		return map;
	}
	
	@DeleteMapping("/{id}")
	public Map<String, Object> delete(@PathVariable(name="id") int id) {
		System.out.println("ReservationApiController.java => delete");
		
		int delete = reservationInfoService.deleteReservationInfo(id);
		
		return Collections.singletonMap("success", delete > 0 ? "true" : "false");
	}
}
