import net.sf.saxon.TransformerFactoryImpl;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class TransformadorXSLT {

    public static void main(String[] args) {
        try {
            // Rutas de los archivos XML y XSLT
            String xmlPath = "./ejemplo.xml";
            String xsltPath = "./transformacion.xslt";
            String outputPath = "./resultados.html";

            // Crear una fábrica de transformadores Saxon
            TransformerFactory transformerFactory = new TransformerFactoryImpl();

            // Crear un transformador a partir de la hoja de estilo XSLT
            Transformer transformer = transformerFactory.newTransformer(new StreamSource(new File(xsltPath)));

            // Especificar el archivo XML de entrada
            StreamSource inputXml = new StreamSource(new File(xmlPath));

            // Especificar el archivo de salida HTML
            StreamResult outputHtml = new StreamResult(new File(outputPath));

            // Realizar la transformación
            transformer.transform(inputXml, outputHtml);

            System.out.println("Transformación XML con XSLT completada con éxito.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
