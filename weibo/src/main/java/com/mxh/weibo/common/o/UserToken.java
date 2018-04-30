package com.mxh.weibo.common.o;

import java.io.Serializable;

/**]
 * <pre>
 * Description
 * 登录，注册
 * Created at:	2017年9月15日 下午2:36:17  
 * </pre>
 */
public class UserToken implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4834820333925467360L;

	private String username;
	
	private String password;
	
	private String rpassword;
	
	private String email;
	
	private String rememberMe;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRpassword() {
		return rpassword;
	}

	public void setRpassword(String rpassword) {
		this.rpassword = rpassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(String rememberMe) {
		this.rememberMe = rememberMe;
	}

	@Override
	public String toString() {
		return "UserToken [username=" + username + ", password=" + password + ", rpassword=" + rpassword + ", email="
				+ email + ", rememberMe=" + rememberMe + "]";
	}
	
}
