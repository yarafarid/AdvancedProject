package excelread;


import javafx.event.ActionEvent;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import com.google.gson.Gson;
import javafx.application.Application;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.text.Font;

import javafx.stage.Stage;


public class GUI extends Application {
    private String ApiRequest;


    @Override
    public void start(Stage s) throws Exception {


        Service service = new Service("Example.xlsx");
        try {
            service.init();
            recieveApi("Apiname", "Insert Api name", service);
        } catch (FileNotFoundException e) {
            //System.out.println("Error: excel file not found, make sure to place it in the project file");
            showError("Error: excel file not found, make sure to place it in the project file with the name Example.xlsx", 550, 50);

        }


    }

    public void recieveApi(String example, String request, Service service) {

        Stage s = new Stage();
        // set title for the stage
        s.setTitle("Project");

        // create a textfield
        TextField b = new TextField(example);

        // set preferred column count
        b.setPrefColumnCount(5);

        // create a tile pane
        TilePane r = new TilePane();

        // create a label
        Label l = new Label(request);

        // action event
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                ApiRequest = b.getText();
                showApi(ApiRequest, service);
            }
        };

        // when enter is pressed
        b.setOnAction(event);

        // add textfield
        r.getChildren().add(b);
        r.getChildren().add(l);
        Scene sc = new Scene(r, 200, 50);
        s.setScene(sc);

        s.show();

    }



    public void showApi(String name, Service service) {
        Operation operation = service.getOperation(name);
        if (operation == null) {

            showError("Error: API doesn't exist, type another name", 300, 50);

        } else {
            Stage primaryStage = new Stage();

            primaryStage.setTitle(ApiRequest);

            Label label = new Label((new Gson()).toJson(operation));
            label.setWrapText(true);

            StackPane layout = new StackPane(label);


            Scene scene1 = new Scene(layout, 500, 150);

            primaryStage.setScene(scene1);
            primaryStage.show();

            System.out.println((new Gson()).toJson(operation));
            ObjectsRepository.add(operation);
            for (String key : ObjectsRepository.all.keySet()) {
                ListView mListView = new ListView();
                Stage stage = new Stage();
                Scene scene = new Scene(new Group());
                stage.setTitle(key);
                stage.setMaxWidth(550);
                stage.setMaxHeight(550);
                Label titleLabel = new Label(key);
                titleLabel.setFont(new Font("Lucida ", 20));
                titleLabel.setTextFill(Color.rgb(71, 31, 111));
                mListView.getItems().addAll((ObjectsRepository.all.get(key)));
                final VBox vbox = new VBox();
                vbox.setSpacing(5);
                vbox.setPadding(new Insets(10, 80, 50, 10));
                vbox.getChildren().addAll(titleLabel, mListView);
                vbox.setAlignment(Pos.CENTER);

                Group group = ((Group) scene.getRoot());
                group.getChildren().addAll(vbox);
                group.setLayoutX(100);

                stage.setScene(scene);
                stage.show();
            }
            ObjectsRepository.reset();
        }
    }

    public void showError(String errorMsg, double width, double hight) {
        Stage errorStage = new Stage();
        Label error = new Label(errorMsg);
        error.setTextFill(Color.RED);
        error.setWrapText(true);
        errorStage.setScene(new Scene(new StackPane(error), width, hight));
        errorStage.show();

    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Application.launch(args);
    }


}