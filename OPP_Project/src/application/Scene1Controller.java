package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Scene1Controller {
	
	@FXML
	private AnchorPane myBG;
	
	@FXML
	private Label myLabel;
	
	@FXML
	private TextField myTextField;
	
	@FXML
	private Button myButton;
	
	@FXML
	private javafx.scene.Parent root;
	private Stage stage;
	private Scene scene;
	
	public void Start(ActionEvent event) throws IOException {
					
		String apiNames = myTextField.getText();
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene2.fxml"));
		root = loader.load();
		
		Scene2Controller scene2Controller = loader.getController();
		scene2Controller.displayFields(apiNames);
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		//stage.setScene(scene);
		//stage.show();
	}
}
