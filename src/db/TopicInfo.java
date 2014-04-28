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

	private Integer id;
	private Integer startDay;
	private Integer endDay;
	private Integer number;
	private String main;
	private String object;

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
			Integer number, String main, String object) {
		this.id = id;
		this.startDay = startDay;
		this.endDay = endDay;
		this.number = number;
		this.main = main;
		this.object = object;
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

	@Column(name = "main", length = 256)
	public String getMain() {
		return this.main;
	}

	public void setMain(String main) {
		this.main = main;
	}

	@Column(name = "object", length = 256)
	public String getObject() {
		return this.object;
	}

	public void setObject(String object) {
		this.object = object;
	}

}