package frontcontroller.emp;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import frontcontroller.fw.Action;

public class EmpInsert implements Action {
	@Override
	public void run(HttpServletRequest req, HttpServletResponse res) throws ServerException, IOException {
		//�������� �����ߴ� �ڵ带 �̰��� ����
		System.out.println("Action insert");
	
	}

}
