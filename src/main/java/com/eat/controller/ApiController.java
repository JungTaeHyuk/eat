package com.eat.controller;


import com.eat.service.ApiService;
import com.eat.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api")
@Slf4j
@RestController
public class ApiController {

	@Autowired
	private ApiService apiService;

	@GetMapping("/member/{id}")
	public ResponseEntity<Member> get(@PathVariable Long id) {
		Member member = apiService.get(id);
		log.debug(member.toString());
		return new ResponseEntity<>(member, HttpStatus.OK);
	}

	@GetMapping("/member/getTest/{id}")
	public Member get2(@PathVariable Long id) {
		return apiService.get(id);
	}

	@GetMapping("/member/list")
	public ResponseEntity<List<Member>> getList() {
		List<Member> list = apiService.getMemberList();
		System.out.println("12123123");
		return new ResponseEntity(list, HttpStatus.OK);
	}

	@GetMapping("/member/nvlist/{gradecode}")
	public ResponseEntity<List<Member>> getNvList(@PathVariable String gradecode) {
		List<Member> list = apiService.getMemberNvList(gradecode);
		return new ResponseEntity(list, HttpStatus.OK);
	}

	@GetMapping("/member/ctlist")
	public ResponseEntity<List<Member>> getCtList(@RequestParam Long id, @RequestParam String gradecode) {
		List<Member> list = apiService.getMemberCtList(id, gradecode);
		return new ResponseEntity(list, HttpStatus.OK);
	}

	@PostMapping("/member/save")
	public ResponseEntity<Member> save(@RequestBody Member member) {
		return new ResponseEntity(apiService.save(member), HttpStatus.OK);
	}

	@PostMapping("/member/modifu")
	public ResponseEntity<Member> modify(@RequestBody Member member) {
		return new ResponseEntity(apiService.modify(member), HttpStatus.OK);
	}

	@PostMapping("/member/saveError")
	public ResponseEntity<Member> saveErro(@RequestBody Member member) {
		return new ResponseEntity(apiService.saveError(member), HttpStatus.OK);
	}

	@PostMapping("/member/delete/{id}")
	public void delete(@PathVariable Long id) {
		Member delMember = apiService.get(id);
		apiService.delete(delMember);
	}
}
