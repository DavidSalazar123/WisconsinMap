import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jioyan zhang
 * The front end of the map that implements the gui elements and interactions.
 * Calls getList() & findShortestPath() from the backend.
 */
public class MapFrontEnd extends Application {
    MapBackEnd engine;
    String start;
    String end;
    LinkedList<String> locations = new LinkedList<>();
    LinkedList<String> pairedValues = new LinkedList<>();
    boolean testResult1 = true;
    boolean testResult2 = true;
    boolean testResult3 = true;
    boolean testResult4 = true;

    public void run() {
        MapFrontEnd.launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        // fill in the locations
        this.engine = mapApp.feed();
        this.locations = this.engine.getList();
        // test 1
        testResult1 = this.locations == mapApp.feed().getList();
        char init = 'A';
        for (String i : locations) {
            pairedValues.add(Character.toString(init));
            System.out.println(Arrays.toString(locations.toArray()));
            init ++;
        }
        testResult2 = pairedValues.size() == locations.size();

        Group group = new Group();
        Scene scene = new Scene(group,1100,650);
        stage.setScene(scene);
        stage.setTitle("Group Project 3: Campus Map");
        Label title = new Label("UW  CAMPUS  MAP");
        title.setFont(Font.font(60));
        title.setLayoutX(50);
        title.setLayoutY(0);
        Label welcomeMsg = new Label("Welcome to the interactive campus map!\nHere you can find the shortest path \nbetween two different places on campus.");
        welcomeMsg.setFont(Font.font(20));
        welcomeMsg.setLayoutX(620);
        welcomeMsg.setLayoutY(0);
        ImageView image = new ImageView(new Image("CampusMap.png"));
        image.setFitHeight(420);
        image.setFitWidth(720);
        image.setX(50);
        image.setY(100);
        group.getChildren().addAll(title, welcomeMsg, image);
        Label l4 = new Label("*You may enter the character representing the campus buildings in the entries below.");
        l4.setTranslateX(80);
        l4.setLayoutY(540);
        int distance = 80;
        int layY = 570;
        Label l1 = new Label("From");
        l1.setFont(Font.font(20));
        l1.setLayoutX(distance);
        l1.setLayoutY(layY);
        Label l2 = new Label("To");
        l2.setFont(Font.font(20));
        l2.setLayoutX(distance + 220);
        l2.setLayoutY(layY);
        TextField t1 = new TextField();
        t1.setLayoutX(distance + 50);
        t1.setLayoutY(layY);
        TextField t2 = new TextField();
        t2.setLayoutX(distance + 250);
        t2.setLayoutY(layY);
        Button b1 = new Button("Find!");
        b1.setLayoutX(distance + 420);
        b1.setLayoutY(layY);
        b1.setOnAction(event -> {
            start = checkInputs(t1.getText());
            end = checkInputs(t2.getText());
            if (start == null || end == null) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("Invalid input, must be in range " + pairedValues.getFirst() + " to " + pairedValues.getLast());
                a.show();
            } else {
                // finish the update by covering with a white rectangle
                Rectangle r = new Rectangle(500, 100);
                r.setFill(Color.WHITE);
                r.setLayoutX(600);
                r.setLayoutY(570);
                String result = "";
                boolean found = false;
                // calling the backend
                try {
                    List<String> resultSet = this.engine.findShortestPath(start, end);
                    found = true;
                }catch (Exception e) {
                    result = "A path is not found!";
                }
                if (found) {
                    List<String> resultSet = this.engine.findShortestPath(start, end);
                    result = "Path: ";
                    for (int i = 0; i < resultSet.size() - 1; i++) {
                        result += resultSet.get(i);
                        result += "->";
                    }
                    result += resultSet.get(resultSet.size() - 1);
                } else {
                    result = "A path is not found!";
                }
                Label l3 = new Label(result);
                l3.setFont(Font.font(20));
                l3.setLayoutX(600);
                l3.setLayoutY(570);
                group.getChildren().addAll(r, l3);
            }
        });

        // generate list view
        ListView<String> table = new ListView<>();
        table.setLayoutX(800);
        table.setLayoutY(100);
        for (int i = 0; i < pairedValues.size(); i ++) {
            String s = pairedValues.get(i) + "   " + locations.get(i);
            table.getItems().add(s);
        }
        group.getChildren().addAll(l1, l2, l4, t1, t2, b1, table);
        testResult4 = group.getChildren().size() == 10;
        stage.show();
    }

    private String checkInputs(String s) {
        if (s == null) return null;
        for (int i = 0; i < pairedValues.size(); i ++) {
            if (s.equalsIgnoreCase(pairedValues.get(i))) {
                return locations.get(i);
            }
        }
        return null;
    }

    public boolean testFeedingMap () {
        return testResult1;
    }

    public boolean testCharacterPairedList () {
        return testResult2;
    }

    public boolean testValidAndInvalidInputs() {
        testResult3 = checkInputs("kkk")==null && checkInputs("a") != null && checkInputs("A") != null;
        return testResult3;
    }

    public boolean testIfAllElementsAreLoaded() {
        return testResult4;
    }


}