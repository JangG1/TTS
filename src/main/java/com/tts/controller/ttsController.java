package com.tts.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tts.service.ttsService;
import com.tts.vo.ttsVO;

@RestController
@RequestMapping(value = "api/tts/*")
public class ttsController {
	@Autowired
	private ttsService ttsService;
	
	@GetMapping("/axios")
	public List<ttsVO> getAll() {
		return ttsService.getAll();
	}
	
	
//	@PostMapping("/test")
//	public ArrayList<HashMap<String, Object>> test(@RequestBody HashMap<String, Object> requestJsonHashMap) throws Exception{
//
//		//response Data
//		ArrayList<HashMap<String, Object>> rtnArray = new ArrayList<HashMap<String, Object>>();
//		HashMap<String, Object> rtnMap = new HashMap<String, Object>();
//
//		rtnMap.put("text", requestJsonHashMap.get("data"));    
//		rtnArray.add(rtnMap);
//		System.out.println(rtnMap);
//		return rtnArray; 
//	}
	
	
	/*@GetMapping({"","/"})
	public String index() {
		return "index";
	}
	
	@GetMapping("/test")
	public String test() {
		return "test";
	}
	
	@GetMapping("/test2")
	public String test2() {
		return "test2";
	}*/

}
