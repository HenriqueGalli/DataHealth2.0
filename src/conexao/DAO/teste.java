package conexao.DAO;

import login.Acesso;
import model.UsuarioPaciente;
import model.UsuarioProfissional;

public class teste {
  public static void main(String[] args) throws Exception {
    Acesso acesso = new Acesso();
    UsuarioPaciente user = new UsuarioPaciente();
    user.setCpf("44283147877");
    user.setSenha("123456");
    Boolean senhaValida = acesso.validaUsuario(user);

    System.out.println("Finalizei o resultado é:" + senhaValida);
  }
}
