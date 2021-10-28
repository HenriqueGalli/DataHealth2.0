package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicBoolean;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import login.Acesso;
import model.Usuario;
import model.UsuarioPaciente;
import model.UsuarioProfissional;


public class BaseController {

    UsuarioPaciente user = new UsuarioPaciente();
    
    Acesso acesso = new Acesso();
    
    public void openNewScreen(String fxml, String title) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/layouts/" + fxml));
        stage.setTitle(fxml);
        stage.setScene(new Scene(root));
        stage.setTitle(title);
        stage.show();
    }

    public void openAlert(String title, String messageHeader, String messageInside, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(messageHeader);
        alert.setContentText(messageInside);
        alert.showAndWait();
    }

    public void realizarLogin(String login, String senha, String fxml, String nextTitle, ActionEvent event, Usuario user) throws ClassNotFoundException, SQLException, IOException{
        user.setCpf(login);
        user.setSenha(senha);
        Boolean senhaValida = acesso.validaUsuario(user);

        if(senhaValida.equals(true)){
            ((Node)(event.getSource())).getScene().getWindow().hide();
            openNewScreen(fxml, nextTitle);
        }
        else{
            openAlert("Erro ao Realizar Login", "Por favor realize uma nova tentativa", "", AlertType.ERROR);
        }
    }
}
