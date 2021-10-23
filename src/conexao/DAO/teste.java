package conexao.DAO;

import model.Usuario;
import model.UsuarioPaciente;

public class teste {
  public static void main(String[] args) throws Exception {
    acesso acesso = new acesso();
    UsuarioPaciente user = new UsuarioPaciente();
    user.setCpf("44283147877");
    user.setSenha("123456");
    Boolean senhaValida = acesso.validaUsuario(user);
  }
}
