package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.or.bit.dto.registerdto;
import kr.or.bit.utils.ConnectionHelper;

public class mvcregisterdao {

	//CRUD
	
	//writeOk
	public int writeOk(registerdto dto) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int resultrow = 0; 
		
		try {			
			conn = ConnectionHelper.getConnection("oracle");
			String sql = "insert into mvcregister(id,pwd,email) values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, dto.getId());
			pstmt.setString(2, dto.getPwd());
			pstmt.setString(3, dto.getEmail());
			
			resultrow = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		
		return resultrow;
	}
}
