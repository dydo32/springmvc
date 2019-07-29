package dept.dao;

import java.util.List;

import dept.dto.DeptDTO;
import emp.dto.EmpDTO;
public interface DeptDAO {
	//부서갯수 조회
	int count();
	//부서등록
	int insert(DeptDTO dept);
	//부서정보수정
	int update(DeptDTO deptInfo);
	//부서삭제
	int delete(String deptno);
	//부서상세보기
	DeptDTO showDeptInfo(String deptno);
	//전체부서목록보기
	List<DeptDTO> getDeptList();
	//부서명으로 부서검색하기
	List<DeptDTO> findByDept(String deptname);
	//각 부서별 근무 직원을 검색하는 메소드
	List<EmpDTO> getMemberList(String deptname);
}









