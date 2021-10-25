package conexao.DAO;

import login.Acesso;
import model.UsuarioProfissional;

public class teste {
  public static void main(String[] args) throws Exception {
    Acesso acesso = new Acesso();
    UsuarioProfissional user = new UsuarioProfissional();
    user.setCpf("48608042878");
    user.setSenha("12345");
    Boolean senhaValida = acesso.validaUsuario(user);

    System.out.println("Finalizei o resultado é:" +senhaValida);
  }
}
