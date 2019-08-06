package frontcontroller.fw;

import frontcontroller.emp.EmpInsert;
import frontcontroller.emp.EmpSelect;

/*
 * FrontServlet�� �Ѱ��� ��û������ ������ ���� ������ Ŭ������ �������ִ� ����
 * �̸� ��ûpath�� ���� ������ Ŭ������ ������ springó�� xml�� ����ϰų�
 * properties���Ͽ� ����ϰ� �۾��ϰų� �ؾ� ������ ������ if������
 */
public class ActionMapping {
	public Action mapping(String realPath){
		Action action = null;
		//�����δ� xml�Ľ��� �ϰų� properties������ �м��ؼ� ������ Ŭ������
		//������ �� �����ϴ� �ڵ带 �ۼ��ؾ� �ϳ� �츮�� if������ 
		if(realPath.equals("/insert.kitri")){
			action = new EmpInsert();
		}else if(realPath.equals("/list.kitri")){
			action = new EmpSelect();
		}
		return action;
	}
}
