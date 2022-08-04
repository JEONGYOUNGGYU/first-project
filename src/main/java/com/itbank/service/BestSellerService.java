package com.itbank.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.bestseller.BestSellerDAO;
import com.itbank.bestseller.BestSellerDTO;

@Service
public class BestSellerService {

	@Autowired private BestSellerDAO dao;
	private String uploadPath = "D:\\test11A_upload";
	
	public BestSellerService() {
		File dir = new File(uploadPath);
		if(dir.exists() == false) {
			dir.mkdirs();
		}
	}
	

	public List<BestSellerDTO> selectAll() {
		
		return dao.selectAll();
	}
	
	public int insert(BestSellerDTO dto) throws IllegalStateException, IOException {
		File dest = new File(uploadPath, dto.getFile().getOriginalFilename());
		System.out.println(dest);
		dto.getFile().transferTo(dest);
		dto.setImg(dto.getFile().getOriginalFilename());
		System.out.println(dest);
		System.out.println(dto.getFile().getOriginalFilename());
		System.out.println(uploadPath);
		
		return dao.insert(dto);
	}


	public BestSellerDTO getDTO(int idx) {
		return dao.getDTO(idx);
	}


	public int delete(int idx) {
		return dao.delete(idx);
	}
}
