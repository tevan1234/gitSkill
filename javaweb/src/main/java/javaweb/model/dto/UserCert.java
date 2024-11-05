package javaweb.model.dto;

//import java.util.Date;

//使用者憑證
//登入成功後會得到的資料(只有getter)
public class UserCert {
	private Integer userId;
	private String username;
	private String role;
	//private Date loginTime;

	public UserCert(Integer userId, String username, String role) {
		super();
		this.userId = userId;
		this.username = username;
		this.role = role;
	}

	public Integer getUserId() {
		return userId;
	}

	public String getUsername() {
		return username;
	}

	public String getRole() {
		return role;
	}

	@Override
	public String toString() {
		return "UserCert [userId=" + userId + ", username=" + username + ", role=" + role + "]";
	}
	
	/*public Date getLoginTime() {
		return loginTime;
	}*/
	
}
