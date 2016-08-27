package local.kapinos.ejb;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import local.kapinos.common.interfaces.LibraryPersistentBeanRemote;
import local.kapinos.common.persistence.Book;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/BookQueue") })
public class LibraryMessageBean implements MessageListener {

	@Resource
	private MessageDrivenContext mdctx;

	@EJB
	LibraryPersistentBeanRemote libraryBean;

	public void onMessage(Message message) {
		ObjectMessage objectMessage = null;
		try {
			objectMessage = (ObjectMessage) message;
			Book book = (Book) objectMessage.getObject();
			libraryBean.addBook(book);

		} catch (JMSException ex) {
			mdctx.setRollbackOnly();
		}
	}

}
