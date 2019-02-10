package com.eat.repository;

import com.eat.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Name Method 방법
 */
@Repository
public interface ApiRepository extends JpaRepository<Member, String> {
	Member findMemberById(Long id);
	List<Member> findAll();
}
