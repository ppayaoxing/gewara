package com.gewara.model.acl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

public class LogonMember implements UserDetails{
	private static final long serialVersionUID = 6078080839080249253L;
	public static final String USER_TYPE_SSO = "sso";			//鍗曠偣鐧诲綍
	public static final String USER_TYPE_USER = "user";			//鍗曠偣鍚庡彴
	public static final String USER_TYPE_MEMBER = "member";		//鍓嶅彴鐢ㄦ埛
	public static final String USER_TYPE_PARTNER = "partner";	//鍚堜綔鍟嗗

	private Long memberid;
	private String nickname;
	private String rejected;
	private List<GrantedAuthority> authList = AuthorityUtils.createAuthorityList("member") ;
	@Override
	public final boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public final boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public final boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public List<GrantedAuthority> getAuthorities(){
		return new ArrayList<GrantedAuthority>(authList);
	}
	public Long getId(){
		return memberid;
	}
	public String getUsertype(){
		return "member";
	}
	@Override
	public String getPassword() {
		//瀵嗙爜鐩存帴灞忚斀
		return null;
	}
	@Override
	public String getUsername() {
		return nickname;
	}
	@Override
	public boolean isEnabled() {
		return "N".equals(rejected);
	}
}
