import java.io.StringReader;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XPathEjercicio4 {

    public static void main(String[] args) throws Exception {
        // Tu documento XML como una cadena
        String xmlString = "<conference>\r\n"
        		+ "  <info>\r\n"
        		+ "    <name>International Tech Conference</name>\r\n"
        		+ "    <location>San Francisco, CA</location>\r\n"
        		+ "    <date>2024-05-15</date>\r\n"
        		+ "  </info>\r\n"
        		+ "\r\n"
        		+ "  <speakers>\r\n"
        		+ "    <speaker id=\"101\">\r\n"
        		+ "      <name>John Smith</name>\r\n"
        		+ "      <bio>\r\n"
        		+ "        John Smith is a software engineer with expertise in machine learning and data science.\r\n"
        		+ "      </bio>\r\n"
        		+ "    </speaker>\r\n"
        		+ "    <speaker id=\"102\">\r\n"
        		+ "      <name>Alice Johnson</name>\r\n"
        		+ "      <bio>\r\n"
        		+ "        Alice Johnson is a cybersecurity expert with a passion for ethical hacking.\r\n"
        		+ "      </bio>\r\n"
        		+ "    </speaker>\r\n"
        		+ "  </speakers>\r\n"
        		+ "\r\n"
        		+ "  <sessions>\r\n"
        		+ "    <session id=\"201\" speaker_id=\"101\">\r\n"
        		+ "      <title>Introduction to Machine Learning</title>\r\n"
        		+ "      <time>10:00 AM - 11:30 AM</time>\r\n"
        		+ "      <room>Auditorium A</room>\r\n"
        		+ "    </session>\r\n"
        		+ "    <session id=\"202\" speaker_id=\"102\">\r\n"
        		+ "      <title>Ethical Hacking Workshop</title>\r\n"
        		+ "      <time>1:00 PM - 3:00 PM</time>\r\n"
        		+ "      <room>Conference Room B</room>\r\n"
        		+ "    </session>\r\n"
        		+ "  </sessions>\r\n"
        		+ "\r\n"
        		+ "  <attendees>\r\n"
        		+ "    <attendee id=\"1001\">\r\n"
        		+ "      <name>Michael Brown</name>\r\n"
        		+ "      <affiliation>XYZ Corporation</affiliation>\r\n"
        		+ "    </attendee>\r\n"
        		+ "    <attendee id=\"1002\">\r\n"
        		+ "      <name>Lisa Davis</name>\r\n"
        		+ "      <affiliation>ABC Industries</affiliation>\r\n"
        		+ "    </attendee>\r\n"
        		+ "  </attendees>\r\n"
        		+ "\r\n"
        		+ "  <registrations>\r\n"
        		+ "    <registration session_id=\"201\" attendee_id=\"1001\"/>\r\n"
        		+ "    <registration session_id=\"202\" attendee_id=\"1002\"/>\r\n"
        		+ "  </registrations>\r\n"
        		+ "</conference>";

        // Crear un objeto Document a partir de la cadena XML
        Document document = parseXML(xmlString);

        // Crear un objeto XPath
        XPath xpath = XPathFactory.newInstance().newXPath();

        // Ejemplo de consulta XPath para obtener nombres de empleados
        String xpathExpression1 = "//bio/text()";
        NodeList nodeList1 = (NodeList) xpath.compile(xpathExpression1).evaluate(document, XPathConstants.NODESET);

        // Imprimir resultados
        System.out.println("Bio de los speakers:");
        for (int i = 0; i < nodeList1.getLength(); i++) {
            System.out.println(nodeList1.item(i).getTextContent());
        }
        
        String xpathExpression2 = "//speaker[@id='102']/name";
        NodeList nodeList2 = (NodeList) xpath.compile(xpathExpression2).evaluate(document, XPathConstants.NODESET);

        // Imprimir resultados
        for (int i = 0; i < nodeList2.getLength(); i++) {
            System.out.println("Nombre del speaker con id 102: " + nodeList2.item(i).getTextContent());
        }
        
        String xpathExpression3 = "//sessions/node()";
        NodeList nodeList3 = (NodeList) xpath.compile(xpathExpression3).evaluate(document, XPathConstants.NODESET);

        // Imprimir resultados
        System.out.println("Informacion de las sesiones:");
        for (int i = 0; i < nodeList3.getLength(); i++) {
            System.out.println(nodeList3.item(i).getTextContent());
        }
        String xpathExpression4 = "/conference/attendees/attendee/name";
        NodeList nodeList4 = (NodeList) xpath.compile(xpathExpression4).evaluate(document, XPathConstants.NODESET);

        // Imprimir resultados
        System.out.println("Nombre de los asistentes:");
        for (int i = 0; i < nodeList4.getLength(); i++) {
            System.out.println(nodeList4.item(i).getTextContent());
        }
        
        String xpathExpression5 = "//speaker[1]";
        NodeList nodeList5 = (NodeList) xpath.compile(xpathExpression5).evaluate(document, XPathConstants.NODESET);

        // Imprimir resultados
        for (int i = 0; i < nodeList5.getLength(); i++) {
            System.out.println("Informacion del primer speaker: " + nodeList5.item(i).getTextContent());
        }
        
        String xpathExpression6 = "//info/date/text()";
        NodeList nodeList6 = (NodeList) xpath.compile(xpathExpression6).evaluate(document, XPathConstants.NODESET);

        // Imprimir resultados
        for (int i = 0; i < nodeList6.getLength(); i++) {
            System.out.println("Fecha de la conferencia:" + nodeList6.item(i).getTextContent());
        }
        
        String xpathExpression7 = "//speaker[@id>101]/name";
        NodeList nodeList7 = (NodeList) xpath.compile(xpathExpression7).evaluate(document, XPathConstants.NODESET);

        // Imprimir resultados
        for (int i = 0; i < nodeList7.getLength(); i++) {
            System.out.println("Speakers id nayor que 101:" + nodeList7.item(i).getTextContent());
        }
        
        String xpathExpression8 = "/conference/sessions/session/title";
        NodeList nodeList8 = (NodeList) xpath.compile(xpathExpression8).evaluate(document, XPathConstants.NODESET);

        // Imprimir resultados
        System.out.println("Titulo de las sesiones:");
        for (int i = 0; i < nodeList8.getLength(); i++) {
            System.out.println(nodeList8.item(i).getTextContent());
        }
        
        String xpathExpression9 = "//speaker/*/text()";
        NodeList nodeList9 = (NodeList) xpath.compile(xpathExpression9).evaluate(document, XPathConstants.NODESET);

        // Imprimir resultados
        System.out.println("Speakers y su bio:");
        for (int i = 0; i < nodeList9.getLength(); i++) {
            System.out.println(nodeList9.item(i).getTextContent());
        }
        
        String xpathExpression10 = "//session/room";
        NodeList nodeList10 = (NodeList) xpath.compile(xpathExpression10).evaluate(document, XPathConstants.NODESET);

        // Imprimir resultados
        System.out.println("Salas de las conferencia:");
        for (int i = 0; i < nodeList10.getLength(); i++) {
            System.out.println(nodeList10.item(i).getTextContent());
        }
    }

    private static Document parseXML(String xmlString) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        return factory.newDocumentBuilder().parse(new InputSource(new StringReader(xmlString)));
    }
}
