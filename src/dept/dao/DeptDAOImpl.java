package dept.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import dept.dto.DeptDTO;
import dept.dto.DeptRowMapper;
import emp.dto.EmpDTO;
import emp.dto.MyEmpRowMapper;

public class DeptDAOImpl implements DeptDAO {
	private JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public int count() {
		return template.queryForObject("select count(deptno) from kitridept", Integer.class);
	}

	@Override
	public int insert(DeptDTO dept) {
		String sql = "insert into kitridept values(?,?,?,?,?)";
		int result = template.update(sql,dept.getDeptNo(),dept.getDeptName(),dept.getLoc(),dept.getTel(),dept.getMgr());
		return result;
	}

	@Override
	public int update(DeptDTO deptInfo) {
		String sql = "update kitridept set deptname=?,loc=?,telnum=?, mgr=? where deptno=?";
		int result = template.update(sql,deptInfo.getDeptName(),deptInfo.getLoc(),deptInfo.getTel(),deptInfo.getMgr(),deptInfo.getDeptNo());
		return result;
	}

	@Override
	public int delete(String deptno) {
		return template.update("delete from kitridept where deptno=?",deptno);
	}

	@Override
	public DeptDTO showDeptInfo(String deptno) {
		try{
			return template.queryForObject("select * from kitridept where deptno=?", new Object[]{deptno},new DeptRowMapper() );
		}catch(DataAccessException e){
			return null;
		}
	}

	@Override
	public List<DeptDTO> getDeptList() {
		return template.query("select * from kitridept",  new DeptRowMapper());
	}

	@Override
	public List<DeptDTO> findByDept(String deptname) {
		return template.query("select * from kitridept where deptname like ?", new Object[]{"%"+deptname+"%"} ,new DeptRowMapper());
	}

	@Override
	public List<EmpDTO> getMemberList(String deptname) {
		return template.query("select * from kitriemp where deptno in (select deptno from KITRIDEPT where deptname like ?)", 
								new Object[]{"%"+deptname+"%"} ,new MyEmpRowMapper());
	}

}
