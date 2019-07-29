package dept.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import dept.dao.DeptDAO;

public class DeptCountController extends AbstractController{
	DeptDAO dao;
	
	public DeptCountController() {}
	public DeptCountController(DeptDAO dao) {
		super();
		this.dao = dao;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("ºÎ¼­°¹¼ö:"+dao.count());
		return new ModelAndView("redirect:../index.do");
	}

}
