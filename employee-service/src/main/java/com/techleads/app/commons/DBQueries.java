package com.techleads.app.commons;

public interface DBQueries {
	String GET_EMP_BY_ID="SELECT ID, NAME, SALARY FROM EMP WHERE ID=?";
	String GET_EMPS="SELECT ID, NAME, SALARY FROM EMP";
	String INSERT_EMP="INSERT INTO EMP(ID,NAME,SALARY) VALUES(?,?,?)";
	String DEL_EMP_BY_ID="DELETE FROM EMP WHERE ID=?";

}
