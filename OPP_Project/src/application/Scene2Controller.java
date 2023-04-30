package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;
import javafx.stage.*;

public class Scene2Controller {
	
	private static ArrayList<Field> fields;
	
	int rowNumber;
	
	private double initialX = 15.0;
	
	private double initialY = 25.0;
	
	String filePath = ".\\datafiles\\Example3.xlsx";

	public void displayFields(String apiNames) throws IOException {
		
		String[] arrOfNames = apiNames.split(" ");
		
		for(int k = 0; k < (arrOfNames.length); k++) {

			Group root = new Group();
			Scene scene = new Scene(root, Color.ALICEBLUE);
			Stage stage = new Stage();
			
			stage.setTitle(arrOfNames[k]);
			
			rowNumber = ReadExcel.getRowNum(filePath, arrOfNames[k]);
			fields = ReadExcel.getFields(filePath, rowNumber);

			for(int i=0; i<fields.size(); i++){
					
				if(fields.get(i) instanceof Parent){
	                
					Parent parent = (Parent)fields.get(i);
					
				    Rectangle rectangle = new Rectangle(200, 150);
				    rectangle.setX(initialX + (i*215));
				    rectangle.setY(initialY);
				    rectangle.setFill(Color.WHITE);
				    rectangle.setStrokeWidth(3);
				    rectangle.setStroke(Color.BLACK);
				    rectangle.setArcWidth(30.0); 
				    rectangle.setArcHeight(20.0);
					
					Text parentLabel = new Text(parent.getName());
					parentLabel.setX(rectangle.getX() + 70);
					parentLabel.setY(rectangle.getY() - 10);
					Font font = Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 13);
					parentLabel.setFont(font);
					
		        	root.getChildren().addAll(rectangle, parentLabel);
			        
			        for(int m=0; m<parent.getFields().size(); m++){
			        	
			        	Text label = new Text(parent.getFields().get(m).getName());
			        	label.setX(rectangle.getX() + 10);
			        	label.setY(rectangle.getY() + parentLabel.getY() + 10 + (m*16));
			        	
			        	Text label2 = new Text(parent.getFields().get(m).getAllowedValue());
			        	label2.setX(rectangle.getX() + 80);
			        	label2.setY(label.getY());
			        	
			        	Text label3 = new Text(parent.getFields().get(m).getMandatory());
			        	label3.setX(rectangle.getX() + 160);
			        	label3.setY(label2.getY());
			        	
			        	root.getChildren().addAll(label, label2, label3);
			        }
				}
				
				else {
							        
			        Rectangle rectangle = new Rectangle(200, 150);
			        rectangle.setX(initialX + (i*215));
				    rectangle.setY(initialY);
				    rectangle.setFill(Color.WHITE);
				    rectangle.setStrokeWidth(3);
				    rectangle.setStroke(Color.BLACK);
				    rectangle.setArcWidth(30.0); 
				    rectangle.setArcHeight(20.0);
				    
				    Text parentLabel = new Text((fields.get(i).getName()));
			        parentLabel.setX(rectangle.getX() + 70);
					parentLabel.setY(rectangle.getY() - 10);
					Font font = Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 13);
					parentLabel.setFont(font);
			        
			        Text label2 = new Text(fields.get(i).getAllowedValue());
		        	label2.setX(parentLabel.getX());
		        	label2.setY(rectangle.getY() + parentLabel.getY() + 10);
			        
		        	Text label3 = new Text(fields.get(i).getMandatory());
		        	label3.setX(parentLabel.getX());
		        	label3.setY(label2.getY() + 30);
					
		        	root.getChildren().addAll(rectangle, parentLabel, label2, label3);
			   }
				
				if(i==7) break;
			}
				int j = 0;
				for(int i = 7; i<fields.size(); i++){
						
					if(fields.get(i) instanceof Parent){
			                
						Parent parent = (Parent)fields.get(i);
							
					    Rectangle rectangle = new Rectangle(200, 150);
					    rectangle.setX(initialX + (j*215));
					    rectangle.setY(210);
					    rectangle.setFill(Color.WHITE);
					    rectangle.setStrokeWidth(3);
					    rectangle.setStroke(Color.BLACK);
					    rectangle.setArcWidth(30.0); 
					    rectangle.setArcHeight(20.0);
							
						Text parentLabel = new Text(parent.getName());
						parentLabel.setX(rectangle.getX() + 70);
						parentLabel.setY(rectangle.getY() - 10);
						Font font = Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 13);
						parentLabel.setFont(font);
						
			        	root.getChildren().add(rectangle);
			        	root.getChildren().add(parentLabel);
					        
				        for(int m=0; m<parent.getFields().size(); m++){
					        	
				        	Text label = new Text(parent.getFields().get(m).getName());
				        	label.setX(rectangle.getX() + 10);
				        	label.setY(parentLabel.getY() + 35 + (m*16));
				        	
				        	Text label2 = new Text(parent.getFields().get(m).getAllowedValue());
				        	label2.setX(rectangle.getX() + 80);
				        	label2.setY(label.getY());
					        	
				        	Text label3 = new Text(parent.getFields().get(m).getMandatory());
				        	label3.setX(rectangle.getX() + 160);
				        	label3.setY(label2.getY());
					        	
				        	root.getChildren().add(label);
				        	root.getChildren().add(label2);
				        	root.getChildren().add(label3);
				        }
						}
					j++;
					}
				
				stage.setScene(scene);
				stage.show();	
		}
	}		
}
