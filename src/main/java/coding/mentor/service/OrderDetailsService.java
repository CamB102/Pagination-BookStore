package coding.mentor.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import coding.mentor.db.util.DBUtil;
import coding.mentor.entity.Book;
import coding.mentor.entity.OrderDetails;

public class OrderDetailsService {
	public void addOrderDetails(OrderDetails orderDetails) throws SQLException {
		// connect to DB
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			// make connection to mysql
			conn = DBUtil.makeConnection();

			// -> table Category ->
			// Run query "select * from category"
			ps = conn.prepareStatement("INSERT INTO order_details(order_id, book_id) value(?, ?)");
			ps.setInt(1, orderDetails.getOrderId());
			ps.setInt(2, orderDetails.getBookId() );

			// execute and get result SET
			ps.execute();

			// mapping data in result set (IF RESULT SET HAS DATA) into ENTITY CLASS
			// (Category)
			
			// -> if exist -> return User(id, user,password, status)
			// -> not exist -> return null
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

		
	}
}
