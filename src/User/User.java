package User;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class User {
	private Integer id;
	private String account;
	private String password;
	private String permission;

	protected Scanner scanner = new Scanner(System.in);
	
	public User(String id, String account, String password, String permission) {
		this.id = Integer.valueOf(id);
		this.account = account;
		this.password = password;
		this.permission = permission;
	}

	public User(User u) {
		this.id = u.id;
		this.account = u.account;
		this.password = u.password;
		this.permission = u.permission;
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
