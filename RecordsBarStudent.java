/***********************************************************************************
* This class manages main bar of records tab and TableView for Student records.    *
*																				   *
***********************************************************************************/
package application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class RecordsBarStudent extends VBox{
	TableColumn<Student, String> name;
	TableColumn<Student, Integer> year;
	TableColumn<Student, String> pata;
	TableColumn<Student, String> id;
	TableColumn<Student,String> mail;
	HBox b=new HBox();
	RadioButton cname=new RadioButton("Name");
	RadioButton cuob=new RadioButton("ID");
	RadioButton cpat=new RadioButton("PAT Name");
	RadioButton email=new RadioButton("Email");
	RadioButton cyear=new RadioButton("Year");
	RadioButton cUnallocated=new RadioButton("Not allocated");
	ObservableList<Student> sdata;
	public RecordsBarStudent(VBox bar,TableView<Student> table,TableView<Pat> table1){
		final ToggleGroup group = new ToggleGroup();
		table1.setVisible(false);
		table.setVisible(true);
		cname.setToggleGroup(group);
		cname.setSelected(true);
		cuob.setToggleGroup(group);
		cpat.setToggleGroup(group);
		email.setToggleGroup(group);
		cyear.setToggleGroup(group);
		cUnallocated.setToggleGroup(group);
		cname.getStyleClass().add("radio-button");
		b.getChildren().addAll(cname,cuob,cpat,email,cyear,cUnallocated);
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
		Label student=new Label("Search Student Records");
		student.getStyleClass().add("mybar-label");
		left.getChildren().add(student);
		left.setAlignment(Pos.CENTER_LEFT);
		right.setAlignment(Pos.CENTER_RIGHT);
		Button pat=new Button("Search PAT");
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
		addDataToTable(table);
		addColumnsToTable(table);
		pat.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				bar.getChildren().remove(0);
				System.out.println(table.getItems().size());
				sdata.clear();
				if(table.getItems().size()==1){
					table.getItems().remove(0);
				}
				System.out.println("Table Data: "+table.getItems().size());
				table.getColumns().removeAll(name,id,year,mail,pata);
				System.out.println("Table Columns: "+table.getColumns().size());
				bar.getChildren().add(new RecordsBarPat(bar,table1,table));
			}
		});
		
	}
	public void addDataToTable(TableView<Student> table){
		if(table.getItems().size()==0){
					sdata=FXCollections.observableArrayList(
					new Student("Jaleel","13031155",3,"maliknsj@gmail.com","Sarmad Ali"),
					new Student("Jameel","13031155",3,"maliknsj@gmail.com","Sarmad Ali"),
					new Student("Janeel","13031155",3,"maliknsj@gmail.com","Sarmad Ali"),
					new Student("Janeel","13031155",3,"maliknsj@gmail.com","Sarmad Ali"),
					new Student("Janeel","13031155",3,"maliknsj@gmail.com","Sarmad Ali"),
					new Student("Janeel","13031155",3,"maliknsj@gmail.com","Sarmad Ali"),
					new Student("Janeel","13031155",3,"maliknsj@gmail.com","Sarmad Ali"),
					new Student("Janeel","13031155",3,"maliknsj@gmail.com","Sarmad Ali"),
					new Student("Janeel","13031155",3,"maliknsj@gmail.com","Sarmad Ali"),
					new Student("Janeel","13031155",3,"maliknsj@gmail.com","Sarmad Ali"),
					new Student("Janeel","13031155",3,"maliknsj@gmail.com","Sarmad Ali"),
					new Student("Janeel","13031155",3,"maliknsj@gmail.com","Sarmad Ali"),
					new Student("Janeel","13031155",3,"maliknsj@gmail.com","Sarmad Ali"),
					new Student("Janeel","13031155",3,"maliknsj@gmail.com","Sarmad Ali"),
					new Student("Janeel","13031155",3,"maliknsj@gmail.com","Sarmad Ali"),
					new Student("Janeel","13031155",3,"maliknsj@gmail.com","Sarmad Ali"),
					new Student("Janeel","13031155",3,"maliknsj@gmail.com","Sarmad Ali"),
					new Student("Janeel","13031155",3,"maliknsj@gmail.com","Sarmad Ali"),
					new Student("Janeel","13031155",3,"maliknsj@gmail.com","Sarmad Ali")
					);
			table.setItems(sdata);
		}
	}
	public void addColumnsToTable(TableView<Student> table){
		if(table.getColumns().size()==0){
			name=new TableColumn<>("Name");
			name.setCellValueFactory(new PropertyValueFactory<>("name"));
			name.setMinWidth(200);
			id=new TableColumn<>("Student ID");
			id.setCellValueFactory(new PropertyValueFactory<>("id"));
			year=new TableColumn<>("year");
			year.setCellValueFactory(new PropertyValueFactory<>("year"));
			mail=new TableColumn<>("Email");
			mail.setCellValueFactory(new PropertyValueFactory<>("email"));
			pata=new TableColumn<>("PAT Name");
			pata.setCellValueFactory(new PropertyValueFactory<>("pat"));
			table.getColumns().addAll(name,id,year,mail,pata);
		}
	}
}
