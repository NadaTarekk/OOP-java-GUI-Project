module NEWoop {
	requires javafx.controls;
	requires org.apache.poi.ooxml;
	requires javafx.fxml;
	requires javafx.base;
	requires javafx.graphics;
	
	opens application to javafx.graphics, javafx.fxml;
}
