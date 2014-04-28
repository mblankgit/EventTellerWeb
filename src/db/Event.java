package db;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Event entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Event", catalog = "EventTeller")
public class Event implements java.io.Serializable {

	// Fields

	private Integer id;
	private String title;
	private Date pubTime;
	private String content;
	private String source;
	private String imgs;
	private Integer number;
	private Integer day;
	private Integer topic;

	// Constructors

	/** default constructor */
	public Event() {
	}

	/** minimal constructor */
	public Event(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Event(Integer id, String title, Date pubTime, String content,
			String source, String imgs, Integer number, Integer day,
			Integer topic) {
		this.id = id;
		this.title = title;
		this.pubTime = pubTime;
		this.content = content;
		this.source = source;
		this.imgs = imgs;
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

	@Column(name = "title", length = 200)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "pubTime", length = 19)
	public Date getPubTime() {
		return this.pubTime;
	}

	public void setPubTime(Date pubTime) {
		this.pubTime = pubTime;
	}

	@Column(name = "content", length = 16777215)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "source", length = 100)
	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Column(name = "imgs", length = 16777215)
	public String getImgs() {
		return this.imgs;
	}

	public void setImgs(String imgs) {
		this.imgs = imgs;
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