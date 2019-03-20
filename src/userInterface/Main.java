package userInterface;

import java.io.IOException;

import javax.swing.JOptionPane;

//import java.io.IOException;

//import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;
import threads.PacManThread;
import userInterface.PacManController;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
		System.out.println("Impresion Main");
	}

	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GameScreen.fxml"));
		Parent root = fxmlLoader.load();
		PacManController pmc = fxmlLoader.getController();
		pmc.setStage(stage);


		Scene scene = new Scene(root);
		stage.setTitle("Catch the Pac-Man!");
		stage.setScene(scene);
		stage.setMaximized(true);
		stage.show();
		
	}

}