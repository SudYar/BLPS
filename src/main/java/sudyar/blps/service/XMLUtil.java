package sudyar.blps.service;


import com.thoughtworks.xstream.XStream;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Service;
import sudyar.blps.entity.User;


import java.io.*;
import java.net.URI;
import java.util.List;

@Service
public class XMLUtil {
    private final XStream xstream;
    public XMLUtil(){
        this.xstream = new XStream();
    }

    public <T> Object getEntity(Class<T> convertClass, String aliasName, URI xmlPath) {
        xstream.alias(aliasName, convertClass);
        try {
            File file = new File(xmlPath);
            if (!file.exists()) file.createNewFile();
            FileReader reader = new FileReader(file);
            if (reader.read() > 0) {
                JAXBContext jaxbContext = JAXBContext.newInstance(convertClass);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                return jaxbUnmarshaller.unmarshal(file);
            }
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void saveEntity(List<?> saveEntity, String xmlPath) {
        xstream.alias("user", User.class);
        xstream.alias("users", List.class);
        try {
            xstream.toXML(saveEntity, new FileWriter(xmlPath, false));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
