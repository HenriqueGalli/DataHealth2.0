package conexao.DAO.usuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexao.DAO.DAO;
import model.Entidade;
import model.Usuario;
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

    @Override
    public void Inserir(Usuario usuario) throws SQLException, ClassNotFoundException {
        UsuarioProfissional paciente = (UsuarioProfissional)usuario;
        Class.forName("com.mysql.jdbc.Driver"); /* Aqui registra */
        try (Connection conexao = (Connection) DriverManager.getConnection(STRING_CONEXAO, USUARIO, SENHA)) {
            String SQL = getInserirProfissional();
            try (PreparedStatement stmt = conexao.prepareStatement(SQL)) {
                stmt.setString(1, paciente.getNome());
                stmt.setString(2, paciente.getCpf());
                stmt.setString(3, paciente.getSenha());
                stmt.setString(4, paciente.getMatricula());
                stmt.setString(5, paciente.getCargo());
                stmt.setString(6, paciente.getRegistroProfissional());
                stmt.executeUpdate();
            }
        }
    }

    protected String getInserirProfissional() {
        return "insert into "+ tabela +" (Nome, Cpf, Senha, Matricula, Cargo, RegistroProfissional) values (?, ?, ?, ?, ?, ?)";
    }
    
}