package login;

import java.sql.SQLException;
import conexao.DAO.DAO;
import conexao.DAO.usuario.UsuarioDAOFactory;
import model.Usuario;

public class Acesso {
  private boolean validaSenha(String senhaRepositorio, String senhaDigitada) {
    return (senhaRepositorio.equals(senhaDigitada));
  }

  public boolean validaUsuario(Usuario user) throws SQLException, ClassNotFoundException {
    boolean retorno = false;

    DAO dao = UsuarioDAOFactory.factory(user);
    dao.Inserir(user);
  
    Usuario usuario = (Usuario)dao.localiza(user.getCpf());
    if (usuario != null) {
      retorno = validaSenha(usuario.getSenha(), user.getSenha());
    }
    return retorno;
  }
}
