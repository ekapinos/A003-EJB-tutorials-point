/**
 * LibraryService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package local.kapinos.ws;

public interface LibraryService extends javax.xml.rpc.Service {
    public java.lang.String getLibraryPersistentBeanPortAddress();

    public local.kapinos.ws.LibraryPersistentBean getLibraryPersistentBeanPort() throws javax.xml.rpc.ServiceException;

    public local.kapinos.ws.LibraryPersistentBean getLibraryPersistentBeanPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
