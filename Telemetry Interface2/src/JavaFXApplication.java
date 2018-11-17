import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class JavaFXApplication extends Application {

	public static void main(String[] args) {
		
		launch (args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("AOML IES Telemetry App");
		
		Pane root = FXMLLoader.load(getClass().getResource("/MainFrame.fxml"));
		
		Scene scene = new Scene (root, 1000, 800);
		
		primaryStage.setScene(scene);
		
		primaryStage.show();
		
	}
}
