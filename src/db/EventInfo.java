package db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * EventInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "EventInfo", catalog = "EventTeller")
public class EventInfo implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 4582084713907113574L;
	private Integer id;
	private Integer number;
	private Integer day;
	private Integer topic;

	// Constructors

	/** default constructor */
	public EventInfo() {
	}

	/** minimal constructor */
	public EventInfo(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public EventInfo(Integer id, Integer number, Integer day, Integer topic) {
		this.id = id;
		this.number = number;
		this.day = day;
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

	@Column(name = "number")
	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	@Column(name = "day")
	public Integer getDay() {
		return this.day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	@Column(name = "topic")
	public Integer getTopic() {
		return this.topic;
	}

	public void setTopic(Integer topic) {
		this.topic = topic;
	}

}