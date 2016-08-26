package local.kapinos.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import local.kapinos.common.interfaces.LibraryPersistentBeanRemote;
import local.kapinos.common.persistence.Book;

/**
 * Session Bean implementation class LibraryPersistentBean
 */
@Stateless
public class LibraryPersistentBean implements LibraryPersistentBeanRemote {

	@PersistenceContext(unitName = "EjbComponentPU2")
	private EntityManager entityManager;

	@Override
	public void addBook(Book book) {
		entityManager.persist(book);
	}

	@Override
	public List<Book> getBooks() {
		return entityManager.createQuery("SELECT b FROM Book b", Book.class).getResultList();
	}
}
