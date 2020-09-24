
public class Users {
	private int id;
	private String username;
	private String password;
	private String name;
	private int security_level;
	
	public Users() {
		id = 0;
		username = null;
		password = null;
		name = null;
		security_level = 3;
	}
	public Users(int id, String username, String password, String name, int security_level) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.security_level = security_level;
	}
	public int getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getName(){
		return name;
	}
	public int getSecurity_level() {
		return security_level;
	}
	public int setId(int id) {
		this.id = id;
		return this.id;
	}
	public String setUsername(String username) {
		this.username = username;
		return this.username;
	}
	public String setPassword(String password) {
		this.password = password;
		return this.password;
	}
	public String setName(String name) {
		this.name = name;
		return this.name;
	}
	public int setSecurity_level(int security_level) {
		this.security_level = security_level;
		return this.security_level;
	}
	public String toString() {
		return id+": "+username+": "+password+": "+name+": "+security_level;
	}
	public boolean checkPassword(String pass) {
		boolean check = false;
		if(this.password.equals(pass)) {
			check = true;
			return check;
		}
		else
			return check;
	}
	
}
