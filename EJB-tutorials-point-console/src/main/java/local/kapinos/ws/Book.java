/**
 * Book.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package local.kapinos.ws;

public class Book  implements java.io.Serializable {
    private int id;

    private byte[] image;

    private java.lang.String lobXml;

    private java.lang.String name;

    private local.kapinos.ws.Publisher publisher;

    public Book() {
    }

    public Book(
           int id,
           byte[] image,
           java.lang.String lobXml,
           java.lang.String name,
           local.kapinos.ws.Publisher publisher) {
           this.id = id;
           this.image = image;
           this.lobXml = lobXml;
           this.name = name;
           this.publisher = publisher;
    }


    /**
     * Gets the id value for this Book.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this Book.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the image value for this Book.
     * 
     * @return image
     */
    public byte[] getImage() {
        return image;
    }


    /**
     * Sets the image value for this Book.
     * 
     * @param image
     */
    public void setImage(byte[] image) {
        this.image = image;
    }


    /**
     * Gets the lobXml value for this Book.
     * 
     * @return lobXml
     */
    public java.lang.String getLobXml() {
        return lobXml;
    }


    /**
     * Sets the lobXml value for this Book.
     * 
     * @param lobXml
     */
    public void setLobXml(java.lang.String lobXml) {
        this.lobXml = lobXml;
    }


    /**
     * Gets the name value for this Book.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this Book.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the publisher value for this Book.
     * 
     * @return publisher
     */
    public local.kapinos.ws.Publisher getPublisher() {
        return publisher;
    }


    /**
     * Sets the publisher value for this Book.
     * 
     * @param publisher
     */
    public void setPublisher(local.kapinos.ws.Publisher publisher) {
        this.publisher = publisher;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Book)) return false;
        Book other = (Book) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.id == other.getId() &&
            ((this.image==null && other.getImage()==null) || 
             (this.image!=null &&
              java.util.Arrays.equals(this.image, other.getImage()))) &&
            ((this.lobXml==null && other.getLobXml()==null) || 
             (this.lobXml!=null &&
              this.lobXml.equals(other.getLobXml()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.publisher==null && other.getPublisher()==null) || 
             (this.publisher!=null &&
              this.publisher.equals(other.getPublisher())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += getId();
        if (getImage() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getImage());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getImage(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getLobXml() != null) {
            _hashCode += getLobXml().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getPublisher() != null) {
            _hashCode += getPublisher().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Book.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ejb.kapinos.local/", "book"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("image");
        elemField.setXmlName(new javax.xml.namespace.QName("", "image"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lobXml");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lobXml"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("publisher");
        elemField.setXmlName(new javax.xml.namespace.QName("", "publisher"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ejb.kapinos.local/", "publisher"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
