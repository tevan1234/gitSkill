package shoppingSite.repository;

import java.util.List;

import shoppingSite.model.entity.User;



//DAO(Data Access Object)
public interface UserDao {
	
	//查詢所有使用者
	List<User> findAllUsers();
	
	//單筆:根據username查詢該筆使用者
	User getUser(String username);
	
	//新增使用者
	void addUser(User user);

	// 修改 active 狀態
	void updateUserActive(Integer userId, Boolean active);
	
	// 修改 role 狀態
	void updateUserRole(Integer userId, Integer role);
		
	//修改密碼
	void updatePasswordHash(Integer userId,String newPasswordHash);
	
	//修改使用者資料
	void updateUserInfo(Integer userId,String phone,String email);
			
	// 刪除: 根據 userId 來刪除
	void deleteUser(Integer userId);
	
	
}
