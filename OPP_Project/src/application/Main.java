package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

import java.io.FileInputStream; 
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;


public class Main extends Application{
	
	@Override
	public void start(Stage stage) {
		try {
			
			javafx.scene.Parent root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		
		catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		launch(args);
	}
}
