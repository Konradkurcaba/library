package Dtos;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import Entities.Category;

public class CategoryDto implements DtoCaValue {

	
	private Category category;
	
	private StringProperty id;
	private StringProperty categoryName;
	
	
	public CategoryDto(Category category) {
		super();
		this.category = category;
		
		id = new SimpleStringProperty(String.valueOf(category.getCategoryId()));
		categoryName = new SimpleStringProperty(category.getCategoryName());
	}

	public CategoryDto()
	{
		categoryName = new SimpleStringProperty("");
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


	@Override
	public String getCaName() {
		return getCategoryName().getValue();
	}
}
