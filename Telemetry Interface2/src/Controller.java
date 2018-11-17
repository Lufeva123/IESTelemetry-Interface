import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Paint;
import javafx.util.Duration;

/**
 * Controller for all the fxml documents.
 * @author Luiz Valle
 *
 */
public class Controller {

	//Main Frame controllers
	@FXML
	private MenuItem exitItem;
	
	//Data Page controllers
	@FXML
	private Button sendbtn;
	
	@FXML
	private ComboBox<Integer> transmitCodebox = new ComboBox <>();
	
	@FXML
	private Label transmitCodeLabel;
	
	@FXML
	private Button pingbtn; 
	
	@FXML
	private TextField MSB_LSBMarkerfield;
	
	@FXML
	private TextArea rawDataTextArea;
	
	@FXML
	private TextArea convertedDataTextArea;
	
	@FXML
	private TextArea notesTextArea;
	
	@FXML
	private Label MSBCounterLabel;
	
	@FXML
	private Label dectionProgresBarLabel;
	
	@FXML
	private Label GMTshowLabel = new Label ();
	
	@FXML
	private Label nextMarkerLabel;
	
	@FXML
	private Label nextMarkerCounterLabel;
	
	//Configuration Page controllers
	@FXML
	private Button browsebtn;
	
	@FXML
	private TextField saveFileLocationTextField;
	
	@FXML
	private ComboBox<String> deckUnitbox;
	
	@FXML
	private ComboBox<String> portbox;
	
	@FXML
	private ComboBox<Integer> speedbox;
	
	@FXML
	private ComboBox<String> paritytbox;
	
	@FXML
	private ComboBox<Integer> bitsbox;
	
	@FXML
	private ComboBox<Integer> stopbox;
	
	@FXML
	private ComboBox<String> flCtrlbox;
	
	@FXML
	private Button connectbtn;
	
	@FXML
	private Button disconnectbtn;
	
	@FXML
	private ComboBox<String> typebox;
	
	@FXML
	private ComboBox<String> modelbox;
	
	@FXML
	private ComboBox<String> firmwarebox;
	
	@FXML
	private TextField serialNumberTextField;
	
	@FXML
	private ComboBox<Double> pressurebox;
	
	@FXML
	private ComboBox<Double> taubox;
	
	@FXML
	private ComboBox<Double> yearDaybox;
	
	@FXML
	private ComboBox<Double> speedMeasurementbox;
	
	@FXML
	private ComboBox<Double> headbox;
	
	@FXML
	private ComboBox<Double> periodbox;
	
	@FXML
	private Button changeFreqsbtn;
	
	@FXML
	private ComboBox<Integer> gainbox;
	
	@FXML
	private ComboBox<Integer> rxPulseWidthbox;
	
	@FXML
	private ComboBox<Integer> rxThresholdbox;
	
	@FXML
	private Button setRxThresholdbtn;
	
	@FXML
	private ComboBox<Integer> tenKHzSensitivitybox;
	
	@FXML
	private Button set10KHzSensitivitybtn;
	
	@FXML
	private ComboBox<Integer> ten_fiveKHzSensitivitybox;
	
	@FXML
	private Button set10_5KHzSensitivitybtn;
	
	@FXML
	private ComboBox<Integer> elevenKHzSensitivitybox;
	
	@FXML
	private Button set11KHzSensitivitybtn;
	
	@FXML
	private ComboBox<Integer> eleven_fiveKHzSensitivitybox;
	
	@FXML
	private Button set11_5KHzSensitivitybtn;
	
	@FXML
	private ComboBox<Integer> twelveKHzSensitivitybox;
	
	@FXML
	private Button set12KHzSensitivitybtn;
	
	@FXML
	private ComboBox<Integer> twelve_fiveKHzSensitivitybox;
	
	@FXML
	private Button set12_5KHzSensitivitybtn;
	
	@FXML
	private ComboBox<Integer> thirteenKHzSesnitivitybox;
	
	@FXML
	private Button set13KHzSensitivitybtn;
	
	@FXML
	private Button clearDataLoggerbtn;
	
	@FXML
	private Button configureDeckBoxbtn;
	
	private Date date = new Date ();
	
	private SimpleDateFormat format = new SimpleDateFormat("EEE, MMM d, yyyy hh:mm:ss");
	
