package coding.mentor.entity;

public class Book {
	private int id;
	private String name;
	private int categoryId;
	private String title;
	private String author;
	private int stock;
	
	
	
	public Book(int id, String name, int categoryId, String title, String author, int stock) {
		super();
		this.id = id;
		this.name = name;
		this.categoryId = categoryId;
		this.title = title;
		this.author = author;
		this.stock = stock;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Book() {

	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

}
