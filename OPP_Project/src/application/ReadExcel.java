package application;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcel {
	
	public static int getRowNum(String excelFilePath, String searchValue) throws IOException {
		  
	FileInputStream inputStream = new FileInputStream(excelFilePath);
		
	XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		
	XSSFSheet sheet = workbook.getSheetAt(0);
		 
	int rowNum = 0;
	String cellValue = "";
		 
	for (Row row : sheet) {
	  for (Cell cell : row) {
	   cellValue = cell.getStringCellValue();
	    
	   if (cellValue.contains(searchValue)) {
		   rowNum = (cell.getRowIndex() + 3);
		   break;
	   }
	  }
	}
		 
	Row row;
	Cell cell;
		 
	for(int i = rowNum; i < sheet.getLastRowNum(); i++) {
			 
		row = sheet.getRow(i);
				 
		if(row == null) {
			
			row = sheet.createRow(i);
		}
				 
		cell = row.getCell(0);
				 
		if(cell == null) {
			
			rowNum++;
		}
			 
		if(cell != null) {
			
			rowNum = cell.getRowIndex();
			break;
		}
	}
		 
	return (rowNum + 1);
	}
	
	public static ArrayList<Field> getFields(String excelFilePath, int rowNum) throws IOException{
        ArrayList<Parent> Parents = new ArrayList<>();
        ArrayList<Field> Fields = new ArrayList<>();
        ArrayList<Field> ApiFields =new ArrayList<>();
        Api api = new Api();
        
       FileInputStream fis=new FileInputStream(excelFilePath);  
       XSSFWorkbook wb = new XSSFWorkbook(fis);
       XSSFSheet sheet=wb.getSheetAt(0); 
       int rows = sheet.getLastRowNum(); 
       int cols =sheet.getRow(rowNum).getLastCellNum(); 
       for(int r = rowNum; r<=rows; r++){
    	   
    	   XSSFRow row=sheet.getRow(r);
    	   if (row == null) break;
    	   XSSFCell x = row.getCell(2);
    	   String s = x.getStringCellValue();
    	   
    	   if(s.substring(0,6).equals("object")){
    		   Parent parent = new Parent();
    		   
    		   for(int c=0;c<cols;c++) {
    			   
    			   XSSFCell cell= row.getCell(c);
    			   switch(c) {
                                   case 0: parent.setInOut(cell.getStringCellValue()); break;
                                   case 1: parent.setName(cell.getStringCellValue()); break;
                                   case 3:
                                        if(cell.getStringCellValue().equals("")){
                                             parent.setAllowedValue("All Values"); } 
                                       
                                        else if(!(cell.getStringCellValue().equals("")))
                                                {
                                        parent.setAllowedValue(cell.getStringCellValue());   }
                                        break;
                                   case 4: parent.setMandatory(cell.getStringCellValue()); break;
				 
                                               }
                                     }
                       Parents.add(parent);
                       
                               }
                else if(s.equals("string")){
                   Field field = new Field();
                       for(int c=0;c<cols;c++) { 
                               XSSFCell cell= row.getCell(c);
				 switch(c) {
                                  case 0: field.setInOut(cell.getStringCellValue()); break;
                                   case 1: field.setName(cell.getStringCellValue()); break;
                                   case 3:
                                        if(cell.getStringCellValue().equals("")){
                                             field.setAllowedValue("All Values"); } 
                                       
                                        else if(!(cell.getStringCellValue().equals("")))
                                                {
                                        field.setAllowedValue(cell.getStringCellValue());   }
                                        break;
                                   case 4: field.setMandatory(cell.getStringCellValue()); break;
                                               }
                                     }
                       Fields.add(field);
                              }
                                 
				}
        
         for(int i=0;i<Fields.size();i++){
         for(int m=0;m<Parents.size();m++){
            String s = Fields.get(i).getName().split("/")[Fields.get(i).getName().split("/").length-2];
             String q =Parents.get(m).getName().substring(Parents.get(m).getName().lastIndexOf('/') +1);
             if(s.equals(q)){
             Parents.get(m).getFields().add(Fields.get(i));
              break;}
            
           }
          }
          for(int m=0;m<Parents.size();m++){
               for(int n=0;n<Parents.size();n++){
                    String s = Parents.get(n).getName().split("/")[Parents.get(n).getName().split("/").length-2];
                   String q =Parents.get(m).getName().substring(Parents.get(m).getName().lastIndexOf('/') +1);
                   
                   if(s.equals(q)){
             Parents.get(m).getFields().add(Parents.get(n));
             }
                   
                   
           }
               
                   
               }
           
          for(int i=0;i<Fields.size();i++){
              String q =Fields.get(i).getName().split("/")[Fields.get(i).getName().split("/").length-2];
              if(q.equals(""))
                  ApiFields.add(Fields.get(i));
                  
          
          }
          for(int i=0;i<Fields.size();i++){
              Fields.get(i).setName(Fields.get(i).getName().substring(Fields.get(i).getName().lastIndexOf('/') +1));
           }
          for(int m=0;m<Parents.size();m++){
            Parents.get(m).setName(Parents.get(m).getName().substring(Parents.get(m).getName().lastIndexOf('/') +1));
          }
           for(int m=0;m<Parents.size();m++){
          ApiFields.add(Parents.get(m));
           }
           
          return ApiFields;
    }
}