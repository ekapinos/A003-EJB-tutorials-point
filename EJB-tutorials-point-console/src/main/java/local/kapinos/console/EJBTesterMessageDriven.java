package local.kapinos.console;

import java.util.List;

import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import local.kapinos.common.persistence.Book;

public class EJBTesterMessageDriven extends AbstractEJBTester<Book>{
	
	QueueSession session;
	QueueSender sender;
	
	EJBTesterPersistent ejbTesterPersistent;

	public static void main(String[] args) {
		new EJBTesterMessageDriven().testEjb();
	}
	
	@Override
	public void firstLookup(InitialContext ctx) throws Exception {
		Queue queue = (Queue) ctx.lookup("jms/BookQueue");
        QueueConnectionFactory factory = (QueueConnectionFactory) ctx.lookup("jms/BookQueueFactory");
        QueueConnection connection =  factory.createQueueConnection();
        
        session = connection.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
        sender = session.createSender(queue);
        
        ejbTesterPersistent = new EJBTesterPersistent();
        ejbTesterPersistent.firstLookup(ctx);
	}

	@Override
	public void addBook(String bookName) throws Exception {
        ObjectMessage objectMessage = session.createObjectMessage(new Book(bookName));
        sender.send(objectMessage); 
	}

	@Override
	public List<Book> getBooksList() {
		return ejbTesterPersistent.getBooksList();
	}
	
	@Override
	public List<Book> secondLookupAndGetBooksList(InitialContext ctx) throws NamingException {
		return null;
	}
}
