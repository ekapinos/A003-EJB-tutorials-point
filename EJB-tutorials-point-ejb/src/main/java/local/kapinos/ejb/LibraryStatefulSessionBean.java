package local.kapinos.ejb;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Stateful;

import local.kapinos.common.interfaces.LibraryStatefulSessionBeanRemote;

/**
 * Session Bean implementation class LibrarySessionBean
 */
@Stateful
public class LibraryStatefulSessionBean implements LibraryStatefulSessionBeanRemote {
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	private List<String> bookShelf;

	public LibraryStatefulSessionBean() {
		bookShelf = new ArrayList<String>();
	}
	
	public void addBook(String bookName) {
		bookShelf.add(bookName);
	}

	public List<String> getBooks() {
		return bookShelf;
	}
	
	@PostConstruct
	public void beanCreated(){
		logger.info(getClass() + " - @PostConstruct");
	}
	@PostActivate
	public void beanActivated(){
		logger.info(getClass() + " - @PostActivate");
	}
	@PrePassivate
	public void beanPassivated(){
		logger.info(getClass() + " - @PrePassivate");
	}
	@PreDestroy
	public void beanDestroyed(){
		logger.info(getClass() + " - @PreDestroy");
	}
}
