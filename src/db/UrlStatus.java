package db;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UrlStatus entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "UrlStatus", catalog = "EventTeller")
public class UrlStatus implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -3977078715953014038L;
	private Integer id;
	private short status;
	private Date time;
	private Integer topic;

	// Constructors

	/** default constructor */
	public UrlStatus() {
	}

	/** minimal constructor */
	public UrlStatus(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public UrlStatus(Integer id, short status, Date time, Integer topic) {
		this.id = id;
		this.status = status;
		this.time = time;
		this.topic = topic;
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

	@Column(name = "time", length = 19)
	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Column(name = "topic")
	public Integer getTopic() {
		return this.topic;
	}

	public void setTopic(Integer topic) {
		this.topic = topic;
	}

}