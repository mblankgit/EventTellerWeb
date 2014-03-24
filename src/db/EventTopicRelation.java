package db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * EventTopicRelation entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "EventTopicRelation", catalog = "EventTeller")
public class EventTopicRelation implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -4782408097696495156L;
	private Integer eid;
	private Integer tid;

	// Constructors

	/** default constructor */
	public EventTopicRelation() {
	}

	/** minimal constructor */
	public EventTopicRelation(Integer eid) {
		this.eid = eid;
	}

	/** full constructor */
	public EventTopicRelation(Integer eid, Integer tid) {
		this.eid = eid;
		this.tid = tid;
	}

	// Property accessors
	@Id
	@Column(name = "eid", unique = true, nullable = false)
	public Integer getEid() {
		return this.eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	@Column(name = "tid")
	public Integer getTid() {
		return this.tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

}