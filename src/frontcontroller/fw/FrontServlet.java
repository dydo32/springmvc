package frontcontroller.fw;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="front", urlPatterns={"*.kitri", "*.jsp", "*.html"})
public class FrontServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 요청정보를 분석해서 추출
		System.out.println("요청받기");
		System.out.println("request.getContextPath()=>"+request.getContextPath());
		System.out.println("request.getRequestURI()=>"+request.getRequestURI());
		
		String contextPath = request.getContextPath();
		String requestPath = request.getRequestURI();
		String realPath = requestPath.substring(contextPath.length());
		
		System.out.println("realPath=>"+realPath);
		
		//2. 추출한 요청 path를 이용해서 실제 실행할 클래스를 찾아올 수 있도록 
		//	ActionMapping클래스에게 의뢰(전달)
		ActionMapping handler = new ActionMapping();
		Action action = handler.mapping(realPath);
	
		//3. 전달받은 Action의 run을 호출
		action.run(request,response);
		
		//4. 실행할 뷰의 정보를 Action클래스로부터 전달 받아서 뷰를 만들 수 있도록 의뢰
		//5. 실행할 뷰를 찾은 후에 forward나 redirect되도록 처리
		
		
	}
}
