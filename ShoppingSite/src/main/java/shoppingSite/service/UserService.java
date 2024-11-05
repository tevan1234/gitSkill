package shoppingSite.service;

import java.util.ArrayList;
import java.util.List;


import shoppingSite.model.dto.UserDto;
import shoppingSite.model.entity.User;
import shoppingSite.repository.UserDao;
import shoppingSite.repository.UserDaoImpl;
import shoppingSite.utils.Hash;

//service 是給 Servlet 使用
public class UserService {
	private UserDao userDao = new UserDaoImpl();
	
	//所有使用者
	public List<UserDto> findAll(){
		List<UserDto> userDtos = new ArrayList<>();		
		List<User>users = userDao.findAllUsers();
		//將 User 轉成 UserDto , 並向 userDao 索取List<User> 集合
		for(User user : users) {
			UserDto userDto = new UserDto();
			userDto.setUid(user.getUserId());
			userDto.setRole(user.getUserRole());
			userDto.setPhone(user.getUserPhone());
			userDto.setMail(user.getUserMail());
			userDto.setAccount(user.getAccount());
			userDto.setSalt(user.getSalt());
			userDto.setPasswordHash(user.getPasswordHash());
			userDto.setActive(user.getUserActive());
			userDtos.add(userDto);
		}
		return userDtos;
	}
	
	// 取得指定使用者
		public UserDto getUser(String username) {
			User user = userDao.getUser(username);
			if(user == null) {
				return null;
			}
			// 一個一個將 User 轉成 UserDto
			UserDto userDto = new UserDto();
			userDto.setUid(user.getUserId());			
			userDto.setAccount(user.getAccount());
			userDto.setMail(user.getUserMail());
			userDto.setActive(user.getUserActive());
			userDto.setRole(user.getUserRole());
			return userDto;
		}
	//新增使用者
	public void appendUser(String Account,String password,String mail,String phone) {
		String salt = Hash.getSalt();
		String passwordHash = Hash.getHash(password, salt);
		Boolean action = false;
		
		User user = new User();
		user.setUserPhone(phone);
		user.setUserMail(mail);
		user.setAccount(Account);
		user.setSalt(salt);
		user.setPasswordHash(passwordHash);
		user.setUserActive(action);
		userDao.addUser(user);
	}
	
	public void updateUser(String userId,String role, String active,String phone,String email) {
		
		if(!active.isEmpty()) {
			userDao.updateUserActive(Integer.parseInt(userId), Boolean.parseBoolean(active));
		}
		if(!role.isEmpty()) {
			userDao.updateUserRole(Integer.parseInt(userId), Integer.parseInt(role));
		}
		if(!phone.isEmpty() || !email.isEmpty()) {
			userDao.updateUserInfo(Integer.parseInt(userId), phone, email);
		}
	}
	
	//刪除使用者
		public void deleteUser(String userId) {
			userDao.deleteUser(Integer.parseInt(userId));
		}
}
