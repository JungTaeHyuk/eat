package com.eat.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="MEMBER")
public class Member {

	@Id
	@Column(name="ID")
	private Long id;

	@Column(name="NAME")
	private String name;

	@Column(name="ENTERDATE")
	private String enterdate;

	@Column(name="GRADECODE")
	private String gradecode;

	private String gradename;

}
