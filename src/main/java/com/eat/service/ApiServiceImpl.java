package com.eat.service;

import com.eat.repository.ApiCriteriaRepository;
import com.eat.repository.ApiRepository;
import com.eat.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
public class ApiServiceImpl implements ApiService {

	@Autowired
	private ApiRepository apiRepository;

	@Autowired
	private ApiCriteriaRepository apiCriteriaRepository;

	@Override
	public Member save(Member member) {
		return apiRepository.save(member);
	}

	@Override
	public Member modify(Member member) {
		Member updMember = this.get(member.getId());
		log.debug(updMember.getName());
		if(updMember != null ) {
			updMember.setEnterdate(member.getEnterdate());
			updMember.setName(member.getName());
			updMember.setGradecode(member.getGradecode());

			apiRepository.saveAndFlush(updMember);
		} else {
			updMember = new Member();
		}
		return updMember;
	}
	/**
	 * 트랜잭션 테스트
	 * @param member
	 * @return
	 */
	@Override
	@Transactional
	public Member saveError(Member member) {
		Member returnMember = apiRepository.save(member);
		if(true) {
			throw new RuntimeException("error");
		}
		return returnMember;
	}

	@Override
	public Member get(Long id) {
		return apiRepository.findMemberById(id);
	}

	@Override
	public List<Member> getMemberList() {
		return apiRepository.findAll();
	}

	@Override
	public List<Member> getMemberNvList(String gradecode) {
		return apiCriteriaRepository.findNativeList(gradecode);
	}

	@Override
	public List<Member> getMemberCtList(Long id, String gradecode) {
		return apiCriteriaRepository.findCriteriaList(id, gradecode);
	}

	@Override
	public void delete(Member member) {
		apiRepository.delete(member);
	}
}
