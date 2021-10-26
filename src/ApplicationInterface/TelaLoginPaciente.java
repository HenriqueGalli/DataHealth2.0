package ApplicationInterface;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TelaLoginPaciente extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage arg0) throws Exception {
        arg0.setTitle("Tela de Login Paciente");
        Button button = new Button("ENTRAR");
        button.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                System.out.println("Clicou em Entrar");
            }
        });

        StackPane root = new StackPane();
        root.getChildren().addAll(button);
        arg0.setScene(new Scene(root, 300, 250));
    }
    
}
