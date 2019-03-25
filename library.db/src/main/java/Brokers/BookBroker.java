package Brokers;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import EntityManager.PersistenceManager;
import Dtos.BookDto;
import Entities.Book;

public class BookBroker implements BrokerIf<BookDto> {
	
	private EntityManager entityManager = PersistenceManager.emf.createEntityManager();
	private String GET_BOOKS_TO_SEND_NOTIFICATION = "SELECT b FROM Book b WHERE wasNotificationSent = false";

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
		entityManager.getTransaction().begin();
		
		aBooks.stream()
		.filter(bookDto -> {
			if(!bookDto.isPersisted()) return true;
			else return false;
		})
		.forEach(bookDto -> {
			Book book = new Book();
			entityManager.persist(book);
			bookDto.setBook(book);
		});
		
		aBooks.stream()
		.forEach(BookDto::commitChanges);
		
		entityManager.getTransaction().commit();
	}
	
	@Override
	public void delete(List<BookDto> aBooks) {
		aBooks.stream()
		.map(BookDto::getBook)
		.forEach(entityManager::remove);
	}
	
	@Override
	public BookDto create() {
		return new BookDto();
	}
	

	private List<BookDto> wrapBooks(List<Book> aBooks)
	{
		return aBooks.stream()
				.map(BookDto::new)
				.collect(Collectors.toList());
	}

	public List<BookDto> getBooksToNotify()
	{
		List<Book> books = entityManager.createQuery(GET_BOOKS_TO_SEND_NOTIFICATION)
				.getResultList();

		return books.stream()
				.map(BookDto::new)
				.collect(Collectors.toList());
	}

	
}
