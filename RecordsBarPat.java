/***********************************************************************************
* This class manages main bar and TableView for PATs records.       			   *
*																				   *
***********************************************************************************/
package application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class RecordsBarPat extends VBox{
	TableColumn<Student, String> name;
	TableColumn<Student, String> dep;
	TableColumn<Student, String> mail;
	TableColumn<Student, String> load;
	Button pat;
	HBox b=new HBox();
	RadioButton cname=new RadioButton("Name");
	RadioButton cuob=new RadioButton("Department");
	RadioButton email=new RadioButton("Email");
	RadioButton cyear=new RadioButton("Load(full or partial)");
	RadioButton cUnallocated=new RadioButton("Not allocated");
	public RecordsBarPat(VBox bar,TableView<Pat> table1,TableView<Student> table) {
		table1.setVisible(false);
		table.setVisible(true);
			final ToggleGroup group = new ToggleGroup();
			cname.setToggleGroup(group);
			cname.setSelected(true);
			cuob.setToggleGroup(group);
			email.setToggleGroup(group);
			cyear.setToggleGroup(group);
			cUnallocated.setToggleGroup(group);
			cname.getStyleClass().add("radio-button");
			b.getChildren().addAll(cname,cuob,email,cyear,cUnallocated);
			b.setPadding(new Insets(12,12,12,12));
			TextField search=new TextField();
			search.setPromptText("Search");
			search.getStyleClass().add("search");
			//b.getChildren().add(search);
			b.setAlignment(Pos.CENTER);
			HBox c=new HBox();
			c.setAlignment(Pos.CENTER);
			c.setPadding(new Insets(12,0,0,0));
			c.getChildren().add(search);
			VBox centeral=new VBox();
			HBox center=new HBox();
			HBox left=new HBox();
			left.setPadding(new Insets(12,0,12,0));
			HBox right=new HBox();
			right.setPadding(new Insets(12,12,12,112));
			Label student=new Label("Search PAT Records");
			student.getStyleClass().add("mybar-label");
			left.getChildren().add(student);
			left.setAlignment(Pos.CENTER_LEFT);
			right.setAlignment(Pos.CENTER_RIGHT);
			pat=new Button("Search Student");
			pat.getStyleClass().add("record-button");
			ImageView img=new ImageView();
			img.setImage(new Image(getClass().getResource("/icons/search.png").toExternalForm()));
			pat.setGraphic(img);
			pat.setPrefHeight(130);
			pat.setPrefWidth(130);
			right.getChildren().add(pat);
			centeral.getChildren().add(c);
			centeral.getChildren().add(b);
			center.getChildren().add(centeral);
			center.setAlignment(Pos.CENTER);
			center.setPadding(new Insets(53,12,12,12));
			HBox m=new HBox();
			m.setAlignment(Pos.CENTER);
			m.getChildren().add(left);
			m.getChildren().add(center);
			m.getChildren().add(right);
			getChildren().add(m);
			pat.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					bar.getChildren().remove(0);
					bar.getChildren().add(new RecordsBarStudent(bar,table,table1));
				}
			});
	}

}
