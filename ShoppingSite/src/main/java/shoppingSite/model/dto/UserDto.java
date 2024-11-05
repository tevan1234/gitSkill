package shoppingSite.model.dto;

import lombok.Data;

@Data
public class UserDto {
	private Integer Uid;
	private Integer Role;
	private String Phone;
	private String Mail;
	private String Account;
	private String Salt;
	private String PasswordHash;
	private boolean Active;
}
