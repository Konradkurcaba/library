package library.broker;

import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import library.core.Constants;
import library.dto.BookDto;
import library.entities.Book;

public class BookBroker implements Broker<BookDto> {
	
	private EntityManager entityManager = Constants.emf.createEntityManager();

	@Override
	public List<BookDto> getAll()
	{
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Book> criteriaQuery = builder.createQuery(Book.class);
		Root<Book> book = criteriaQuery.from(Book.class);
		
		criteriaQuery.select(book);
		TypedQuery<Book> query = entityManager.createQuery(criteriaQuery);
		List<Book> allBooks = query.getResultList();
		return wrapBooks(allBooks);
	}
	
	@Override
	public void commitChanges(List<BookDto> aBooks)
	{
		aBooks.stream()
		.forEach(BookDto::commitChanges);
		
		entityManager.getTransaction().begin();
		entityManager.getTransaction().commit();
	}
	
	private List<BookDto> wrapBooks(List<Book> aBooks)
	{
		return aBooks.stream()
				.map(BookDto::new)
				.collect(Collectors.toList());
	}
	
}
