import java.io.StringReader;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XPathEjercicio3 {

	public static void main(String[] args) throws Exception {
		// Tu documento XML como una cadena
		String xmlString = "<online_store>\r\n" + "  <categories>\r\n"
				+ "    <category id=\"1\" name=\"Electronics\">\r\n" + "      <product id=\"101\">\r\n"
				+ "        <name>Laptop</name>\r\n" + "        <brand>Dell</brand>\r\n"
				+ "        <price>899.99</price>\r\n" + "        <stock>50</stock>\r\n" + "      </product>\r\n"
				+ "      <product id=\"102\">\r\n" + "        <name>Smartphone</name>\r\n"
				+ "        <brand>iPhone</brand>\r\n" + "        <price>699.99</price>\r\n"
				+ "        <stock>100</stock>\r\n" + "      </product>\r\n" + "    </category>\r\n" + "    \r\n"
				+ "    <category id=\"2\" name=\"Books\">\r\n" + "      <product id=\"201\">\r\n"
				+ "        <name>The Catcher in the Rye</name>\r\n" + "        <author>J.D. Salinger</author>\r\n"
				+ "        <price>14.99</price>\r\n" + "        <stock>30</stock>\r\n" + "      </product>\r\n"
				+ "      <product id=\"202\">\r\n" + "        <name>Programming Python</name>\r\n"
				+ "        <author>Mark Lutz</author>\r\n" + "        <price>29.99</price>\r\n"
				+ "        <stock>20</stock>\r\n" + "      </product>\r\n" + "    </category>\r\n"
				+ "  </categories>\r\n" + "\r\n" + "  <customers>\r\n" + "    <customer id=\"1001\">\r\n"
				+ "      <name>Alice Johnson</name>\r\n" + "      <email>alice@email.com</email>\r\n"
				+ "      <address>\r\n" + "        <street>Main Street</street>\r\n"
				+ "        <city>New York</city>\r\n" + "        <zip>10001</zip>\r\n" + "      </address>\r\n"
				+ "    </customer>\r\n" + "    <customer id=\"1002\">\r\n" + "      <name>Bob Smith</name>\r\n"
				+ "      <email>bob@email.com</email>\r\n" + "      <address>\r\n"
				+ "        <street>Oak Avenue</street>\r\n" + "        <city>Los Angeles</city>\r\n"
				+ "        <zip>90001</zip>\r\n" + "      </address>\r\n" + "    </customer>\r\n" + "  </customers>\r\n"
				+ "\r\n" + "  <orders>\r\n" + "    <order id=\"5001\" customer_id=\"1001\" date=\"2024-03-06\">\r\n"
				+ "      <item product_id=\"101\" quantity=\"2\"/>\r\n"
				+ "      <item product_id=\"202\" quantity=\"1\"/>\r\n" + "    </order>\r\n"
				+ "    <order id=\"5002\" customer_id=\"1002\" date=\"2024-03-07\">\r\n"
				+ "      <item product_id=\"201\" quantity=\"3\"/>\r\n" + "    </order>\r\n" + "  </orders>\r\n"
				+ "</online_store>";

		// Crear un objeto Document a partir de la cadena XML
		Document document = parseXML(xmlString);

		// Crear un objeto XPath
		XPath xpath = XPathFactory.newInstance().newXPath();
		// Ejemplo de consulta XPath para obtener los nombres de los productos de la
		// categoría Electronics
		String xpathExpression1 = "/online_store/categories/category[@name='Electronics']/product/name";
		NodeList nodeList1 = (NodeList) xpath.compile(xpathExpression1).evaluate(document, XPathConstants.NODESET);

		// Imprimir resultados
		System.out.println("Nombres de los productos de la categoría Electronics:");
		for (int i = 0; i < nodeList1.getLength(); i++) {
			System.out.println("Nombre: " + nodeList1.item(i).getTextContent());
		}

		// Ejemplo de consulta XPath para obtener los correos electrónicos de todos los
		// clientes
		String xpathExpression2 = "/online_store/customers/customer/email";
		NodeList nodeList2 = (NodeList) xpath.compile(xpathExpression2).evaluate(document, XPathConstants.NODESET);

		// Imprimir resultados
		System.out.println("\nCorreos electrónicos de todos los clientes:");
		for (int i = 0; i < nodeList2.getLength(); i++) {
			System.out.println("Correo electrónico: " + nodeList2.item(i).getTextContent());
		}

		// Ejemplo de consulta XPath para obtener los nombres de los productos con
		// precio mayor a $20
		String xpathExpression3 = "/online_store/categories/category/product[price > 20]/name";
		NodeList nodeList3 = (NodeList) xpath.compile(xpathExpression3).evaluate(document, XPathConstants.NODESET);

		// Imprimir resultados
		System.out.println("\nNombres de los productos con precio mayor a $20:");
		for (int i = 0; i < nodeList3.getLength(); i++) {
			System.out.println("Nombre: " + nodeList3.item(i).getTextContent());
		}

		// Ejemplo de consulta XPath para obtener los nombres de los clientes con
		// dirección en New York
		String xpathExpression4 = "/online_store/customers/customer[address/city='New York']/name";
		NodeList nodeList4 = (NodeList) xpath.compile(xpathExpression4).evaluate(document, XPathConstants.NODESET);

		// Imprimir resultados
		System.out.println("\nNombres de los clientes con dirección en New York:");
		for (int i = 0; i < nodeList4.getLength(); i++) {
			System.out.println("Nombre: " + nodeList4.item(i).getTextContent());
		}

		// Ejemplo de consulta XPath para obtener los nombres de los productos ordenados
		// por precio de menor a mayor
		String xpathExpression5 = "/online_store/categories/category/product/price";
		NodeList nodeList5 = (NodeList) xpath.compile(xpathExpression5).evaluate(document, XPathConstants.NODESET);

		// Imprimir resultados
		System.out.println("\nPrecios de los productos ordenados de menor a mayor:");
		for (int i = 0; i < nodeList5.getLength(); i++) {
			System.out.println("Precio: " + nodeList5.item(i).getTextContent());
		}

		// Ejemplo de consulta XPath para obtener el nombre del cliente que realizó la
		// orden con id 5001
		String xpathExpression6 = "/online_store/orders/order[@id='5001']/@customer_id";
		String customerId = (String) xpath.compile(xpathExpression6).evaluate(document, XPathConstants.STRING);

		// Imprimir resultados
		System.out.println("\nID del cliente que realizó la orden con ID 5001: " + customerId);

		// Ejemplo de consulta XPath para obtener los nombres de los productos con stock
		// menor a 50 unidades
		String xpathExpression7 = "/online_store/categories/category/product[stock < 50]/name";
		NodeList nodeList7 = (NodeList) xpath.compile(xpathExpression7).evaluate(document, XPathConstants.NODESET);

		// Imprimir resultados
		System.out.println("\nNombres de los productos con stock menor a 50 unidades:");
		for (int i = 0; i < nodeList7.getLength(); i++) {
			System.out.println("Nombre: " + nodeList7.item(i).getTextContent());
		}

		// Ejemplo de consulta XPath para obtener la cantidad total de productos en
		// stock
		String xpathExpression8 = "sum(/online_store/categories/category/product/stock)";
		Double totalStock = (Double) xpath.compile(xpathExpression8).evaluate(document, XPathConstants.NUMBER);

		// Imprimir resultados
		System.out.println("\nCantidad total de productos en stock: " + totalStock.intValue());

		// Ejemplo de consulta XPath para obtener los nombres de los productos ordenados
		// por nombre de la categoría
		String xpathExpression9 = "/online_store/categories/category/product/order-by(name)";
		NodeList nodeList9 = (NodeList) xpath.compile(xpathExpression9).evaluate(document, XPathConstants.NODESET);

		// Imprimir resultados
		System.out.println("\nNombres de los productos ordenados por nombre de categoría:");
		for (int i = 0; i < nodeList9.getLength(); i++) {
			System.out.println("Nombre: " + nodeList9.item(i).getTextContent());
		}

		// Ejemplo de consulta XPath para obtener la fecha de la orden con el ID 5002
		String xpathExpression10 = "/online_store/orders/order[@id='5002']/@date";
		String orderDate = (String) xpath.compile(xpathExpression10).evaluate(document, XPathConstants.STRING);

		// Imprimir resultados
		System.out.println("\nFecha de la orden con ID 5002: " + orderDate);
	}

	private static Document parseXML(String xmlString) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		return factory.newDocumentBuilder().parse(new InputSource(new StringReader(xmlString)));
	}
}
