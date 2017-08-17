package com.gewara.web.support;

import java.io.Serializable;

import lombok.Data;
import org.springframework.security.core.Authentication;
@Data
public class CachedAuthentication implements Serializable{
	private static final long serialVersionUID = -3059550493892424507L;
	private Long timeout;
	private Authentication authentication;
	private String ip;
}
