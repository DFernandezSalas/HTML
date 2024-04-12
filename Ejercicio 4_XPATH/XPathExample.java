import java.io.StringReader;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XPathExample {

    public static void main(String[] args) throws Exception {
        // Tu documento XML como una cadena
        String xmlString = "<empleados>\r\n"
        		+ "  <empleado>\r\n"
        		+ "    <id>001</id>\r\n"
        		+ "    <nombre>Carlos Pérez</nombre>\r\n"
        		+ "    <puesto>Desarrollador</puesto>\r\n"
        		+ "    <salario>60000</salario>\r\n"
        		+ "  </empleado>\r\n"
        		+ "  <empleado>\r\n"
        		+ "    <id>002</id>\r\n"
        		+ "    <nombre>Maria Rodríguez</nombre>\r\n"
        		+ "    <puesto>Analista de Datos</puesto>\r\n"
        		+ "    <salario>75000</salario>\r\n"
        		+ "  </empleado>\r\n"
        		+ "</empleados>\r\n"
        		+ "";

        // Crear un objeto Document a partir de la cadena XML
        Document document = parseXML(xmlString);

        // Crear un objeto XPath
        XPath xpath = XPathFactory.newInstance().newXPath();

        // Ejemplo de consulta XPath para obtener nombres de empleados
        String xpathExpression = "/empleados/empleado/nombre";
        NodeList nodeList = (NodeList) xpath.compile(xpathExpression).evaluate(document, XPathConstants.NODESET);

        // Imprimir resultados
        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println("Nombre: " + nodeList.item(i).getTextContent());
        }
    }

    private static Document parseXML(String xmlString) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        return factory.newDocumentBuilder().parse(new InputSource(new StringReader(xmlString)));
    }
}
