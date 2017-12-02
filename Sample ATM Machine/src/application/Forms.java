package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Forms {
	protected void callForm (String resource) {
		try {
			Stage primaryStage = new Stage();
			Pane box = new Pane();
			Parent root = FXMLLoader.load(getClass().getResource(resource));
			Scene scene = new Scene(root,box.getPrefWidth(),box.getPrefHeight());
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
