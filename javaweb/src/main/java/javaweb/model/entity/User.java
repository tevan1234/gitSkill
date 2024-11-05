package javaweb.model.entity;

import lombok.Data;

//代表users 資料表紀錄
/*
CREATE TABLE `users` (
  `user_id` int NOT NULL AUTO_INCREMENT COMMENT '使用者id',
  `username` varchar(50) NOT NULL COMMENT '使用者名稱',
  `password_hash` varchar(255) NOT NULL COMMENT '使用者HASH密碼',
  `salt` varchar(255) NOT NULL COMMENT '隨機鹽',
  `email` varchar(255) DEFAULT NULL COMMENT '電子郵件',
  `active` tinyint(1) DEFAULT '0' COMMENT '帳號啟動',
  `role` varchar(20) NOT NULL DEFAULT 'ROLE_USER' COMMENT '角色權限',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
 */
@Data
public class User {
	private Integer userId;
	private String username;
	private String password_hash;
	private String salt;
	private String email;
	private Boolean active;
	private String role;
	
	
}
