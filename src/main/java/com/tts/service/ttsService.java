package com.tts.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tts.mapper.ttsMapper;
import com.tts.vo.ttsVO;

@Service
public class ttsService {
	private ttsMapper ttsMapper;

	public ttsService(ttsMapper ttsMapper) {
		this.ttsMapper = ttsMapper;
	}


	public List<ttsVO> getAll(){
		return ttsMapper.findAll();
	}
}
		


