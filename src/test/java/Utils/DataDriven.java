package Utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class DataDriven {
    public static ArrayList<String> getData(String nombreCP)  {

        ArrayList<String> a = new ArrayList<>();

        //instanciamos un objeto de tipo file con la ruta del excel
        FileInputStream file = null;
        try {
            file = new FileInputStream
                    (PropertiesDriven.getProperty("rutaExcel"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //instanciar un objeto de tipo excel en base al file
        XSSFWorkbook excel = null;
        try {
            excel = new XSSFWorkbook(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int sheets = excel.getNumberOfSheets();

        //System.out.println("Cantidad de hojas: "+ sheets);

        for(int i=0; i < sheets;i++){
            if(excel.getSheetName(i).equalsIgnoreCase(PropertiesDriven.getProperty("hojaExcel"))){
                //encontre la hoja
                XSSFSheet hojaExcel = excel.getSheetAt(i);

                Iterator<Row> filas = hojaExcel.iterator();

                Row fila = filas.next();

                Iterator<Cell> celda = fila.cellIterator();

                int k=0;
                int columna = 0;

                while(celda.hasNext()){
                    Cell celdaSeleccionada = celda.next();
                    //System.out.println(celdaSeleccionada.getStringCellValue());
                    if(celdaSeleccionada.getStringCellValue().equalsIgnoreCase(PropertiesDriven.getProperty("tituloCPs"))){
                        //identifique la celda con el titulo de la columna con los nombres de los CP's
                        columna = k;

                    }
                    k++;
                }

                while (filas.hasNext()){
                    Row r = filas.next();

                    if(r.getCell(columna).getStringCellValue().equalsIgnoreCase(nombreCP)){

                        Iterator<Cell> cv = r.cellIterator();

                        while(cv.hasNext()){
                            Cell cell =  cv.next();
                            if(cell.getCellType() == CellType.STRING){
                                //System.out.println(cell.getStringCellValue());
                                a.add(cell.getStringCellValue());
                            }else if (cell.getCellType() == CellType.NUMERIC){
                                //System.out.println(NumberToTextConverter.toText(cell.getNumericCellValue()));
                                a.add(NumberToTextConverter.toText(cell.getNumericCellValue()));
                            }
                        }
                    }
                }
            }
        }
        return a;
    }
}
