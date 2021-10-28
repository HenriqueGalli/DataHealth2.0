
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import login.Acesso;
import model.UsuarioPaciente;


public class LoginPacienteController {

    UsuarioPaciente user = new UsuarioPaciente();
    Acesso acesso = new Acesso();

    @FXML
    private Button btnLogin;

    @FXML
    private TextField txtCPFPaciente;

    @FXML
    private TextField txtSenhaPaciente;

    @FXML
    void fazerLogin(ActionEvent event) throws ClassNotFoundException, SQLException {
        String cpfPaciente = txtCPFPaciente.getText();
        user.setCpf(cpfPaciente);
        String senhaPaciente = txtSenhaPaciente.getText();
        user.setSenha(senhaPaciente);
        Boolean senhaValida = acesso.validaUsuario(user);

        if(senhaValida.equals(true)){
            System.out.println("Usuario Logado!!");
        }
        else{
            System.out.println("Usuario Deslogado");
        }
    }

}
