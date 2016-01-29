package example.dynamicFeature;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MyBean {
    @XmlElement
    public String anyString;
    @XmlElement
    public int anyNumber;

    public MyBean(String anyString, int anyNumber) {
        this.anyString = anyString;
        this.anyNumber = anyNumber;
    }

    // empty constructor needed for deserialization by JAXB
    public MyBean() {
    }

    @Override
    public String toString() {
        return "MyBean{" +
                "anyString='" + anyString + '\'' +
                ", anyNumber=" + anyNumber +
                '}';
    }
}