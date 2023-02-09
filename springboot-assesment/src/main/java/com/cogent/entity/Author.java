package com.cogent.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int authorId;
	private String authorName;
	private String authorAddress;
	private String authorPhone;
}
