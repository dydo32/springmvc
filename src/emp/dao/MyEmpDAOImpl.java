package emp.dao;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import emp.dto.EmpDTO;
import emp.dto.MyEmpRowMapper;
//�������Ͽ� property injection�� ���ؼ� ���޹��� �� �ֵ��� �����ϰ� �����ӿ�ũ�� ������
//�����̳ʸ� ���ؼ� injection�޴´�.
public class MyEmpDAOImpl implements MyEmpDAO {
	private JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public int count() {
		return template.queryForObject("select count(id) from kitriemp", Integer.class);
	}
	
	@Override
	public int insert(EmpDTO user) {
		String sql = "insert into kitriemp values(?,?,?,?,sysdate,?,1000,?)";
		//?(����ǥ)������� update�޼ҵ忡 �����Ѵ�.
		int result = template.update(sql,user.getId(),user.getPass(),user.getName(),user.getAddr(),user.getGrade(),user.getDeptNo());
		return result;
	}
	@Override
	public int update(EmpDTO userInfo) {
		String sql = "update kitriemp set pass=?,addr=?,grade=? where id=?";
		int result = template.update(sql,userInfo.getPass(), userInfo.getAddr(),userInfo.getGrade(), userInfo.getId());
		return result;
	}
	@Override
	public int delete(String id) {
		String sql = "delete from kitriemp where id=?";
		int result = template.update(sql,id);
		return result;
	}
	@Override
	public EmpDTO login(String id, String pass) {
		try{
			return template.queryForObject("select * from kitriemp where id=? and pass=?", new Object[]{id,pass}, new MyEmpRowMapper() );
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}
	@Override
	public List<EmpDTO> getMemberList() {
		return template.query("select * from kitriemp", new MyEmpRowMapper());
	}
	@Override
	public List<EmpDTO> findByAddr(String addr) {
		return template.query("select * from kitriemp where addr like ?",new Object[]{"%"+addr+"%"}, new MyEmpRowMapper());
	}

}
