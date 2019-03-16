package library.broker;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import library.core.Constants;
import library.dto.CategoryDto;
import library.entities.Category;

public class CategoryBroker implements BrokerIf<CategoryDto>{
	
	
	private EntityManager entityManager = Constants.emf.createEntityManager();

	@Override
	public List<CategoryDto> getAll() {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Category> cQuery = builder.createQuery(Category.class);
		Root<Category> category = cQuery.from(Category.class);

		cQuery.select(category);
		
		TypedQuery<Category> tQuery = entityManager.createQuery(cQuery);
		return wrapIntoDto(tQuery.getResultList());

	}
	
	public CategoryDto CreateCategory(String aCatName)
	{
		return new CategoryDto(createNewCategory(aCatName));
	}
	
	private Category createNewCategory(String aName)
	{
		Category category = new Category(aName);
		entityManager.getTransaction().begin();
		entityManager.persist(category);
		entityManager.getTransaction().commit();
		
		return category;
	}

	private List<CategoryDto> wrapIntoDto(List<Category> aCategories) {
		return aCategories.stream().map(CategoryDto::new).collect(Collectors.toList());
	}

	@Override
	public void commitChanges(List<CategoryDto> aCategoriesDto) {
		
	}

	@Override
	public void delete(List<CategoryDto> aDtoList) {
		// TODO Auto-generated method stub
		
	}

}
