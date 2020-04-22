package model;

public class Comentario implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String nome;
	private String texto;
	private Noticia noticia;
	
	/**
	 * Void constructor
	 */
	public Comentario() {}

	/**
	 * Contructor
	 * 
	 * @param id
	 * @param nome
	 * @param texto
	 */
	public Comentario(int id, String nome, String texto, Noticia noticia) {
		this.id = id;
		this.nome = nome;
		this.texto = texto;
		this.noticia = noticia;
	}
	
	//	Getters and Setters //

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
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
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
	 * @return the noticia
	 */
	public Noticia getNoticia() {
		return noticia;
	}

	/**
	 * @param noticia the noticia to set
	 */
	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	// To String //

	@Override
	public String toString() {
		return "Comentario {id=" + id
				+ ", nome=" + nome 
				+ ", texto=" + texto 
				+ ", noticia=" + noticia.toString()
				+ "}";
	}
	
	// HashCode and Equals //

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((texto == null) ? 0 : texto.hashCode());
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
		Comentario other = (Comentario) obj;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (texto == null) {
			if (other.texto != null)
				return false;
		} else if (!texto.equals(other.texto))
			return false;
		return true;
	};
	
	
	
}
