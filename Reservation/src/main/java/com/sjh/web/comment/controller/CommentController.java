package com.sjh.web.comment.controller;

import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sjh.web.comment.dto.CommentDto;
import com.sjh.web.comment.service.ICommentService;

@Controller
@RequestMapping("/comment")
public class CommentController {

	@Inject
	ICommentService service;

	@ModelAttribute("cp")
	public String getContextPath(HttpServletRequest request) {
		return request.getContextPath();
	}

	// 작성 페이지
	@GetMapping("/{reservationId}")
	public String write(@PathVariable("reservationId") int reservationId, Model model) {

		model.addAttribute("comment", new CommentDto());
		model.addAttribute("reservationId", reservationId);

		return "/comment/comment";
	}

	// 작성 처리
	@PostMapping("/")
	public String writeOk(@ModelAttribute("comment") CommentDto comment, HttpSession session) {
		CommentDto c = service.insertComment(comment);

		return "redirect:/product/" + c.getProductId();

	}

	@ResponseBody
	@PostMapping("/list/{productId}")
	public Map<String, Object> list(@PathVariable("productId") int productId, Model model) {

		CommentDto c = new CommentDto();
		c.setProductId(productId);
		Map<String, Object> map = service.listUpComment(c);

		return map;
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public ResponseEntity<String> modify(@RequestBody CommentDto comment) {
		ResponseEntity<String> entity = null;

		try {
			service.updateComment(comment);
			entity = new ResponseEntity<String>("modify Success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public ResponseEntity<String> remove(@RequestBody CommentDto comment) {
		ResponseEntity<String> entity = null;

		try {
			service.deleteComment(comment);
			entity = new ResponseEntity<String>("remove Success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;
	}
}
