package userInterface;

import java.io.IOException;

//import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import userInterface.PacManController;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
		PacManController pc = new PacManController();
		try {
			// pc.loadLevelFile("C:\\Users\\thetr\\Documents\\Segundo Semestre\\APO
			// II\\ECLIPSE\\Workspace\\catch-Pac-Man\\src\\data\\level0.txt", "\t");
			System.out.println("HOLA");
			String msg = pc.getLevel0(
					"C:\\Users\\thetr\\Documents\\Segundo Semestre\\APO II\\ECLIPSE\\Workspace\\catch-Pac-Man\\src\\data\\level0.txt");
			System.out.println(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}

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
		stage.show();
	}

}