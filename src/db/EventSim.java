package db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * EventSim entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "EventSim", catalog = "EventTeller")
public class EventSim implements java.io.Serializable {

	// Fields

	private Integer fid;
	private Integer sid;
	private double score;

	// Constructors

	/** default constructor */
	public EventSim() {
	}

	/** minimal constructor */
	public EventSim(Integer fid) {
		this.fid = fid;
	}

	/** full constructor */
	public EventSim(Integer fid, Integer sid, double score) {
		this.fid = fid;
		this.sid = sid;
		this.score = score;
	}

	// Property accessors
	@Id
	@Column(name = "fid", unique = true, nullable = false)
	public Integer getFid() {
		return this.fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	@Column(name = "sid")
	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	@Column(name = "score", precision = 22, scale = 0)
	public double getScore() {
		return this.score;
	}

	public void setScore(double score) {
		this.score = score;
	}

}