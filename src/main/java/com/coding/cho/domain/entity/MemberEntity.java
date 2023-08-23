package com.coding.cho.domain.entity;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@DynamicUpdate//수정시 수정항목만 쿼리에 적용
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "member")
@Getter
@Entity
public class MemberEntity extends BaseDateEntity{
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long no;
	
	@Column(columnDefinition = "varchar(255) not null unique collate utf8mb4_bin")
	private String email;
	
	@Column(nullable = false)
	private String pass;
	@Column(nullable = false)
	private String name;
	private boolean isSocial;
	

	@Enumerated(EnumType.STRING)//지정해주지 않으면 숫자로 저장됨
	@CollectionTable(name = "role", joinColumns = @JoinColumn(name="mno"))
	@ElementCollection(fetch = FetchType.EAGER)//1:N
	@Builder.Default
	@Column(name = "roleName", nullable = false)
	private Set<MyRole> roleSet=new HashSet<>();
	
	public MemberEntity addRole(MyRole role) {
		roleSet.add(role);
		return this;
	}

}
