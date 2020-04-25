package br.ufpb.adocaoanimais;

import java.util.List;

public interface SistemaAdocaoAnimais  {
	
	public List <Usuario> getUsuarios();
	
	public void  setUsuarios(List <Usuario> lista);
	
	public List <Animal> getAnimais();
	
	public void setAnimais (List <Animal> lista);
	
	/**
	 * Pesquisa no sistema o usu�rio com um dado CPF
	 * @param cpf O CPF a pesquisar
	 * @return O usu�rio do sistema que tem o mesmo CPF
	 */
	public Usuario pesquisaUsuario(String cpf) throws UsuarioNaoExisteException ;

	/**
	 * Pesquisa os usu�rios cujo nome come�a com um certo prefixo
	 * @param prefixo O prefixo a pesquisar
	 * @return a lista dos usu�rios cujo nome come�a com certo prefixo
	 */
	public List<Usuario> pesquisaUsuariosComNomeComecandoCom(String prefixo);

	/**
	 * Pesquisa os animais do tipo passado como par�metro
	 * @param tipo O tipo de animal a pesquisar
	 * @return a lista dos animais do tipo pesquisado.
	 */
	public List<Animal> pesquisaAnimaisDoTipo(String tipo);
	
	/**
	 * Pesquisa no sistema animais por um determinado sexo 
	 * @param sexo O sexo do animal a pesquisar
	 * @return a lista dos animais do sexo pesquisado
	 */
	public List<Animal> pesquisaAnimaisPeloSexo(String sexo);
	
	/**
	 * Pesquisa no sistema animais por uma determinado cor 
	 * @param cor A cor do animal a pesquisar
	 * @return a lista dos animais da cor pesquisada
	 */
	public List<Animal> pesquisaAnimaisPelaCor(String cor);


	public boolean cadastraUsuario(Usuario user);

	/*
	 * M�todo que verifica se o usu�rio existe por meio do cpf
	 */
	public boolean existeUsuario(Usuario user);

	public boolean cadastraAnimal(Animal a);

	/*
	 * M�todo que verifica se o animal existe por meio do c�digo
	 */
	public boolean existeAnimal(Animal animal);

	/**
	 * Pesquisa no sistema usu�rios de acordo com sua prefer�ncia de tipo do animal
	 * @param tipo O tipo do animal a pesquisar
	 * @return a lista dos usu�rio que preferem aquele tipo de animal especificado
	 */
	List<Usuario> pesquisaUsuariosComPreferenciaDeTipoAnimal(String tipo);
	
	List<Animal> pesquisaAnimaisPeloTamanho(String tamanho);

	
}