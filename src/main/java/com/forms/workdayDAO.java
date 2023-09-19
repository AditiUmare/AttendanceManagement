package com.forms;

import java.sql.Connection;
import java.sql.PreparedStatement;



public class workdayDAO implements DAO {

	@Override
	public int delete(DTO dto) throws Exception {

		Connection con = connectToDB.getConnection();
		workdayDTO workdayDTO=(workdayDTO)dto;
		String StrQuery="delete from workday where year=? and month=?";
        PreparedStatement stmt=con.prepareStatement(StrQuery);
        
        stmt.setInt(1,workdayDTO.getYear());
        stmt.setString(2,workdayDTO.getMonth());
         int rs=stmt.executeUpdate();
		return rs;
	}

}
