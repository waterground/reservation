package com.sjh.web.reservation.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sjh.web.member.dto.MemberDto;
import com.sjh.web.reservation.dto.ReservationDto;
import com.sjh.web.reservation.service.IReservationService;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

	@Inject
	IReservationService service;

	@ModelAttribute("cp")
	public String getContextPath(HttpServletRequest request) {
		return request.getContextPath();
	}

	// 예약 목록 확인
	@GetMapping("/list")
	public String listUpReservation(Model model, HttpSession session) {
		
		ReservationDto r = new ReservationDto();
		r.setMemberId(((MemberDto)session.getAttribute("member")).getId());
		model.addAttribute("list", service.listUpReservation(r));

		return "/reservation/reservationList";
	}

	// 예약 등록
	@GetMapping("/{productId}")
	public String registerOk(@ModelAttribute("reservation") ReservationDto reservation, Model model,
			@PathVariable("productId") int productId) {

		model.addAttribute("reservation", new ReservationDto());
		model.addAttribute("productId", productId);

		return "/reservation/reservation";
	}

	// 예약 등록 처리
	@PostMapping("/{productId}")
	public String registerWork(@ModelAttribute("reservation") ReservationDto reservation, Model model) {

		service.addReservation(reservation);
		model.addAttribute("reservation", reservation);

		return "redirect:/reservation/list";
	}

	// 예약 취소
	@GetMapping("/remove/{id}")
	public String cancelReservation(@PathVariable("id") int id) {
		service.removeReservation(id);
		return "redirect:/reservation/list";
	}
}
