package physics;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
<<<<<<< HEAD
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
=======
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
>>>>>>> 26279fa8320025c01e7f8109d250a42028a96fa8
import javafx.stage.Stage;
import org.w3c.dom.events.EventTarget;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import java.io.IOException;

public class App extends Application {
<<<<<<< HEAD
    public static String url = "src/resources/main.fxml";
=======
    public Scene rootScene;//主页面
    /**
     * 组件库
     */
    public static final HashMap<String, EventTarget> nodes=new HashMap<>();

    public static URL getUrl(String path){
        return App.class.getClassLoader().getResource(path);
    }
>>>>>>> 26279fa8320025c01e7f8109d250a42028a96fa8

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("MyPhysicsHelper");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

<<<<<<< HEAD
    public void init() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(url));
        MenuBar menuBar=new MenuBar();
        Menu file = menuBar.getMenus().get(0);
=======
    public Node getNodeById(String id){
        return (Node) nodes.get(id);
    }

    /**
     *注册组件
     */
    public void regNodes(Parent parent){
        for (Node node: parent.getChildrenUnmodifiable()) {
            if (node instanceof Parent){
                if (node instanceof MenuBar){
                    for (Menu menu:((MenuBar) node).getMenus()){
                        for (MenuItem item:menu.getItems()){
                            if (item.getId()!=null) nodes.put(item.getId(), (EventTarget) item);
                        }
                    }
                }else regNodes(((Parent) node));
            }
        }
    }

    public void init() throws IOException {
        AnchorPane root= FXMLLoader.load(getUrl("res/fxml/test.fxml"));
        regNodes(root);
        rootScene=new Scene(root);
>>>>>>> 26279fa8320025c01e7f8109d250a42028a96fa8
    }
}