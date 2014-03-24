package db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TopicStatus entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TopicStatus", catalog = "EventTeller")
public class TopicStatus implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 6653803014619431914L;
	private Integer id;
	private short status;

	// Constructors

	/** default constructor */
	public TopicStatus() {
	}

	/** minimal constructor */
	public TopicStatus(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public TopicStatus(Integer id, short status) {
		this.id = id;
		this.status = status;
	}

	// Property accessors
	@Id
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "status")
	public short getStatus() {
		return this.status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

}