package service;

import java.util.List;

import bean.Dept;

public interface DeptService {
		//查询所有
		public List<Dept> find();		
		//增加
		public int  add(Dept dept);	
		
		//按照id查询
		public Dept findId(int id);
		//修改
		public int modify(Dept dept);	
		
		//删除
		public int del(int id);

}
