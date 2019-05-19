package com.ap.datamodel;

public class ProductData {
	
	
	private String productname;

	private String quantity;

	private String size;

	private String color;
	//To generate this right click -> Source -> Generate Setter and Getters (Include all private datatypes)
	
	
	public String getproductname() {//Onlt the user will have access to this information.
		return productname;
	}
	public void setproductname(String productname) {
		this.productname= productname;
	}
	
	public String getQuantity() {
		return quantity;
	}
	
	public void setQuantity(String quantity) {
		this.quantity= quantity;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}//To Generate the HashCodes -> Right click -> Source -> Generate Hashcode and include all
	@Override
	public int hashCode() {
		final int prime = 31;//31 is the limit but can be higher or lower ie if a customer is ordering 1 or 2 items//A Limitation on purchase
		int result = 1;//
		/*If it matches the result it is true different possiblities of color, productname, quantity, size
		//if the result is within prime * result added with existing color 
		 * HashCode:When hashcode
		 * invokes on the same object more than once during execution it should consistently return the same value
		without foreign additional value/object*/
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((productname == null) ? 0 : productname.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		return result;
	}//If the item exist(True) grab that item, grab that data, grab that color, size, quantity. if False or null (Empty) do not grab.
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductData other = (ProductData) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (productname == null) {
			if (other.productname != null)
				return false;
		} else if (!productname.equals(other.productname))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		return true;
	}
	@Override//To Generate right click -> Source ->Generate To String and include all with methods and inherited Methods
	public String toString() {
		return "ProductData [productname=" + productname + ", quantity=" + quantity + ", size=" + size + ", color="
				+ color + ", getproductname()=" + getproductname() + ", getQuantity()=" + getQuantity() + ", getSize()="
				+ getSize() + ", getColor()=" + getColor() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
