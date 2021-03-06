package control;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import dto.Category;
import dto.Product;

@WebServlet("/product.do")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = -5727566417040289456L;

	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.setCharacterEncoding("utf-8");

		List<Product> list = new ArrayList<>();
		
		Category cate = new Category("it", "IT전문서적");
		
		Product p1 = new Product("1", "일", cate, 1000);
		list.add(p1);
		Product p2 = new Product("2", "이", cate, 2000);
		list.add(p2);
		
		Category cate1 = new Category("en", "영어전문서적");
		Product p3 = new Product("3","삼", cate1, 3000);
		list.add(p3);
		
		req.setAttribute("PROD", list);
		String path = "/productlistresult.jsp";
		RequestDispatcher rd = req.getRequestDispatcher(path);
		rd.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");

		String searchItem = req.getParameter("selectItem");
		String searchValue = req.getParameter("selectValue");
		System.out.println(searchItem);
		System.out.println(searchValue);
		
		List<Product> list = new ArrayList<>();

		
Category cate = new Category("sp", "스포츠전문서적");
		
		Product p1 = new Product("9", "구", cate, 1000);
		list.add(p1);
		
		req.setAttribute("PROD", list);
		String path = "/productlistresult.jsp";
		RequestDispatcher rd = req.getRequestDispatcher(path);
		rd.forward(req, resp);
		
	}
	
	
}
