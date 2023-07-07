package coding.mentor.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import coding.mentor.db.util.DBUtil;
import coding.mentor.entity.User;


public class UserService {
		
		public void addUser(User user) throws SQLException {
			//connect to DB
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			// make connection to mysql
			conn = DBUtil.makeConnection();
			

			ps = conn.prepareStatement("INSERT INTO `user`(name, email, password) value (?, ?, ?) ");
			
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			
			ps.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs !=null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}
		
		public User getUserByUsernameAndPassword(String username, String password) throws SQLException {
			//connect to DB
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		User user = null;
		
		try {
			// make connection to mysql
			conn = DBUtil.makeConnection();
			

			ps = conn.prepareStatement("SELECT * FROM `user` WHERE name = ? AND password = ? ");
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			rs =ps.executeQuery();
			
			if (rs.next()) {
				int id = rs.getInt("id");
				String userName = rs.getString("name");
				String email = rs.getString("email");
				String passWord = rs.getString("password");
				
				user = new User (id, userName, email, passWord);
			}else {
				return null;
			}
		
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs !=null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return user;
	}	
		
		
		
		



}
