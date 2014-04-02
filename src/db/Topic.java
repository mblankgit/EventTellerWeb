package db;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Topic entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Topic", catalog = "EventTeller")
public class Topic implements java.io.Serializable {

	// Fields

	private Integer id;
	private String keyWords;
	private String summary;
	private Date startTime;
	private Date endTime;
	private Integer number;
	private String timeNumber;

	// Constructors

	/** default constructor */
	public Topic() {
	}

	/** minimal constructor */
	public Topic(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Topic(Integer id, String keyWords, String summary, Date startTime,
			Date endTime, Integer number, String timeNumber) {
		this.id = id;
		this.keyWords = keyWords;
		this.summary = summary;
		this.startTime = startTime;
		this.endTime = endTime;
		this.number = number;
		this.timeNumber = timeNumber;
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

	@Column(name = "keyWords", length = 65535)
	public String getKeyWords() {
		return this.keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}

	@Column(name = "summary", length = 65535)
	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	@Column(name = "startTime", length = 19)
	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	@Column(name = "endTime", length = 19)
	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@Column(name = "number")
	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	@Column(name = "timeNumber", length = 16777215)
	public String getTimeNumber() {
		return this.timeNumber;
	}

	public void setTimeNumber(String timeNumber) {
		this.timeNumber = timeNumber;
	}

}