package application;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class Request extends VBox{
	public Button allow=new Button("Allow"),deny=new Button("Deny");
	Label status=new Label();
	private Pane panel;
	public Request(String sts) {
		deny.getStyleClass().add("deny");
		allow.getStyleClass().add("allow");
		allow.setLayoutX(164);
		deny.setLayoutX(210);
		status.setText(sts);
		status.setFont(new Font("",18));
		panel=new Pane();
		getChildren().add(status);
		panel.getChildren().add(allow);
		panel.getChildren().add(deny);
		getChildren().add(panel);
		allow.setVisible(false);
		deny.setVisible(false);
	}
	
}
