package Brokers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import EntityManager.PersistenceManager;
import Dtos.CategoryDto;
import Entities.Category;

public class CategoryBroker implements BrokerIf<CategoryDto>{
	
	
	private EntityManager entityManager = PersistenceManager.emf.createEntityManager();
	
	private final String GET_CATEGORY = "SELECT c FROM Category c Where categoryName = :catName";

	@Override
	public List<CategoryDto> getAll() {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Category> cQuery = builder.createQuery(Category.class);
		Root<Category> category = cQuery.from(Category.class);

		cQuery.select(category);
		
		TypedQuery<Category> tQuery = entityManager.createQuery(cQuery);
		return wrapIntoDto(tQuery.getResultList());

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

	@Override
	public CategoryDto create() {
		// TODO Auto-generated method stub
		return null;
	}

}
