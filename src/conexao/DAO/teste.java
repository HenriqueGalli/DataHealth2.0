package conexao.DAO;

import login.Acesso;
import model.UsuarioProfissional;

public class teste {
  public static void main(String[] args) throws Exception {
    Acesso acesso = new Acesso();
    UsuarioProfissional user = new UsuarioProfissional();
    user.setCpf("92482026083");
    user.setSenha("123456");
    Boolean senhaValida = acesso.validaUsuario(user);

    System.out.println("Finalizei o resultado é:" + senhaValida);
  }
}
