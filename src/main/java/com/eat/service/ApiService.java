package com.eat.service;

import com.eat.domain.Member;

import java.util.List;

public interface ApiService {
	Member save(Member member);

	Member modify(Member member);

	Member get(Long id);

	List<Member> getMemberList();

	List<Member> getMemberNvList(String gradecode);

	List<Member> getMemberCtList(Long id, String gradecode);

	void delete(Member member);

	Member saveError(Member member);
}
