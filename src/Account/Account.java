package Account;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Account {
	private Integer id;
	private String account;
	private String password;
	private String permission;
	
	public Account(String id, String account, String password, String permission) {
		this.id = Integer.valueOf(id);
		this.account = account;
		this.password = password;
		this.permission = permission;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPermission() {
		return permission;
	}
}
