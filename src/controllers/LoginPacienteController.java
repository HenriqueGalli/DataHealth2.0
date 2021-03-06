package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import login.Acesso;
import model.UsuarioPaciente;


public class LoginPacienteController {

    BaseController base = new BaseController();

    @FXML
    private Button btnLogin;

    @FXML
    private TextField txtCPFPaciente;

    @FXML
    private TextField txtSenhaPaciente;

    @FXML
    void fazerLogin(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        UsuarioPaciente user = new UsuarioPaciente();
        String cpfPaciente = txtCPFPaciente.getText();
        String senhaPaciente = txtSenhaPaciente.getText();
        base.realizarLogin(cpfPaciente, senhaPaciente, "layout_lista_medicamentos_cadastrados_para_nomePessoa.fxml", 
        ("Tela de Medicamentos cadastrados para " + cpfPaciente), event, user);
    }

    @FXML
    void voltarTelaAnterior(MouseEvent event) throws IOException {
        (((Node) event.getSource())).getScene().getWindow().hide();
        base.openNewScreen("layout_home_login.fxml", "Tela Home");
    }

}