	/**
	 * Executed when this class is first called when the program starts, this method is used for UI initialization code.
	 */
	public <T> void initialize () throws Exception{
			
		transmitCodebox.valueProperty().addListener((options, oldValue, newValue) -> {
		
			Integer value = (Integer) newValue;
			
				 if (value <= 63){
				
					transmitCodeLabel.textProperty().set("RELEASE");
					transmitCodeLabel.setBackground(new Background (new BackgroundFill(Paint.valueOf("#ff4500"), CornerRadii.EMPTY, Insets.EMPTY)));
					 
				} else if (value > 63 && value <= 67){
				
					transmitCodeLabel.textProperty().set("TELEM");
					transmitCodeLabel.setBackground(new Background (new BackgroundFill(Paint.valueOf("#00ff00"), CornerRadii.EMPTY, Insets.EMPTY)));
					
				} else if (value > 67 && value <= 71){
					
					transmitCodeLabel.textProperty().set("XPND");
					transmitCodeLabel.setBackground(new Background (new BackgroundFill(Paint.valueOf("#ffa500"), CornerRadii.EMPTY, Insets.EMPTY)));
					
				} else if (value > 71 && value <= 75){
					
					transmitCodeLabel.textProperty().set("BEACON");
					transmitCodeLabel.setBackground(new Background (new BackgroundFill(Paint.valueOf("#ffff00"), CornerRadii.EMPTY, Insets.EMPTY)));
					
				} else if (value == 76){
					
					transmitCodeLabel.textProperty().set("CLEAR");
					transmitCodeLabel.setBackground(new Background (new BackgroundFill(Paint.valueOf("#00ff00"), CornerRadii.EMPTY, Insets.EMPTY)));
					
				}
		});
		
	}
	
	/**
	 * Called when the button "Send" is pressed on the Data Page of the UI.
	 */
	public void send (){
		
	}
	
	/**
	 * Called when the button "Ping" is pressed on the Data Page of the UI.
	 */
	public void ping (){
		
	}
	
	/**
	 * Called when the button "Browse" is pressed on the Configuration Page of the UI.
	 */
	public void browse (){
		
	}
	
	/**
	 * Called when the button "Connect" is pressed on the Configuration Page of the UI.
	 */
	public void connect (){
		
	}
	
	/**
	 * Called when the button "Disconnect" is pressed on the Configuration Page of the UI.
	 */
	public void disconnect(){
		
	}
	
	/**
	 * Called when the button "Change Freqs" is pressed on the Configuration Page of the UI.
	 */
	public void changeFreqs (){
		
	}
	
	/**
	 * Called when the button "Clear Data Logger" is pressed on the Configuration Page of the UI.
	 */
	public void clearDataLogger (){
		
		
	}
	
	/**
	 * Called when the button "Configure Deck Box" is pressed on the Configuration Page of the UI.
	 */
	public void configureDeckBox (){
		
	}
	
	/**
	 * Called when the the exit option on the file menu is called.
	 */
	public void exit (){
		
		Platform.exit();
	}
	
	public void showAboutDialog (){
		
		Alert dialog = new Alert (AlertType.INFORMATION);
		dialog.setTitle("About: AOML IES Telemetry App 2013.02.07");
		dialog.setHeaderText("AOML IES Telemetry App");
		dialog.setContentText("A simple java desktop application for IES telemetry\n"
				+ "\nProduct Version: 2013.02.27"
				+ "\nVendor: AOML"
				+ "\nHomepage: http://aoml.noaa.gov"
				+ "\nAuthor: Pedro Pena");
		DialogPane dialogPane = dialog.getDialogPane();
		dialogPane.getStylesheets().add(getClass().getResource("Styles.css").toExternalForm());
		dialogPane.getStyleClass().add("aboutDialog");
		dialog.showAndWait();
	}
	
	public void bindTime (){
		
		format.setTimeZone(TimeZone.getTimeZone("GMT"));
		Timeline time = new Timeline(new KeyFrame(Duration.seconds(0), event -> GMTshowLabel.setText(format.format(date))), new KeyFrame(Duration.seconds(1)));
		time.setCycleCount(Animation.INDEFINITE);
		time.play();
	}
	
}
