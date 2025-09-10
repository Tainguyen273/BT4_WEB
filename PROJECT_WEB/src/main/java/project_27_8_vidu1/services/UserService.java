package project_27_8_vidu1.services;

import project_27_8_vidu1.models.User;

public interface UserService {
	User login(String username, String password); // Xử lý logic đăng nhập [cite: 242]
	User get(String username);
	void insert(User user);
	boolean register(String email, String password, String username, String 
	fullname, String phone);
	boolean checkExistEmail(String email);
	boolean checkExistUsername(String username);
	boolean checkExistPhone(String phone);
}
