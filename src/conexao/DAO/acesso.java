package conexao.DAO;

import java.sql.SQLException;

import javax.xml.crypto.Data;

import model.Entidade;
import model.Usuario;
import model.UsuarioPaciente;

public class acesso {
  private boolean validaSenha(String senhaRepositorio, String senhaDigitada) {
    return (senhaRepositorio.equals(senhaDigitada));
  }

  public boolean validaUsuario(Usuario user) throws SQLException, ClassNotFoundException {
    boolean retorno = false;
    DAO teste = new PacienteDAO<>();
    Usuario usuario = (Usuario)teste.localiza(user.getCpf());
    if (usuario != null) {
      retorno = validaSenha(usuario.getSenha(), user.getSenha());
    }
    return retorno;
  }
}
