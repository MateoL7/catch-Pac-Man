package userInterface;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GameScreen.fxml"));
		Parent root = fxmlLoader.load();
		PacManController pc = fxmlLoader.getController();
		pc.setStage(stage);
		


		Scene scene = new Scene(root);
		stage.setTitle("Catch the Pac-Man!");
		stage.setScene(scene);
		stage.setMaximized(true);
		stage.show();
		
	}

}