package com.cpoletti.helpdesk.api.security.jwt;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class JwtUser implements UserDetails {

	private static final long serialVersionUID = 7546333061191547161L;
	
	private String id;
	private String username;
	private String password;
	private final Collection<? extends GrantedAuthority> authorities;
	
	public JwtUser(String id, String username, String password, Collection<? extends GrantedAuthority> authorities)
	{
		this.id = id;
		this.username = username;
		this.password = password;
		this.authorities = authorities;
	}
	
	@JsonIgnore
	public String getId()
	{
		return this.id;
	}
	
	@Override
	public String getUsername() {
		return this.username;
	}
	
	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	@JsonIgnore
	@Override
	public String getPassword() {
		return password;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}	
}
