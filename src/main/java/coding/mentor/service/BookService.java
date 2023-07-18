package coding.mentor.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import coding.mentor.db.util.DBUtil;
import coding.mentor.entity.Book;

public class BookService {
	public List<Book> getBooksByCategoryId(int categoryId) throws SQLException {
		// connect to DB
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Book book = null;
		List<Book> list = new ArrayList<Book>();
		try {
			// make connection to mysql
			conn = DBUtil.makeConnection();

			// -> table Category ->
			// Run query "select * from category"
			ps = conn.prepareStatement("select * from `book` where category_id = ?");
			ps.setInt(1, categoryId);

			// execute and get result SET
			rs = ps.executeQuery();

			// mapping data in result set (IF RESULT SET HAS DATA) into ENTITY CLASS
			// (Category)
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int categoryId1 = rs.getInt("category_id");
				int stock = rs.getInt("stock");
				String author = rs.getString("author");
				String title = rs.getString("title");
				double price = rs.getDouble("price");
				

				book = new Book(id, name, categoryId1, author, title, stock, price);
				list.add(book);
			}
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
		return list;
	}

public List<Book> getBooksByName(String bookName) throws SQLException {
	// connect to DB
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	Book book = null;
	List<Book> list = new ArrayList<Book>();
	try {
		// make connection to mysql
		conn = DBUtil.makeConnection();

		// -> table Category ->
		// Run query "select * from category"
		ps = conn.prepareStatement("select * from `book` where name like ?");
		ps.setString(1, "%" + bookName + "%");

		// execute and get result SET
		rs = ps.executeQuery();

		// mapping data in result set (IF RESULT SET HAS DATA) into ENTITY CLASS
		// (Category)
		if (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int categoryId = rs.getInt("category_id");
			int stock = rs.getInt("stock");
			String author = rs.getString("author");
			String title = rs.getString("title");
			double price = rs.getDouble("price");
			

			book = new Book(id, name, categoryId, author, title, stock, price);
			

			
			list.add(book);
		}
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
	return list;
}
public List<Book> getAllBooks() throws SQLException {
	// connect to DB
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	Book book = null;
	List<Book> list = new ArrayList<Book>();
	try {
		// make connection to mysql
		conn = DBUtil.makeConnection();

		// -> table Category ->
		// Run query "select * from category"
		ps = conn.prepareStatement("select * from `book`");

		// execute and get result SET
		rs = ps.executeQuery();

		// mapping data in result set (IF RESULT SET HAS DATA) into ENTITY CLASS
		// (Category)
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int categoryId = rs.getInt("category_id");
			int stock = rs.getInt("stock");
			String author = rs.getString("author");
			double price = rs.getDouble("price");
			String title = rs.getString("title");
			

			book = new Book(id, name, categoryId, title, author, stock, price);
			list.add(book);
		}
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
	return list;
}

public Book getBookDetails(int bookId) throws SQLException {
	// connect to DB
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	Book book = null;
	List<Book> list = new ArrayList<Book>();
	try {
		// make connection to mysql
		conn = DBUtil.makeConnection();

		// -> table Category ->
		// Run query "select * from category"
		ps = conn.prepareStatement("select * from `book` where id = ?");
		ps.setInt(1,bookId);

		// execute and get result SET
		rs = ps.executeQuery();

		// mapping data in result set (IF RESULT SET HAS DATA) into ENTITY CLASS
		// (Category)
		if (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int categoryId = rs.getInt("category_id");
			int stock = rs.getInt("stock");
			String author = rs.getString("author");
			double price = rs.getDouble("price");
			String title = rs.getString("title");
			
			

			book = new Book(id, name, categoryId, author, title, stock, price);
			list.add(book);
		}
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
	return book;
}
public List<Book> getBooksBySearch(String bookName) throws SQLException {
	// connect to DB
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	Book book = null;
	List<Book> list = new ArrayList<Book>();
	try {
		// make connection to mysql
		conn = DBUtil.makeConnection();

		// -> table Category ->
		// Run query "select * from category"
		ps = conn.prepareStatement("select * from `book` where name like ?");
		ps.setString(1, "%" + bookName + "%");

		// execute and get result SET
		rs = ps.executeQuery();

		// mapping data in result set (IF RESULT SET HAS DATA) into ENTITY CLASS
		// (Category)
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int categoryId = rs.getInt("category_id");
			int stock = rs.getInt("stock");
			String author = rs.getString("author");
			double price = rs.getDouble("price");
			String title = rs.getString("title");
			
			

			book = new Book(id, name, categoryId, author, title, stock, price);
			list.add(book);
		}
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
	return list;
}
public Book getBookPutInCart(int bookId) throws SQLException {
	// connect to DB
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	Book book = null;
	List<Book> list = new ArrayList<Book>();
	try {
		// make connection to mysql
		conn = DBUtil.makeConnection();

		// -> table Category ->
		// Run query "select * from category"
		ps = conn.prepareStatement("select * from `book`");

		// execute and get result SET
		rs = ps.executeQuery();

		// mapping data in result set (IF RESULT SET HAS DATA) into ENTITY CLASS
		// (Category)
		if (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int categoryId = rs.getInt("category_id");
			int stock = rs.getInt("stock");
			String author = rs.getString("author");
			double price = rs.getDouble("price");
			String title = rs.getString("title");
			
			

			book = new Book(id, name, categoryId, author, title, stock, price);
			list.add(book);
		}
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
	return book;
}
public int countAllBooks() throws SQLException {
	// connect to DB
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	try {
		// make connection to mysql
		conn = DBUtil.makeConnection();

		// -> table Category ->
		// Run query "select * from category"
		ps = conn.prepareStatement("select count(*) from `book`");

		// execute and get result SET
		rs = ps.executeQuery();

		
		while (rs.next()) {
			return rs.getInt(1);
		}
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
	return 0;
}

public int calculateTotalPages(int booksPerPage) throws SQLException{
	int totalBooks = countAllBooks();
	return (int) Math.ceil((double) totalBooks / booksPerPage);
}



public List<Book> pagingBook(int pageIndex, int booksPerPage) throws SQLException{
	// connect to DB
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Book book = null;
		List<Book> list = new ArrayList<Book>();
		try {
			// make connection to mysql
			conn = DBUtil.makeConnection();

			// -> table Category ->
			// Run query "select * from category"
			ps = conn.prepareStatement("SELECT *\n"
					+ "FROM (\n"
					+ "    SELECT *,\n"
					+ "    ROW_NUMBER() OVER (ORDER BY id) AS row_num\n"
					+ "    FROM book\n"
					+ ") AS subquery\n"
					+ "WHERE row_num BETWEEN ((? - 1) * ?) + 1 AND (? * ?)\n"
					+ "ORDER BY id;");
			ps.setInt(1, pageIndex);
			ps.setInt(2, booksPerPage);
			ps.setInt(3, pageIndex);
			ps.setInt(4, booksPerPage);

			// execute and get result SET
			rs = ps.executeQuery();

			// mapping data in result set (IF RESULT SET HAS DATA) into ENTITY CLASS
			// (Category)
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int categoryId = rs.getInt("category_id");
				int stock = rs.getInt("stock");
				String author = rs.getString("author");
				double price = rs.getDouble("price");
				String title = rs.getString("title");
				
				

				book = new Book(id, name, categoryId, author, title, stock, price);
				list.add(book);
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
		System.out.println("danh sach: " + list);
		return list;
}

}
