package com.itbank.bestseller;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface BestSellerDAO {

	@Select("select * from bestseller order by idx")
	List<BestSellerDTO> selectAll();

	@Insert("insert into bestseller (img, bookname, writer, pdate, price) values ( #{img}, #{bookname}, #{writer}, #{pdate}, #{price} )")
	int insert(BestSellerDTO dto);

	@Select("select * from bestseller where idx = #{idx}")
	BestSellerDTO getDTO(int idx);

	@Delete("delete from bestseller where idx = #{idx}")
	int delete(int idx);

	
}
