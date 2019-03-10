package library.broker;

import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import library.core.EntityManagerProvider;
import library.dto.BookDto;
import library.entities.Book;

public class BookBroker {

	public List<BookDto> getAllBooks()
	{
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Book> criteriaQuery = builder.createQuery(Book.class);
		Root<Book> book = criteriaQuery.from(Book.class);
		
		criteriaQuery.select(book);
		TypedQuery<Book> query = entityManager.createQuery(criteriaQuery);
		List<Book> allBooks = query.getResultList();
		return wrapBooks(allBooks);
	}
	
	private List<BookDto> wrapBooks(List<Book> aBooks)
	{
		return aBooks.stream()
				.map(BookDto::new)
				.collect(Collectors.toList());
	}
	
}
