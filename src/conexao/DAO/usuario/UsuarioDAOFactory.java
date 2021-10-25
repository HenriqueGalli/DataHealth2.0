package conexao.DAO.usuario;

import conexao.DAO.DAO;
import model.Usuario;
import model.UsuarioPaciente;

public class UsuarioDAOFactory {
    public static DAO factory(Usuario user){
        if(user.getClass().equals(UsuarioPaciente.class)){
            return new PacienteDAO<>();
         }
         else{
           return new ProfissionalDAO<>();
         }
    }
}
