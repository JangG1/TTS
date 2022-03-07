package com.tts.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.tts.vo.ttsVO;

@Mapper
public interface ttsMapper {
	@Select("SELECT * from tts")
	List<ttsVO> findAll();


}
