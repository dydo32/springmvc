package main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//�⺻ web���� ������ �����ߴ� �ڵ带 Controller�� ���� ����
//- DispatcherServlet�� ȣ��
//- �������� �ߴ� �۾��� Controller�� ���������� �Ϻ� API�� ����Ǿ���. - �������� ����ϹǷ�

public class TestController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		//������ ��� ������ �����Ϳ� ���� ������ ���� �ִ� ��ü
		ModelAndView mav = new ModelAndView();
		
		//���������� ����
		//->request.setAttribute("msg","���������� ���޵Ǵ� ������");
		mav.addObject("msg","�������������޵Ǵµ�����");
		
		//forward�� view�� ���� ������ ���� - DispatcherServlet���� �⺻ forwardó��
		//mav.setViewName("/WEB-INF/main/result.jsp");
		mav.setViewName("main/result");
		
		return mav;
	}


}
