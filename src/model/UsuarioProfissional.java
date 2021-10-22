package model;

import conexao.annotations.CampoNoBanco;

public class UsuarioProfissional extends Usuario{
    
    @CampoNoBanco(nome="Matricula", chave = false)
    String Matricula;

    @CampoNoBanco(nome="Cargo", chave = false)
    Cargo Cargo;

    @CampoNoBanco(nome="RegistroProfissional", chave = false)
    String RegistroProfissional;

    public UsuarioProfissional(String nome, String cpf, String senha, 
                            String matricula, Cargo cargo, String registroProfissional )
    {
        this.Nome = nome;
        this.Senha = senha;
        this.Cpf = cpf;
        this.Cargo = cargo;
        this.Matricula = matricula;
        this.RegistroProfissional = registroProfissional;
    }

    public enum Cargo {
        MEDICO, ENFERMEIRO
    }

    public String getMatricula() {
        return this.Matricula;
    }

    public void setMatricula(String matricula) {
        this.Matricula = matricula;
    }

    public Cargo getCargo() {
		return this.Cargo;
	}

    public void setCargo(Cargo cargo ) {
		this.Cargo = cargo;
	}

    public String getRegistroProfissional() {
        return this.RegistroProfissional;
    }

    public void setRegistroProfissional(String registroProfissional) {
        this.RegistroProfissional = registroProfissional;
    }

}
