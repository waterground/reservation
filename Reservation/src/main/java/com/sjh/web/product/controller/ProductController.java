package com.sjh.web.product.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sjh.web.product.dto.ProductDto;
import com.sjh.web.product.service.IProductService;
import com.sjh.web.promotion.dto.PromotionDto;

@Controller
public class ProductController {

	@Inject
	IProductService service;

	@ModelAttribute("cp")
	public String getContextPath(HttpServletRequest request) {
		return request.getContextPath();
	}

	@RequestMapping("/main")
	public String main(Model model) {

		List<PromotionDto> list = null;

		list = service.listUpPromotion();
		model.addAttribute("promotion", list);

		return "main";
	}

	@ResponseBody
	@RequestMapping("/list")
	public List<ProductDto> categoryList(@RequestParam("categoryName") String categoryName){//, @RequestParam("page") int page) {
		
		return service.listUpByCategory(categoryName);
	}
	
	@RequestMapping("/product/info")
	public String productInfo(@RequestParam("id") int id, Model model) {
		
		model.addAttribute("product", service.selectProductInfo(id));
		
		return "/product/info";
	}

}
