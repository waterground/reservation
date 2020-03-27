package com.sjh.web.member.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sjh.web.member.dto.MemberDto;
import com.sjh.web.member.service.IMemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Inject
	IMemberService service;

	@ModelAttribute("cp")
	public String getContextPath(HttpServletRequest request) {
		return request.getContextPath();
	}

	@GetMapping("/login")
	public String login(Model model) {

		model.addAttribute("member", new MemberDto());

		return "/member/login";
	}

	@PostMapping("/login")
	public ModelAndView loginOk(@ModelAttribute("member") MemberDto m, HttpServletRequest request) {
		
		MemberDto mem = service.checkLogin(m);

		ModelAndView mav = new ModelAndView();

		if (mem == null) {
			mav.addObject("canLogin", false);
			mav.setViewName("/member/login");
		} else {
			HttpSession session = request.getSession();
			
			session.setAttribute("member", mem);
			mav.setViewName("redirect:/");
		}

		return mav;
	}
	
	@GetMapping("/join")
	public String joinForm(Model model) {
		
		model.addAttribute("member", new MemberDto());
		
		return "/member/join";
	}
	
	@PostMapping("/joinOk")
	public String joinOk(@ModelAttribute("member") MemberDto m) {
		
		service.addMember(m);
		
		return "/member/login";
	}

	// Logout
	@RequestMapping("/logout")
	public String logoutWork(HttpSession session) throws Exception {

		session.invalidate();

		return "redirect:/";
	}

	// Remove
	@GetMapping("/remove")
	public ModelAndView remove(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();

		HttpSession session = request.getSession();
		MemberDto member = (MemberDto) session.getAttribute("member");

		mav.addObject("member", member);
		mav.setViewName("/member/remove");

		return mav;
	}

	@PostMapping("/remove")
	public ModelAndView removeOk(@ModelAttribute("member") MemberDto member, HttpSession session) {

		ModelAndView mav = new ModelAndView();
		MemberDto loginMem = (MemberDto) session.getAttribute("member");

		if (loginMem.getPw().equals(member.getPw())) {
			session.invalidate();
			service.removeMember(member);
			mav.setViewName("redirect:/");
		} else {
			mav.addObject("canRemove", false);
			mav.setViewName("/member/remove");
		}

		return mav;
	}
}
