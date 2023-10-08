package physics;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.w3c.dom.events.EventTarget;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

public class App extends Application {
    public Scene rootScene;//主页面
    /**
     * 组件库
     */
    public static final HashMap<String, EventTarget> nodes=new HashMap<>();

    public static URL getUrl(String path){
        return App.class.getClassLoader().getResource(path);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("MyPhysicsHelper");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

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
    }
}