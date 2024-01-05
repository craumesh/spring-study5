package com.itwillbs.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itwillbs.domain.MemberVO;

// @RestController : 해당 클래스를 REST방식 데이터 처리를 수행하는 클래스 선언
@RestController
@RequestMapping(value = "/sample")
public class SampleRestController {	
	private static final Logger logger = LoggerFactory.getLogger(SampleRestController.class);
	
	@RequestMapping(value = "/doA", method = RequestMethod.GET)
	public String doA() {
		logger.debug("doA() 호출");
		return "ITWILL";
	}
	
	@RequestMapping(value = "/doB", method = RequestMethod.GET)
	public Integer doB() {
		logger.debug("doB() 호출");
		
		// String을 제외한 기본형 타입 리턴은 참조형타입으로 변경하는 것을 권장
		
		// 정수데이터를 의미(JSON)
		return 100000000;
	}
	
	@RequestMapping(value = "/doC", method = RequestMethod.GET)
	public MemberVO doC(MemberVO vo) {
		logger.debug("doC() 호출");
		
		vo.setUserid("id");
		vo.setUserpw("1234");
		vo.setUsername("곤히자");
		vo.setUseremail("adomit@gmail.com");
		
		// 객체를 JSON타입으로 변환(자바 직렬화: 자바 시스템 내부의 객체를 외부에서 사용되는 데이터 형태로 변환)
		
		// 정수데이터를 의미(JSON)
		return vo;
	}
	
	@RequestMapping(value = "/doD", method = RequestMethod.GET)
	public List<MemberVO> doD() {
		logger.debug("doD() 호출");
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		for(int i = 1; i <= 10; i++) {
			MemberVO vo = new MemberVO();
			vo.setUserid("id"+i);
			vo.setUserpw("1234");
			vo.setUsername("곤히자"+i);
			vo.setUseremail("adomit"+i+"@gmail.com");
			list.add(vo);
		}		
		return list;
	}
	
	@RequestMapping(value = "/doE", method = RequestMethod.GET)
	public Map<Integer,MemberVO> doE() {
		logger.debug("doE() 호출");
		
		Map<Integer,MemberVO> map = new HashMap<Integer,MemberVO>();
		
		for(int i = 0; i < 10; i++) {
			MemberVO vo = new MemberVO();
			vo.setUserid("id"+i);
			vo.setUserpw("1234");
			vo.setUsername("곤히자"+i);
			vo.setUseremail("adomit"+i+"@gmail.com");
			map.put(i, vo);
		}		
		return map;
	}
	
	// http://localhost:8088/sample/doF/100
	@RequestMapping(value = "/doF/{num}", method = RequestMethod.GET)
	public String doF(@PathVariable("num") Integer num) {
		logger.debug("doF() 호출");
		
		return "결과 : "+num;
	}
	
	@RequestMapping(value = "/info", method = RequestMethod.POST)
	public void info(@RequestBody MemberVO vo) {
		// @RequestBody : 브라우저에 전달되는 JSON 데이터를 특정 객체로 자동 변환
		//				데이터가 반드시 HTTP메서드에 포함되어있어야함(GET방식 사용불가)
		logger.debug("info() 호출");
		logger.debug(""+vo);
	}
	
	// http://localhost:8088/sample/doG
	@RequestMapping(value = "/doG", method = RequestMethod.GET)
	public ResponseEntity<Void> doG() {
		logger.debug("doG() 호출");
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}
	
	// http://localhost:8088/sample/doH
	@RequestMapping(value = "/doH", method = RequestMethod.GET)
	public ResponseEntity<String> doH() {
		logger.debug("doH() 호출");
		return new ResponseEntity<String>("ITWILL BUSAN",HttpStatus.NOT_FOUND);
	}
}
