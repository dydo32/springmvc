package frontcontroller.fw;

import frontcontroller.emp.EmpInsert;
import frontcontroller.emp.EmpSelect;

/*
 * FrontServlet이 넘겨준 요청정보를 가지고 실제 실행할 클래스를 리턴해주는 역할
 * 미리 요청path에 따라 실행할 클래스의 정보를 spring처럼 xml로 등록하거나
 * properties파일에 등록하고 작업하거나 해야 하지만 지금은 if문으로
 */
public class ActionMapping {
	public Action mapping(String realPath){
		Action action = null;
		//실제로는 xml파싱을 하거나 properties파일을 분석해서 실행할 클래스를
		//생성한 후 리턴하는 코드를 작성해야 하나 우리는 if문으로 
		if(realPath.equals("/insert.kitri")){
			action = new EmpInsert();
		}else if(realPath.equals("/list.kitri")){
			action = new EmpSelect();
		}
		return action;
	}
}
