import Classes.Carregamento;
import Classes.Fatura;
import Classes.Veiculo;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.*;

public class XMLHandler {
    public static String FILE_PATH = "src/main/resources/";
    public static String CLIENT_PATH = "src/main/resources/Cliente/";
    private static JAXBContext jaxbContext;

    public XMLHandler() {}

    // ------------------ //
    /** WRITE XML FILE **/
    public static void writeXML(Class xmlClass, Object obj, String filename) throws JAXBException, FileNotFoundException {
        // Create an JAXBContext object
        jaxbContext = JAXBContext.newInstance(xmlClass);

        // Criar um objeto FileOutputStream para escrever um novo arquivo XML
        OutputStream outStream = new FileOutputStream(filename);

        // Criar um objeto Marshaller para escrever um novo arquivo XML
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        // Configurar a saída do Marshaller para formatar o XML / Escrever um novo arquivo XML (cria um ficheiro XML)
        jaxbMarshaller.marshal(obj, outStream);
    }

    // ------------------ //
    /** READ XML FILE **/
    public static <T extends Serializable> T readXML(Class<T> xmlClass, String filename) throws JAXBException { // <T> is generic class
        // Create an JAXBContext object
        jaxbContext = JAXBContext.newInstance(xmlClass);

        // Criar um objeto Unmarshaller para ler o arquivo XML
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        // Ler o arquivo XML
        Object readXML = jaxbUnmarshaller.unmarshal(new File(filename)); // xml file name

        // Exibir os dados do arquivo XML
        //System.out.println("Dados: " + readXML.toString());

        return (T) readXML;
    }

    // ------------------ //
    /** VALIDATE XML FILE WITH XSD **/
    public static Boolean validateXML(Class xmlClass, String xmlFile, String xsdFile) {
        try {
            // Create an JAXBContext object
            jaxbContext = JAXBContext.newInstance(xmlClass);

            // Criar um objeto Unmarshaller para ler o arquivo XML
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            // Criar um objeto SchemaFactory para validar o arquivo XML
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

            // Ler o arquivo XSD de validação
            Schema xmlSchema = schemaFactory.newSchema(new File(xsdFile));
            jaxbUnmarshaller.setSchema(xmlSchema);

            // Criar um objeto Validator para validar o arquivo XML
            Validator validator = xmlSchema.newValidator();

            // Validar o arquivo XML
            validator.validate(new StreamSource(new File(xmlFile)));

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
