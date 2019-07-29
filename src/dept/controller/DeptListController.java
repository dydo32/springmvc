package dept.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import dept.dao.DeptDAO;
import dept.dto.DeptDTO;

public class DeptListController extends AbstractController{
	DeptDAO dao;
	
	public DeptListController() {}
	public DeptListController(DeptDAO dao) {
		super();
		this.dao = dao;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView mav = new ModelAndView();
		List<DeptDTO> deptlist = dao.getDeptList();
		mav.addObject("deptlist", deptlist);
		mav.setViewName("dept/deptlist");
		return mav;
	}

}
