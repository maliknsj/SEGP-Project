package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class HomeBar extends VBox{

	public HomeBar() {
		Label status=new Label("2 approval requests are pending!");
		HBox box=new HBox();
		status.getStyleClass().add("mybar-label");
		box.getChildren().add(status);
		box.setAlignment(Pos.BASELINE_LEFT);
		box.setPadding(new Insets(60,12,12,50));
		getChildren().add(box);
	}

}
