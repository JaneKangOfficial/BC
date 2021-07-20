package kr.or.connect.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.connect.reservation.dto.ReservationInfo;
import kr.or.connect.reservation.service.ReservationInfoService;

@Controller
public class ReservationInfoController {
	
//	private static final Logger logger = LoggerFactory.getLogger(ReservationInfoController.class);

	@Autowired
	ReservationInfoService reservationInfoService;
	
	@RequestMapping(value="/reservationInfo/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(@RequestParam(name="id", required=false, defaultValue = "0") int id, ModelMap modelMap) {
		System.out.println("ReservationInfoController.java => list");
		
		List<ReservationInfo> list = reservationInfoService.getReservationInfoList(id);
		
		modelMap.addAttribute("list", list);
		
		return "reservationInfo";
	}
}
