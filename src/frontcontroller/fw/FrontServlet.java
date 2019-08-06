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
		//1. ��û������ �м��ؼ� ����
		System.out.println("��û�ޱ�");
		System.out.println("request.getContextPath()=>"+request.getContextPath());
		System.out.println("request.getRequestURI()=>"+request.getRequestURI());
		
		String contextPath = request.getContextPath();
		String requestPath = request.getRequestURI();
		String realPath = requestPath.substring(contextPath.length());
		
		System.out.println("realPath=>"+realPath);
		
		//2. ������ ��û path�� �̿��ؼ� ���� ������ Ŭ������ ã�ƿ� �� �ֵ��� 
		//	ActionMappingŬ�������� �Ƿ�(����)
		ActionMapping handler = new ActionMapping();
		Action action = handler.mapping(realPath);
	
		//3. ���޹��� Action�� run�� ȣ��
		action.run(request,response);
		
		//4. ������ ���� ������ ActionŬ�����κ��� ���� �޾Ƽ� �並 ���� �� �ֵ��� �Ƿ�
		//5. ������ �並 ã�� �Ŀ� forward�� redirect�ǵ��� ó��
		
		
	}
}
