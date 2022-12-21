package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.BoardVO;

@SpringBootApplication
@RestController
public class ABasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(ABasicApplication.class, args);
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "안녕 부트 !!";
	}
	
	@GetMapping("/hello2")
	public BoardVO hello2() {
		BoardVO vo = new BoardVO();
		vo.setSeq(1);
		vo.setTitle("(╯‵□′)╯︵┻━┻");
		vo.setWriter("(ヘ･_･)ヘ┳━┳");
		
		return vo;
	}
	
}
