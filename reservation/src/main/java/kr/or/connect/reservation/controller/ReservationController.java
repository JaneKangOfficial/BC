package kr.or.connect.reservation.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReservationController {

	@GetMapping(path="/mainpage")
	public String showMainPage(HttpSession session) {
		System.out.println("ReservationController.java => showMainPage");
		return "mainpage";
	}
	
	@GetMapping(path="/detail")
	public String showDetail(HttpSession session) {
		System.out.println("ReservationController.java => showDetail");
		return "detail";
	}
	
	@GetMapping(path="/reserve")
	public String showReserve(HttpSession session) {
		System.out.println("ReservationController.java => showReserve");
		return "reserve";
	}
	
}