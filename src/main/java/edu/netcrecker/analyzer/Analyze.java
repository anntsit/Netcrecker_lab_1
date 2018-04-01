package edu.netcrecker.analyzer;

import edu.netcrecker.fillers.Fillers;
import edu.netcrecker.fillers.Generic;
import edu.netcrecker.sorters.BubbleSort;
import edu.netcrecker.sorters.Sort;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Set;

/**
 * @author Tsytovtseva
 */
public class Analyze {
    public static void main(String[] args) throws NoSuchMethodException, IOException, InvocationTargetException, IllegalAccessException, InstantiationException {
        // Get Set with Classes extends Sort
        Reflections ref = new Reflections("sorters");
        Set<Class<? extends Sort>> sorters = ref.getSubTypesOf(Sort.class);
        sorters.remove(BubbleSort.class);

        // Get Set with Methods annotated @Fillers
        ref = new Reflections("fillers", new MethodAnnotationsScanner());
        Set<Method> fillers = ref.getMethodsAnnotatedWith(Fillers.class);

        HSSFWorkbook book = new HSSFWorkbook();

        for (Method filler : fillers) {
            //Create sheet and title
            System.out.println(filler.getName());
            HSSFSheet sheet = book.createSheet(filler.getName());
            HSSFRow rowTitle = sheet.createRow(0);
            rowTitle.createCell(0).setCellValue("type/dimension");
            for(int i=1, length = 16; length < 10000; i++, length*=2) {
                rowTitle.createCell(i).setCellValue(Integer.toString(length));
            }
            getDataFromSorters(sorters, sheet, filler);
        }
        System.out.println("We have sorted all data");

        if(saveFile(book)) System.out.println("The file is saved successfully");
    }

    public static void getDataFromSorters(Set<Class<? extends Sort>> sorters, HSSFSheet sheet, Method filler) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException{
        int numberRow = 1;
        for(Class sorter: sorters){
            System.out.println(sorter.getName());
            System.out.println("Start processing...");
            HSSFRow row = sheet.createRow(numberRow);
            row.createCell(0).setCellValue(sorter.getName());
            numberRow++;
            // Get method sort from sorter(Class extends Sort)
            ArrayList<Integer> a = new ArrayList<>();
            Class[] paramTypes = new Class[]{a.getClass()};
            Method sort = sorter.getMethod("sort", paramTypes);
            for (int length = 16, numberCell = 1; length <10011; length*=2, numberCell++){
                long startTime = System.currentTimeMillis();
                for (int i = 0; i<1000; i++){
                    // Generating new array with length and sorting it
                    ArrayList<Integer> array =(ArrayList<Integer>) filler.invoke(new Generic() , new Object[]{new Integer(length)});
                    //Sorting an array
                    sort.invoke(sorter.newInstance(), new Object[]{array});
                }

                long timeSpent = System.currentTimeMillis() - startTime;
                System.out.println("You did it for " + timeSpent + " ms");
                row.createCell(numberCell).setCellValue(Long.toString(timeSpent));
            }
        }
    }

    public static boolean saveFile(HSSFWorkbook book) throws IOException{
        FileOutputStream outFile = new FileOutputStream("src/excel/analysis.xls");
        book.write(outFile);
        book.close();
        outFile.close();
        return true;
    }
}
