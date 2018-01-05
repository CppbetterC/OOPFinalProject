package User;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class User {
	private static Integer count = 0;
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
		count++;
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

	public String getAccount() {
		return account;
	}

	public String getPassword() {
		return password;
	}

	public boolean setPassword(String password) {
		this.password = password;
		return true;
	}

	public String getPermission() {
		return permission;
	}
}
