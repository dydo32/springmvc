package emp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import emp.dao.MyEmpDAO;

public class CountController extends AbstractController{
	MyEmpDAO dao;
	
	public CountController() {}
	public CountController(MyEmpDAO dao) {
		super();
		this.dao = dao;
	}
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("전체 인원수:"+dao.count());
		return new ModelAndView("redirect:index.do");
	}

}
