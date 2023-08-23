package com.coding.cho.secutiry;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.coding.cho.domain.entity.MemberEntity;
import com.coding.cho.domain.entity.MemberEntityRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
//@Component
@Service
public class MyUserDetailsService implements UserDetailsService {

	//존재하면 정보 가져올 객체
	private final MemberEntityRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		MemberEntity entity=repository.findByEmail(email).orElseThrow();
		
		Collection<? extends GrantedAuthority> authorities=entity.getRoleSet().stream()
				.map(role->new SimpleGrantedAuthority("ROLE_"+role))
				.collect(Collectors.toSet());
		
		System.out.println("롤테이블일겅옴");
		return new User(email, entity.getPass(), authorities);
	
		
		
	}

}
