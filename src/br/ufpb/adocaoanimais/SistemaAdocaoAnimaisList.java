package br.ufpb.adocaoanimais;
import java.util.ArrayList;
import java.util.List;

public class SistemaAdocaoAnimaisList implements SistemaAdocaoAnimais  {
  
	private List<Animal> animais;

	private List<Usuario> usuarios;
	
	public SistemaAdocaoAnimaisList() {
		this.animais = new ArrayList<Animal>();
		this.usuarios = new ArrayList<Usuario>();
	}
	
	/**
	 * Pesquisa no sistema o usu�rio com um dado CPF
	 * @param cpf O CPF a pesquisar
	 * @return O usu�rio do sistema que tem o mesmo CPF
	 */
	@Override
	public Usuario pesquisaUsuario(String cpf) throws UsuarioNaoExisteException {
		for (Usuario u : this.usuarios) {
			if (u.getCpf().equals(cpf)) {
				return u;
			}
		}
		throw new UsuarioNaoExisteException("Usu�rio n�o encontrado com esse cpf " + cpf);
	}
	
	/**
	 * Pesquisa os usu�rios cujo nome come�a com um certo prefixo
	 * @param prefixo O prefixo a pesquisar
	 * @return a lista dos usu�rios cujo nome come�a com certo prefixo
	 */

	@Override

	public List<Usuario> pesquisaUsuariosComNomeComecandoCom(String prefixo) {
		List<Usuario> listaNomes = new ArrayList<>();
		for (Usuario us : this.usuarios) {
			if (us.getNome().startsWith(prefixo)) {
				listaNomes.add(us);
			}

		}
		return listaNomes;
		
		}
	
	/**
	 * Pesquisa os animais do tipo passado como par�metro
	 * @param tipo O tipo de animal a pesquisar
	 * @return a lista dos animais do tipo pesquisado.
	 */
	@Override
	public List<Animal> pesquisaAnimaisDoTipo(String tipo) {
		List<Animal> listaAnimais = new ArrayList<>();
		for (Animal a : this.animais) {
			if (a.getTipo().equals(tipo)) {
				listaAnimais.add(a);
			}
		}
		return listaAnimais;
	}
	/**
	 * Pesquisa no sistema animais por um determinado sexo 
	 * @param sexo O sexo do animal a pesquisar
	 * @return a lista dos animais do sexo pesquisado
	 */
	@Override
	public List<Animal> pesquisaAnimaisPeloSexo(String sexo) {
		List<Animal> listaAnimais = new ArrayList<>();
		for (Animal a : this.animais) {
			if (a.getSexo().equalsIgnoreCase(sexo)){
				listaAnimais.add(a);
			}
		}
		return listaAnimais;
	}
	/**
	 * Pesquisa no sistema animais por uma determinado cor 
	 * @param cor A cor do animal a pesquisar
	 * @return a lista dos animais da cor pesquisada
	 */
	@Override
	public List<Animal> pesquisaAnimaisPelaCor(String cor) {
		List<Animal> listaAnimais = new ArrayList<>();
		for (Animal a : this.animais) {
			if (a.getCor().equalsIgnoreCase(cor)){
				listaAnimais.add(a);
			}
		}
		return listaAnimais;
	}
	/**
	 * Pesquisa no sistema usu�rios de acordo com sua prefer�ncia de tipo do animal
	 * @param tipo O tipo do animal a pesquisar
	 * @return a lista dos usu�rio que preferem aquele tipo de animal especificado
	 */
	@Override
	public List<Usuario> pesquisaUsuariosComPreferenciaDeTipoAnimal(String tipo){
		List<Usuario> listaUsuarios = new ArrayList<>();
		for(Usuario user: this.usuarios) {
			for(Requisito r: user.getRequisitos()) {
				if(r.getNomeRequisito().equalsIgnoreCase("Tipo")) {
					if(r.getValorEsperadoRequisito().equalsIgnoreCase(tipo)) {
						listaUsuarios.add(user);
					}
				}
			}
		}
		return listaUsuarios;
	
	}
	/**
	 * Pesquisa no sistema animais de acordo com o tipo especificado
	 * * @param tamanho O tamanho do animal a pesquisar
	 * @return a lista dos animais que s�o de determinado tamanho
	 */
	@Override
	public List<Animal> pesquisaAnimaisPeloTamanho(String tamanho){
		List<Animal> listaAnimais = new ArrayList<>();
		for(Animal ani: this.animais) {
			if(ani.getTamanho().equals(tamanho)) {
				listaAnimais.add(ani);
			}

		}
		return listaAnimais;

	}
	@Override
	public boolean cadastraUsuario(Usuario user) {
		if (existeUsuario(user)) {
			return false;
		} else {
			this.usuarios.add(user);
			return true;
		}
	}
	/*
	 * M�todo que verifica se o usu�rio existe por meio do cpf
	 */
	@Override
	public boolean existeUsuario(Usuario user) {
		for (Usuario u: this.usuarios) {
			if (u.getCpf().equals(user.getCpf())) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean cadastraAnimal(Animal a) {
		if (existeAnimal(a)) {
			return false;
		} else {
			this.animais.add(a);
			return true;
		}
	}
	/*
	 * M�todo que verifica se o animal existe atrav�s de seu c�digo
	 */
	@Override
	public boolean existeAnimal(Animal animal) {
		for (Animal a: this.animais) {
			if (a.getCodigo().equals(animal.getCodigo())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	@Override
	public void setUsuarios(List<Usuario> listaUsuarios) {
		this.usuarios = listaUsuarios;
	}


	@Override
	public List<Animal> getAnimais() {
		return this.animais;
	}

	@Override
	public void setAnimais(List<Animal> lista) {
		this.animais = lista;
		
	}

	

}