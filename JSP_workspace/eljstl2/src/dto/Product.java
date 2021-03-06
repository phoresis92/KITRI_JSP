package dto;

public class Product {

	private String prod_no;
	private String prod_name;
	private Category prod_cate;
	private int prod_price;
	
	
	
	@Override
	public String toString() {
		return "Product [prod_no=" + prod_no + ", prod_name=" + prod_name + ", prod_cate=" + prod_cate + ", prod_price="
				+ prod_price + "]";
	}

	public Product(String prod_no, String prod_name, Category prod_cate, int prod_price) {
		super();
		this.prod_no = prod_no;
		this.prod_name = prod_name;
		this.prod_cate = prod_cate;
		this.prod_price = prod_price;
	}
	
	public Product() {
		super();
	}
	
	public String getProd_no() {
		return prod_no;
	}
	public void setProd_no(String prod_no) {
		this.prod_no = prod_no;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public Category getProd_cate() {
		return prod_cate;
	}
	public void setProd_cate(Category prod_cate) {
		this.prod_cate = prod_cate;
	}
	public int getProd_price() {
		return prod_price;
	}
	public void setProd_price(int prod_price) {
		this.prod_price = prod_price;
	}
	
}
