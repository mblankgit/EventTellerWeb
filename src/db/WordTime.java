package db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WordTime entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "WordTime", catalog = "EventTeller")
public class WordTime implements java.io.Serializable {

	// Fields

	private String name;
	private String type;
	private String timeLine;

	// Constructors

	/** default constructor */
	public WordTime() {
	}

	/** minimal constructor */
	public WordTime(String name) {
		this.name = name;
	}

	/** full constructor */
	public WordTime(String name, String type, String timeLine) {
		this.name = name;
		this.type = type;
		this.timeLine = timeLine;
	}

	// Property accessors
	@Id
	@Column(name = "name", unique = true, nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "type", length = 20)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "timeLine", length = 65535)
	public String getTimeLine() {
		return this.timeLine;
	}

	public void setTimeLine(String timeLine) {
		this.timeLine = timeLine;
	}

}