package main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//기본 web에서 서블릿에 정의했던 코드를 Controller를 만들어서 정의
//- DispatcherServlet이 호출
//- 서블릿에서 했던 작업을 Controller에 정의하지만 일부 API는 변경되었다. - 스프링꺼 써야하므로

public class TestController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		//응답할 뷰와 공유할 데이터에 대한 정보를 갖고 있는 객체
		ModelAndView mav = new ModelAndView();
		
		//공유데이터 저장
		//->request.setAttribute("msg","스프링에서 전달되는 데이터");
		mav.addObject("msg","스프링에서전달되는데이터");
		
		//forward할 view에 대한 정보를 정의 - DispatcherServlet에서 기본 forward처리
		//mav.setViewName("/WEB-INF/main/result.jsp");
		mav.setViewName("main/result");
		
		return mav;
	}


}
