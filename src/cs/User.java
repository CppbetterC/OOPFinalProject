package cs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class User {
	
	protected Map<Integer, String> account = new HashMap<>();
	protected Map<Integer, String> password = new HashMap<>();
	protected Map<Integer, String> permission = new HashMap<>();
	private Map<String, String> keyOfAccount = new HashMap<>();
	private Map<String, String> keyOfPermission = new HashMap<>();
	
	//protected String[][] password;
	
	public User() {
		FileReader fr;
		int id = 0;
		try {
			fr = new FileReader("src/cs/User.txt");
			BufferedReader br = new BufferedReader(fr);
			try {
				while(br.ready()) {
					String tempLine = br.readLine();
					String[] tmp = tempLine.split(";");
					account.put(id, tmp[1]);
					password.put(id, tmp[2]);
					permission.put(id, tmp[3]);
					keyOfAccount.put(tmp[1], tmp[2]);
					keyOfPermission.put(tmp[1], tmp[3]);
					id++;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public String accountVerify(String account, String password){
		for(String key: keyOfAccount.keySet()) {
			
			if (key.equals(account) && 
					keyOfAccount.get(key).equals(password)) {
//				return the permission of the account(admin01, scorer, examinee)
				return this.keyOfPermission.get(key);
			}
		}
		return "error";
	}
	
}
