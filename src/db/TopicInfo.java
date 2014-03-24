package db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TopicInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TopicInfo", catalog = "EventTeller")
public class TopicInfo implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -7260470769377330711L;
	private Integer id;
	private Integer startDay;
	private Integer endDay;
	private Integer number;

	// Constructors

	/** default constructor */
	public TopicInfo() {
	}

	/** minimal constructor */
	public TopicInfo(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public TopicInfo(Integer id, Integer startDay, Integer endDay,
			Integer number) {
		this.id = id;
		this.startDay = startDay;
		this.endDay = endDay;
		this.number = number;
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

	@Column(name = "startDay")
	public Integer getStartDay() {
		return this.startDay;
	}

	public void setStartDay(Integer startDay) {
		this.startDay = startDay;
	}

	@Column(name = "endDay")
	public Integer getEndDay() {
		return this.endDay;
	}

	public void setEndDay(Integer endDay) {
		this.endDay = endDay;
	}

	@Column(name = "number")
	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

}