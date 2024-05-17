package com.mokcoding.ex03;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mokcoding.ex03.domain.ProductVO;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/product") // API가 제공하는 리소스를 경로 이름으로 설정
@Log4j
public class ProductRESTController {
	
	// 리소스 읽기(GET)
	// ㄴ 제품 name에 맞는 price를 읽기
	@GetMapping("{name}") // url로 name값을 전송. parameter와는 다름
	public ResponseEntity<Integer> readProduct(
			@PathVariable("name")String name){
		// PathVariable : url로 전송된 데이터를 매개변수에 적용
		log.info("readProdict()");
		log.info("name = " + name);
		
		int price = 20000;
		//ResponseEntity : HTTP 응답에 상태 코드, 헤더 및 본문(body)
		// 을 포함하여 전송
		return new ResponseEntity<Integer>(price, HttpStatus.OK);
	}
	
	// 리소스 생성(POST)
	// ㄴ 제품 데이터를 생성 
	@PostMapping
	public ResponseEntity<Integer> createProduct(@RequestBody ProductVO vo) {
		log.info("createProduct()");
		log.info(vo);
		
		int result = 1;
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
	
}
