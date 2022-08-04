package com.itbank.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itbank.bestseller.BestSellerDTO;
import com.itbank.service.BestSellerService;

@RestController

public class HomeController {
	
	@Autowired private BestSellerService bsService;
	
	@GetMapping("/bestseller")
	private List<BestSellerDTO> selectList() {
		List<BestSellerDTO> list = bsService.selectAll();
		return list;
	}
	
	@PostMapping("/bestseller")
	public int insert(BestSellerDTO dto) throws IllegalStateException, IOException {
		return bsService.insert(dto);
	}
	
	@GetMapping("/bestseller/{idx}")
	public BestSellerDTO getDTO(@PathVariable int idx) {
		return bsService.getDTO(idx);
	}
	
	@DeleteMapping("/bestseller/{idx}")
	private int delete(@PathVariable int idx) {
		return bsService.delete(idx);
	}
}
