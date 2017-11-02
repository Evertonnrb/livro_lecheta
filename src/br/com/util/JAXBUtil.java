package br.com.util;

import java.io.IOException;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.stream.XMLStreamWriter;

import org.codehaus.jettison.mapped.MappedNamespaceConvention;
import org.codehaus.jettison.mapped.MappedXMLStreamWriter;

import br.com.domain.Carro;
import br.com.domain.ListaCarro;

public class JAXBUtil {
		
	private static JAXBUtil instance;
	private static JAXBContext context;
	
	public static JAXBUtil getInstance() {
		return instance;
	}
	
	static {
		try {
			context = JAXBContext.newInstance(ListaCarro.class,Carro.class);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	public static String toXml(Object object)throws IOException{
		try {
			StringWriter writer = new StringWriter();
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(object, writer);
			String xml = writer.toString();
			return xml;
	} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String toJson(Object object)throws IOException{
		try {
			StringWriter writer = new StringWriter();
			Marshaller marshaller = context.createMarshaller();
			MappedNamespaceConvention con = new MappedNamespaceConvention();
			XMLStreamWriter streamWriter = new MappedXMLStreamWriter(con, writer);
			marshaller.marshal(object, streamWriter);
			String json = writer.toString();
			return json;
		} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}
	}
}









