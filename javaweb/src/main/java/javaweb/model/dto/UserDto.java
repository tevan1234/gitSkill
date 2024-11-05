package javaweb.model.dto;

import lombok.Data;

// UserDto 對應於 User entity
//Dto 的屬性名稱建議可以與所對應 Entity 物件不同
@Data
public class UserDto {
	private Integer userId;
	private String username;
	private String email;
	private Boolean active;
	private String role;
}
