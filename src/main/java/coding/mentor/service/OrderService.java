package coding.mentor.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import coding.mentor.db.util.DBUtil;
import coding.mentor.entity.Book;
import coding.mentor.entity.Order;

public class OrderService {
	
	public int addOrder(Order order) throws SQLException {
		// connect to DB
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			// make connection to mysql
			conn = DBUtil.makeConnection();

			// -> table Category ->
			// Run query "select * from category"
			ps = conn.prepareStatement("INSERT INTO `order`(user_id, submit_date, approve) VALUE (?,?,?)", Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, order.getUserId());
			ps.setDate(2, new Date(System.currentTimeMillis()));
			ps.setBoolean(3, order.isApprove());

			// execute and get result SET
			ps.execute();
			rs = ps.getGeneratedKeys();

			// mapping data in result set (IF RESULT SET HAS DATA) into ENTITY CLASS
			// (Category)
			if (rs.next()) {
				int insertedId = rs.getInt(1);
				return insertedId;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return 0;
	}

}
