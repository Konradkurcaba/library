package library.entities;

public enum BookCategoryE {

	Horror("Horror"),Fantasy("Fantasy"),ScienceFiction("Science Fiction")
	,Cooking("Cooking"),ForKids("For Kids");
	
	private String category;

	private BookCategoryE(String category) {
		this.category = category;
	}
	
	@Override
	public String toString()
	{
		return category;
	}
}
