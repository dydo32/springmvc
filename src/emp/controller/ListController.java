package emp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import emp.dao.MyEmpDAO;
import emp.dto.EmpDTO;

public class ListController extends AbstractController{
	MyEmpDAO dao;
	
	public ListController() {}
	public ListController(MyEmpDAO dao) {
		super();
		this.dao = dao;
	}
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView mav = new ModelAndView();
		List<EmpDTO> emplist = null;
		String addr = req.getParameter("search");
		System.out.println("추출한 파라미터=>"+addr);
		if(addr==null){
			emplist = dao.getMemberList();
		}else{
			emplist = dao.findByAddr(addr);
		}
		mav.addObject("userlist", emplist);
		mav.setViewName("emp/list");
		return mav;
	
	}
}
