package library.dto;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import library.entities.Category;

public class CategoryDto {

	
	private Category category;
	
	private StringProperty id;
	private StringProperty categoryName;
	
	
	public CategoryDto(Category category) {
		super();
		this.category = category;
		
		id = new SimpleStringProperty(String.valueOf(category.getCategoryId()));
		categoryName = new SimpleStringProperty(category.getCategoryName());
		
	}
	public StringProperty getId() {
		return id;
	}
	
	public StringProperty getCategoryName() {
		return categoryName;
	}
	public Category getCategory() {
		return category;
	}
	
	
	
}
