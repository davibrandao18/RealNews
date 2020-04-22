package model;

/**
 * 
 * @author Davi Fonseca
 * @version 0.1
 * @since 0.1
 *
 */
public class Noticia implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private int id ;
	private String descricao;
	private String titulo;
	private String texto;
	
	/**
	 * Void constructor
	 */
	public Noticia() {};
	
	/**
	 * Constructor
	 * 
	 * @param id
	 * @param descricao
	 * @param titulo
	 * @param texto
	 */
	public Noticia(int id, String descricao, String titulo, String texto) {
		this.id = id;
		this.descricao = descricao;
		this.titulo = titulo;
		this.texto = texto;
	}

	//Getters and Setters//

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}
	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}
	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	/**
	 * @return the texto
	 */
	public String getTexto() {
		return texto;
	}
	/**
	 * @param texto the texto to set
	 */
	public void setTexto(String texto) {
		this.texto = texto;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	//To String//

	@Override
	public String toString() {
		return "Noticia {id=" + id 
				+ ", descricao=" + descricao
				+ ", titulo=" + titulo
				+ ", texto=" + texto 
				+ "}";
	}
	
	//-----------------------------------------//

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + id;
		result = prime * result + ((texto == null) ? 0 : texto.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Noticia other = (Noticia) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id != other.id)
			return false;
		if (texto == null) {
			if (other.texto != null)
				return false;
		} else if (!texto.equals(other.texto))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
	
	
	
	
	
}
