package shoppingSite.model.entity;

import lombok.Data;

/*建立User資料庫
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT COMMENT '使用者id',
  `user_role` int DEFAULT '3' COMMENT '使用者權限',
  `user_phone` varchar(20) DEFAULT NULL COMMENT '使用者手機',
  `user_mail` varchar(50) DEFAULT NULL COMMENT '使用者email',
  `user_account` varchar(50) DEFAULT NULL COMMENT '使用者帳號',
  `user_salt` varchar(255) DEFAULT NULL COMMENT '使用者隨機鹽',
  `user_passwordHash` varchar(255) DEFAULT NULL COMMENT '使用者Hash密碼',
  `user_active` tinyint(1) DEFAULT '0' COMMENT '帳號啟動',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
 */

@Data
public class User {
	private Integer userId;
	private Integer userRole;
	private String userPhone;
	private String userMail;
	private String account;
	private String salt;
	private String passwordHash;
	private Boolean userActive;
}
