package bean;

import java.io.Serializable;

public class Dept implements Serializable {
	// ���ű��
	private Integer dno;

	// ��������
	private String dname;

	// ��������
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
