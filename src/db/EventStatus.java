package db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * EventStatus entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "EventStatus", catalog = "EventTeller")
public class EventStatus implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -7406390521551217093L;
	private Integer id;
	private short status;

	// Constructors

	/** default constructor */
	public EventStatus() {
	}

	/** minimal constructor */
	public EventStatus(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public EventStatus(Integer id, short status) {
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