package local.kapinos.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import local.kapinos.common.interfaces.LibraryPersistentBeanRemote;
import local.kapinos.common.persistence.Book;

/**
 * Session Bean implementation class LibraryPersistentBean
 */
@Stateless
@WebService(serviceName="LibraryService")
public class LibraryPersistentBean implements LibraryPersistentBeanRemote {

	@PersistenceContext(unitName = "EjbComponentPU2")
	private EntityManager entityManager;

	@WebMethod(exclude=true)
	@Override
	public void addBook(Book book) {
		entityManager.persist(book);
	}

	@WebMethod(operationName="getBooks")
	@Override
	public List<Book> getBooks() {
		return entityManager.createQuery("SELECT b FROM Book b", Book.class).getResultList();
	}
}
