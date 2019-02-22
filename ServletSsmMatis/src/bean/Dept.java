package bean;

import java.io.Serializable;

public class Dept implements Serializable {
	// 部门编号
	private Integer dno;

	// 部门名称
	private String dname;

	// 部门人数
	private Integer empCount;

	public Dept() {
	}

	public Dept(Integer dno, String dname, Integer empCount) {
		this.dno = dno;
		this.dname = dname;
		this.empCount = empCount;
	}

	public Integer getDno() {
		return dno;
	}

	public void setDno(Integer dno) {
		this.dno = dno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public Integer getEmpCount() {
		return empCount;
	}

	public void setEmpCount(Integer empCount) {
		this.empCount = empCount;
	}

}
