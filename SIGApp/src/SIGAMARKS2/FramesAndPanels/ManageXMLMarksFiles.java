/*
 * http://www.vogella.com/articles/JavaXML/article.html
 * Agrega marcas al archivo XML 
 * 
 */
package SIGAMARKS2.FramesAndPanels;

//import sigamarks.persistence.objects.*;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.IOException;

/**
 * Clase manejadora de archivos XML crea un archivo si no existe con el nombre
 * original del archivo y la terminación .xml
 *
 * @author j3su5
 * @deprecated 
 */
public class ManageXMLMarksFiles {

    private String document;
    private File filePath;
    private File[] fileListXML;
  //  MarkItem markForDoc;
    private String path;

    /**
     * ManageXMLMarksFiles(String docName) recibe el nombre del archivo original
     * del que se genera o lee un archivo xml
     *
     * @param docName
     */
    public ManageXMLMarksFiles(String docName) {
        document = docName + ".xml";
        //path = "SIGAMARKS2\\XMLMarkFiles";
        path = "C:\\Users\\auditor\\JESUS\\SIGAMarks\\src\\SIGAMARKS2\\XMLMarkFiles\\" ;
        
        //C:\Users\auditor\JESUS\SIGAMarks\src\SIGAMARKS2\XMLMarkFiles    
        filePath = new File(path);//Almacena directorio
        if (filePath.exists()) {
            fileListXML = filePath.listFiles();//Arreglo de archivos en el path "src\\SIGAMARKS2\\ManageXMLMarksFiles\\" 
        } else {
            System.out.println("El directorio no existe");
            
        }
    }

    //Cambiar código referido a la clase MarkItem - XMLPageMArk - XMLDocumentPageData
    /**
     * Agregaa un objeto de página XMLPageMark un MarkItem
     *
     * @param page página donde se crea la marca
     * @param nameMark el nombre de la marca .png
     * @param posX posicion X en página
     * @param posY posicion Y en página
     * /
    void addMark(int page, String nameMark, int posX, int posY) {
        System.out.println("ManageXMLDocs - addMark ..... Agregando marca " + nameMark + " a archivo" + document + ".xml pagina:" + page + "....");
        XStream xstream = new XStream();//Objeto de la libreria XStream para manejo de XML
        markForDoc = new MarkItem(path, posX, posY, page);//Combierte los valores enteros a string 

    }
     */
    /**
     * Busca la existencia del XML de documento, si no existe lo crea Retorna
     * true si el archivo ya existe, sí no lo crea en blanco
     *
     * @return True si se ha creado False si no se ha creado
     * @throws IOException Relacionado al manejo de archivos en - createFile
     */
    boolean createXML() throws IOException {
        long numFiles;
        numFiles = fileListXML.length;
        boolean match = true;
        int i = 0;//inicializa la busqueda en el archivo cero
        //Busca la existencia del archivo, si no existe lo crea si existe solo
        //envia un mensaje por consola
        if (numFiles != 0) {
            while (!(i < numFiles) || !match) {//Busca en el arreglo de archivos 
                if (fileListXML[i].getName().equals(document)) {//si encuentra el archivo marca encontrado como true
                    match = true;
                }
                i++;
            }
            if (match) {//Si el archivo es encontrado no lo crea 
                System.out.println("ManageXMLDocs - createXML ..... Archivo ya existente ...");
            } else {//Si el archivo no existe lo crea con el nombre de archivo terminacion .xml
                createFile(path + document);
            }
        } else {//Si la carpeta contenedora no tiene ningun archivo crea el archivo del documento creado
            createFile(path + document);
        }
        return match;
    }

    /**
     * Crea un archivo concreto con la terminación .xml
     *
     * @param dirNameFile Directorio y nombre del archivo
     */
    void createFile(String dirNameFile) {
        File nFile = new File(dirNameFile);
        try {
            if (nFile.createNewFile()) {
                System.out.println("ManageXMLDocs - createFile ..... Archivo creado correctamente");//Crea un archivo en blanco 
            } else {
                System.out.println("ManageXMLDocs - createFile ..... Archvo no creado ... ");//Mensaje de error al no crear el archivo
            }
        } catch (IOException ioe) {
            System.out.println("ManageXMLDocs - createFile ..... Error ioe: " + ioe.getMessage());//Error exception encontrado
        }
    }

    public File getFilePath() {
        return filePath;
    }

    public void setFilePath(File filePath) {
        this.filePath = filePath;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
