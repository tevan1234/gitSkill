package shoppingSite.servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import shoppingSite.model.dto.ProductDto;
import shoppingSite.service.ProductService;

@WebServlet(urlPatterns = {"/product/*","/products"})
public class ProductServlet extends HttpServlet{
	private ProductService productService = new ProductService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathinfo = req.getPathInfo();
		
		if(pathinfo == null || pathinfo.equals("/*")) {
			List<ProductDto> productDtos = productService.findAll();
			req.setAttribute("productDtos",productDtos );
			req.getRequestDispatcher("/WEB-INF/view/product.jsp").forward(req, resp);
			return;
		}
		
	}

	
	
}
