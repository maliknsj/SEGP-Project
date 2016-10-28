package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class Controller implements Initializable {
	int prev=0;
	@FXML
	TabPane tabs;
	@FXML
	VBox bar;
	@FXML
	Label barLabel;
	@FXML
	ListView<Request> requests;
	@FXML
	ListView<String> recentActivity;
	@FXML
	Pane summary;
	@FXML 
	VBox smry;
	@FXML 
	VBox rqsts;
	@FXML 
	VBox ractvty;
	@FXML
	StackPane mainPane;
	@FXML
	Button close;
	@FXML
	TableView recordsTable;
	@FXML
	TableView recordsTable2;
	ImageView imghm,imgrcrds,imgalloc,imgpref;
	Label lbhm,lbrcrds,lballoc,lbpref;
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		tabs.getStyleClass().add("vTabPane");
		imghm=new ImageView();
		imgrcrds=new ImageView();
		imgalloc=new ImageView();
		imgpref=new ImageView();
		imgpref.prefHeight(30);
		imgpref.prefWidth(30);
		imghm.setImage(new Image(getClass().getResource("/icons/home.png").toExternalForm()));
		imgrcrds.setImage(new Image(getClass().getResource("/icons/history.png").toExternalForm()));
		imgalloc.setImage(new Image(getClass().getResource("/icons/alloc.png").toExternalForm()));
		imgpref.setImage(new Image(getClass().getResource("/icons/pref.png").toExternalForm()));
		lbrcrds=new Label("Records", imgrcrds);
		lballoc=new Label("Allocations", imgalloc);
		lbpref=new Label("Prefrences", imgpref);
		lbhm=new Label("Home", imghm);
		lbhm.getStyleClass().add("tablabel");
		lballoc.getStyleClass().add("tablabel");
		lbrcrds.getStyleClass().add("tablabel");
		lbpref.getStyleClass().add("tablabel");
		tabs.getTabs().get(0).setGraphic(lbhm);
		tabs.getTabs().get(1).setGraphic(lbrcrds);
		tabs.getTabs().get(3).setGraphic(lbpref);
		tabs.getTabs().get(2).setGraphic(lballoc);
		
		ObservableList<Request> list= requests.getItems();
		list.addAll(new Request("Jaleel is Allocated to Sarmad Ali."),new Request("Jameel is Allocated to Sarmad Ali."));
		requests.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {

			@Override
			public void changed(ObservableValue<? extends Object> arg0, Object arg1, Object arg2) {
				requests.getItems().get(prev).allow.setVisible(false);
				requests.getItems().get(prev).deny.setVisible(false);
				requests.getSelectionModel().getSelectedItem().allow.setVisible(true);
				requests.getSelectionModel().getSelectedItem().deny.setVisible(true);
				prev=requests.getSelectionModel().getSelectedIndex();
			}
			
		});
		bar.setMaxHeight(bar.getPrefHeight());
		bar.getChildren().add(new HomeBar());
		tabs.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Object>() {

			@Override
			public void changed(ObservableValue<? extends Object> arg0, Object arg1, Object arg2) {
				// TODO Auto-generated method stub
				if(bar.getChildren().size()!=0)
					bar.getChildren().remove(0);
				if(tabs.getSelectionModel().getSelectedIndex()==1){
					bar.getChildren().add(new RecordsBarStudent(bar,recordsTable,recordsTable2));
				}
				if(tabs.getSelectionModel().getSelectedIndex()==0){
					bar.getChildren().add(new HomeBar());
					
				}
					
			}
			
		});
	}
	public void close(){
		close.getScene().getWindow().hide();
	}

}
