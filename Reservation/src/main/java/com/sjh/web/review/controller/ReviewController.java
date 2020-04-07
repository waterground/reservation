package com.sjh.web.review.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sjh.web.file.dto.FileDto;
import com.sjh.web.review.dto.ReviewDto;
import com.sjh.web.review.service.IReviewService;

@Controller
@RequestMapping("/review")
public class ReviewController {

	@Inject
	IReviewService service;
	
	final static String PATH = "c:/img/review/";

	@ModelAttribute("cp")
	public String getContextPath(HttpServletRequest request) {
		return request.getContextPath();
	}

	// 작성 페이지
	@GetMapping("/{reservationId}")
	public String write(@PathVariable("reservationId") int reservationId, Model model) {
		
		model.addAttribute("review", new ReviewDto());
		model.addAttribute("reservationId", reservationId);

		return "/review/review";
	}

	// 작성 처리
	@PostMapping("/")
	public String writeOk(@ModelAttribute("review") ReviewDto review, MultipartHttpServletRequest request) {
		
		List<MultipartFile> fileList = request.getFiles("file");
		String path = "c:/img/review";		
		List<FileDto> imgList = new ArrayList<FileDto>();
		
		File file = new File(path);
		if(file.exists() == false){ file.mkdirs(); }
		
		for (MultipartFile mf : fileList) { 
			String saveFileName = review.getReservationId() + "_rw_" + mf.getOriginalFilename(); 
			FileDto f = new FileDto();
			f.setName(saveFileName);
			imgList.add(f);
			try { // 파일생성
				mf.transferTo(new File(path, saveFileName)); 
			} catch (Exception e) { 
				e.printStackTrace(); 
			}
		}		
		
		review.setImgList(imgList);
		
		ReviewDto c = service.insertReview(review);

		return "redirect:/product/" + c.getProductId();
	}

	@ResponseBody
	@PostMapping("/list/{productId}")
	public Map<String, Object> list(@PathVariable("productId") int productId, Model model, HttpServletRequest request, RedirectAttributes rttr, HttpServletResponse response) throws Exception {

		ReviewDto c = new ReviewDto();
		c.setProductId(productId);
		Map<String, Object> map = service.listUpReview(c);

		return map;
	}

	@PostMapping("/modify")
	public ResponseEntity<String> modify(@RequestBody ReviewDto review) {
		ResponseEntity<String> entity = null;

		try {
			service.updateReview(review);
			entity = new ResponseEntity<String>("modify Success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@PostMapping("/remove")
	public ResponseEntity<String> remove(@RequestBody ReviewDto review) {
		ResponseEntity<String> entity = null;

		try {
			service.deleteReview(review);
			entity = new ResponseEntity<String>("remove Success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;
	}
}
