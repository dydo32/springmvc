package frontcontroller.fw;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	void run(HttpServletRequest req, HttpServletResponse res) throws ServerException, IOException;
}
