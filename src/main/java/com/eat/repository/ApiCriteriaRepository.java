package com.eat.repository;


import com.eat.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class ApiCriteriaRepository {

	@PersistenceContext
	EntityManager em;

	/**
	 * Criteria 조회 쿼리
	 * @param id
	 * @param gradecode
	 * @return List<Member>
	 */
	public List<Member> findCriteriaList(Long id, String gradecode) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Member> q = cb.createQuery(Member.class);
		Root<Member> c = q.from(Member.class);
		Predicate cond = cb.equal(c.get("id"), id);
		Predicate cond2 = cb.equal(c.get("gradecode"), gradecode);
		q.select(c).where(cond, cond2);

		return em.createQuery(q).getResultList();
	}

	/**
	 * Native 조회 쿼리
	 * Mysql 기본 쿼리 사용 가능
	 * 이걸 쓸바에 마이바티스가 나을꺼....
	 * @param gradecode
	 * @return List<Member>
	 */
	public List<Member> findNativeList(String gradecode) {
		String sql = " SELECT ID, NAME, ENTERDATE, m.GRADECODE, g.GRADENAME  FROM MEMBER m left join GRADE g on ( m.gradecode = g.gradecode) WHERE m.GRADECODE = ? ";
		Query q = em.createNativeQuery(sql, Member.class);
		q.setParameter(1, gradecode);

		return q.getResultList();
	}
}
