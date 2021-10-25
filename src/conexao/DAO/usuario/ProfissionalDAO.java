package conexao.DAO.usuario;

import java.sql.ResultSet;
import java.sql.SQLException;

import conexao.DAO.DAO;
import model.Entidade;
import model.UsuarioProfissional;

public class ProfissionalDAO <E extends Entidade> extends DAO {

    public ProfissionalDAO() {
        super(UsuarioProfissional.class);
        setTabela("usuario_profissional");
        
    }

    @Override
    protected Entidade preencheEntidade(ResultSet rs) {
        UsuarioProfissional entidade = new UsuarioProfissional();
        
        try {
            entidade.setId(rs.getInt("Id"));
            entidade.setNome(rs.getString("Nome"));
            entidade.setSenha(rs.getString("Senha"));
            entidade.setCpf(rs.getString("Cpf"));
            entidade.setCargo(rs.getString("Cargo"));
            entidade.setMatricula(rs.getString("Matricula"));
            entidade.setRegistroProfissional(rs.getString("RegistroProfissional"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return (E)entidade;
    }

    @Override
    protected String getLocalizaCommand() {
        return "select * from usuario_profisisonal WHERE Cpf = ?";
    }
    
}
