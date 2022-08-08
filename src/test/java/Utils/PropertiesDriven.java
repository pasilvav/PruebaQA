package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesDriven {
    //Atributos
    private static Properties props;

    public static String getProperty(String key){
        //Instanciamos un objeto properties
        props = new Properties();

        //Definimos String con la ruta del fichero con las properties del proyecto
        //String rutaFile = "C:\\Users\\Domingo.Saavedra\\Downloads\\PageObjectModel_Demo_DataDriven\\src\\main\\resources\\properties.properties";
        String rutaFile = "C:\\TrabajoPOM_SilvaVergara2\\src\\main\\resources\\properties.properties";

        //Instentamos instanciar el fichero como un objeto de tipo file
        try {
            InputStream input = new FileInputStream(rutaFile);

            //Cargamos las properties del fichero
            props.load(input);

        } catch (Exception e) {
            e.printStackTrace();
        }

        //Retornamos una property en base a su key
        return props.getProperty(key);
    }

}
