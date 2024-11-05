package javaweb.servlet;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
/*
 * 執行網址:http://locoalhost:8080/javaweb/bmi?h=170&w=60
 */
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/bmi")
public class BMIServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//取得問號後參數
		String h = req.getParameter("h");
		String w = req.getParameter("w");
		
		if(h == null || w == null) {
			req.setAttribute("message","請輸入身高與體重參數");
			req.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(req, resp);
			return;
		}
		
		double height = Double.parseDouble(h);
		double weight = Double.parseDouble(w);
		double bmi = weight/(Math.pow(height/100, 2));
		
		req.setAttribute("height", height);
		req.setAttribute("weight", weight);
		req.setAttribute("bmi", bmi);
		
		req.getRequestDispatcher("/WEB-INF/view/bmi.jsp").forward(req, resp);
	}

}
