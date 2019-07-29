package dept.dao;

import java.util.List;

import dept.dto.DeptDTO;
import emp.dto.EmpDTO;
public interface DeptDAO {
	//�μ����� ��ȸ
	int count();
	//�μ����
	int insert(DeptDTO dept);
	//�μ���������
	int update(DeptDTO deptInfo);
	//�μ�����
	int delete(String deptno);
	//�μ��󼼺���
	DeptDTO showDeptInfo(String deptno);
	//��ü�μ���Ϻ���
	List<DeptDTO> getDeptList();
	//�μ������� �μ��˻��ϱ�
	List<DeptDTO> findByDept(String deptname);
	//�� �μ��� �ٹ� ������ �˻��ϴ� �޼ҵ�
	List<EmpDTO> getMemberList(String deptname);
}









