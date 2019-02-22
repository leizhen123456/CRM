package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.DeptDao;

import bean.Dept;
import service.DeptService;


@Service //idÎªdeptServiceImpl
public class DeptServiceImpl implements DeptService {

	// ÉùÃ÷DeptDao
	@Autowired
	private DeptDao deptDao;

	public DeptDao getDeptDao() {
		return deptDao;
	}

	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}

	public List<Dept> find() {
		
		return deptDao.find();
	}

	public int add(Dept dept) {
	
		return deptDao.add(dept);
	}

	public Dept findId(int id) {
		
		return deptDao.findId(id);
	}

	
	public int del(int id) {
		
		return deptDao.del(id);
	}

	public int modify(Dept dept) {
		
		return deptDao.modify(dept);
	}


}
