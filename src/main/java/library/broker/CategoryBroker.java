package library.broker;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import library.core.EntityManagerProvider;
import library.dto.CategoryDto;
import library.entities.Category;

public class CategoryBroker {

	public List<CategoryDto> getAllCategories() {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Category> cQuery = builder.createQuery(Category.class);
		Root<Category> category = cQuery.from(Category.class);

		cQuery.select(category);
		
		TypedQuery<Category> tQuery = entityManager.createQuery(cQuery);
		return wrapIntoDto(tQuery.getResultList());

	}
	
	public CategoryDto getOrCreate(String aCatName)
	{
		Optional<CategoryDto> optionalCategory = getAllCategories().stream()
				.filter(categoryDto -> categoryDto.getCategoryName().equals(aCatName))
				.findAny();
		
		if(optionalCategory.isPresent())
		{
			return optionalCategory.get();
		}else
		{
			return new CategoryDto(createNewCategory(aCatName));
		}
	}
	
	private Category createNewCategory(String aName)
	{
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		Category category = new Category(aName);
		entityManager.getTransaction().begin();
		entityManager.persist(entityManager);
		entityManager.getTransaction().commit();
		
		return category;
	}

	private List<CategoryDto> wrapIntoDto(List<Category> aCategories) {
		return aCategories.stream().map(CategoryDto::new).collect(Collectors.toList());
	}

}
