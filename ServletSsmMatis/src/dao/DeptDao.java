package dao;

import java.util.List;

import bean.Dept;

public interface DeptDao {
	//��ѯ����
	public List<Dept> find();
	
	//����
	public int  add(Dept dept);
	
	//����id��ѯ
	public Dept findId(int id);
	//�޸�
	public int modify(Dept dept);
	
	//ɾ��
	public int del(int id);

}
