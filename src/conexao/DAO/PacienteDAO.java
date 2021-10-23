package conexao.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Entidade;
import model.Medicamento;
import model.UsuarioPaciente;

public class PacienteDAO <E extends Entidade> extends DAO {

    public PacienteDAO(Class entityClass) {
        super(UsuarioPaciente.class);
    }

    @Override
    protected Entidade preencheEntidade(ResultSet rs) {
        UsuarioPaciente entidade = new UsuarioPaciente();
        try{
            entidade.setId(rs.getInt("Id"));
            entidade.setNome(rs.getString("Nome"));
            entidade.setSenha(rs.getString("Senha"));
            entidade.setCpf(rs.getString("Cpf"));
            entidade.setEmail(rs.getString("Email"));
            entidade.setTelefone(rs.getString("Telefone"));
            entidade.setTipoSanguineo(rs.getString("TipoSanguineo"));
            entidade.setRemedios((ArrayList<Medicamento>) rs.getArray("Remedios"));
        }catch(SQLException e){
            //deu ruim
        }
        return (E)entidade;
    }

    @Override
    protected String getLocalizaCommand() {
       return "select * from usuario_paciente where Cpf = ? ";
    }
    
}
