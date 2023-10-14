package io.github.lunasaw.sip.common.entity.xml;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import lombok.Data;
import lombok.SneakyThrows;

/**
 * @author luna
 * @date 2023/10/12
 */
@Data
public class XmlBean {

    /**
     * 字符集, 支持 UTF-8 与 gb2312
     */
    private String charset = "gb2312";

    @SneakyThrows
    @Override
    public String toString() {
        JAXBContext jaxbContext = JAXBContext.newInstance(this.getClass());
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, charset);

        StringWriter writer = new StringWriter();
        marshaller.marshal(this, writer);
        return writer.toString();
    }

    @SneakyThrows
    public static  <T> Object parseObj(String xmlStr, Class<T> clazz) {
        JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return unmarshaller.unmarshal(new StringReader(xmlStr));
    }
}
