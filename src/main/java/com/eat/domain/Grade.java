package com.eat.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="GRADE")
public class Grade {
	@Id
	@Column(name="gradecode")
	private String gradecode;

	@Column(name="gradename")
	private String gradename;

}
