import java.io.StringReader;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XPathEjercicio5 {

    public static void main(String[] args) throws Exception {
        // Tu documento XML como una cadena
        String xmlString = "<movie_database>\r\n"
        		+ "  <movies>\r\n"
        		+ "    <movie id=\"101\">\r\n"
        		+ "      <title>The Shawshank Redemption</title>\r\n"
        		+ "      <director>Frank Darabont</director>\r\n"
        		+ "      <release_date>1994-09-23</release_date>\r\n"
        		+ "      <genre>drama</genre>\r\n"
        		+ "      <actors>\r\n"
        		+ "        <actor>Tim Robbins</actor>\r\n"
        		+ "        <actor>Morgan Freeman</actor>\r\n"
        		+ "      </actors>\r\n"
        		+ "    </movie>\r\n"
        		+ "    <movie id=\"102\">\r\n"
        		+ "      <title>Inception</title>\r\n"
        		+ "      <director>Christopher Nolan</director>\r\n"
        		+ "      <release_date>2010-07-16</release_date>\r\n"
        		+ "      <genre>sci-fi</genre>\r\n"
        		+ "      <actors>\r\n"
        		+ "        <actor>Leonardo DiCaprio</actor>\r\n"
        		+ "        <actor>Joseph Gordon-Levitt</actor>\r\n"
        		+ "        <actor>Ellen Page</actor>\r\n"
        		+ "      </actors>\r\n"
        		+ "    </movie>\r\n"
        		+ "    <!-- More movie entries go here -->\r\n"
        		+ "  </movies>\r\n"
        		+ "\r\n"
        		+ "  <actors>\r\n"
        		+ "    <actor id=\"201\">\r\n"
        		+ "      <name>Tim Robbins</name>\r\n"
        		+ "      <birth_date>1958-10-16</birth_date>\r\n"
        		+ "      <nationality>American</nationality>\r\n"
        		+ "    </actor>\r\n"
        		+ "    <actor id=\"202\">\r\n"
        		+ "      <name>Morgan Freeman</name>\r\n"
        		+ "      <birth_date>1937-06-01</birth_date>\r\n"
        		+ "      <nationality>American</nationality>\r\n"
        		+ "    </actor>\r\n"
        		+ "    <!-- More actor entries go here -->\r\n"
        		+ "  </actors>\r\n"
        		+ "\r\n"
        		+ "  <directors>\r\n"
        		+ "    <director id=\"301\">\r\n"
        		+ "      <name>Frank Darabont</name>\r\n"
        		+ "      <birth_date>1959-01-28</birth_date>\r\n"
        		+ "      <nationality>Hungarian-American</nationality>\r\n"
        		+ "    </director>\r\n"
        		+ "    <director id=\"302\">\r\n"
        		+ "      <name>Christopher Nolan</name>\r\n"
        		+ "      <birth_date>1970-07-30</birth_date>\r\n"
        		+ "      <nationality>British-American</nationality>\r\n"
        		+ "    </director>\r\n"
        		+ "    <!-- More director entries go here -->\r\n"
        		+ "  </directors>\r\n"
        		+ "</movie_database>";

        // Crear un objeto Document a partir de la cadena XML
        Document document = parseXML(xmlString);

        // Crear un objeto XPath
        XPath xpath = XPathFactory.newInstance().newXPath();

        // Ejemplo de consulta XPath para obtener nombres de empleados
        String xpathExpression1 = "//movie/title";
        NodeList nodeList1 = (NodeList) xpath.compile(xpathExpression1).evaluate(document, XPathConstants.NODESET);

        // Imprimir resultados
        System.out.println("Peliculas:");
        for (int i = 0; i < nodeList1.getLength(); i++) {
            System.out.println(nodeList1.item(i).getTextContent());
        }
        
        String xpathExpression2 = "//movie[title='Inception']/actors/actor";
        NodeList nodeList2 = (NodeList) xpath.compile(xpathExpression2).evaluate(document, XPathConstants.NODESET);

        // Imprimir resultados
        System.out.println("Actores de la pelicula Inception:");
        for (int i = 0; i < nodeList2.getLength(); i++) {
            System.out.println(nodeList2.item(i).getTextContent());
        }
        
        String xpathExpression3 = "//movie[1]/title";
        NodeList nodeList3 = (NodeList) xpath.compile(xpathExpression3).evaluate(document, XPathConstants.NODESET);

        // Imprimir resultados
        for (int i = 0; i < nodeList3.getLength(); i++) {
            System.out.println("Priemra pelicula: " + nodeList3.item(i).getTextContent());
        }
        String xpathExpression4 = "//actors/actor/name";
        NodeList nodeList4 = (NodeList) xpath.compile(xpathExpression4).evaluate(document, XPathConstants.NODESET);

        // Imprimir resultados
        System.out.println("Actores:");
        for (int i = 0; i < nodeList4.getLength(); i++) {
            System.out.println(nodeList4.item(i).getTextContent());
        }
        
        String xpathExpression5 = "//actor[nationality='American']";
        NodeList nodeList5 = (NodeList) xpath.compile(xpathExpression5).evaluate(document, XPathConstants.NODESET);

        // Imprimir resultados
        System.out.println("Actores Americanos:");
        for (int i = 0; i < nodeList5.getLength(); i++) {
            System.out.println(nodeList5.item(i).getTextContent());
        }
        
        String xpathExpression6 = "//director/name";
        NodeList nodeList6 = (NodeList) xpath.compile(xpathExpression6).evaluate(document, XPathConstants.NODESET);

        // Imprimir resultados
        System.out.println("Directores: ");
        for (int i = 0; i < nodeList6.getLength(); i++) {
            System.out.println(nodeList6.item(i).getTextContent());
        }
        
        String xpathExpression7 = "//actor[birth_date='1937-06-01']/name";
        NodeList nodeList7 = (NodeList) xpath.compile(xpathExpression7).evaluate(document, XPathConstants.NODESET);

        // Imprimir resultados
        System.out.println("Actores nacido en 1937-06-01:");
        for (int i = 0; i < nodeList7.getLength(); i++) {
            System.out.println(nodeList7.item(i).getTextContent());
        }
        
        String xpathExpression8 = "//movie[@id>100]/title";
        NodeList nodeList8 = (NodeList) xpath.compile(xpathExpression8).evaluate(document, XPathConstants.NODESET);

        // Imprimir resultados
        System.out.println("Peliculas con id mayor a 100:");
        for (int i = 0; i < nodeList8.getLength(); i++) {
            System.out.println(nodeList8.item(i).getTextContent());
        }
        
        String xpathExpression9 = "//movie/actors";
        NodeList nodeList9 = (NodeList) xpath.compile(xpathExpression9).evaluate(document, XPathConstants.NODESET);

        // Imprimir resultados
        System.out.println("Actores de las peliculas:");
        for (int i = 0; i < nodeList9.getLength(); i++) {
            System.out.println(nodeList9.item(i).getTextContent());
        }
        
        String xpathExpression10 = "//actors/actor[last()]";
        NodeList nodeList10 = (NodeList) xpath.compile(xpathExpression10).evaluate(document, XPathConstants.NODESET);

        // Imprimir resultados
        for (int i = 0; i < nodeList10.getLength(); i++) {
            System.out.println("Ultimo actor:" + nodeList10.item(i).getTextContent());
        }
    }

    private static Document parseXML(String xmlString) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        return factory.newDocumentBuilder().parse(new InputSource(new StringReader(xmlString)));
    }
}
