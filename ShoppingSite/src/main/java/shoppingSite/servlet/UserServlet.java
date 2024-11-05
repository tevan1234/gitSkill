package shoppingSite.servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import shoppingSite.model.dto.UserDto;
import shoppingSite.service.UserService;

/*
 * 查詢全部: GET /user
 * 查詢單筆: GET /user/get?username=admin
 * 新增單筆: GET /user/add
 * 修改單筆: GET /user/update?userId=1
 * 刪除單筆: GET /user/delete?userId=1
 */

@WebServlet(urlPatterns = {"/user/*", "/users"})
public class UserServlet extends HttpServlet{
	private UserService userService = new UserService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		//resp.getWriter().print(pathInfo);
		if (pathInfo == null || pathInfo.equals("/*")) {
			List<UserDto> userDtos = userService.findAll();
			//resp.getWriter().print(userDtos);
			req.setAttribute("userDtos", userDtos);
			req.getRequestDispatcher("/WEB-INF/view/user.jsp").forward(req, resp);
			return;
		}else if(pathInfo.equals("/get")) { 
			String username = req.getParameter("username");
			UserDto userDto = userService.getUser(username);
			req.setAttribute("userDto", userDto);			
			req.getRequestDispatcher("/WEB-INF/view/updateUser.jsp").forward(req, resp);
			return;
		} else if (pathInfo.equals("/delete")) {
			String userid = req.getParameter("userId");			
			userService.deleteUser(userid);
			resp.sendRedirect("/ShoppingSite/user");
			return;
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		
		String userId = req.getParameter("userId");			
		String role = req.getParameter("role");
		String active = req.getParameter("active");
		
		switch (pathInfo) {
			case "/add": 
				userService.appendUser(username, password, email, phone);				
				break;
			case "/update":
				userService.updateUser(userId, role, active, phone, email);
				//System.out.println("userid:"+userId);
				break;
		}
		resp.sendRedirect("/ShoppingSite/user");
	}
	
	
}
