package db;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * EventTopicRelationId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class EventTopicRelationId implements java.io.Serializable {

	// Fields

	private Integer eid;
	private Integer tid;

	// Constructors

	/** default constructor */
	public EventTopicRelationId() {
	}

	/** full constructor */
	public EventTopicRelationId(Integer eid, Integer tid) {
		this.eid = eid;
		this.tid = tid;
	}

	// Property accessors

	@Column(name = "eid", nullable = false)
	public Integer getEid() {
		return this.eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	@Column(name = "tid", nullable = false)
	public Integer getTid() {
		return this.tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof EventTopicRelationId))
			return false;
		EventTopicRelationId castOther = (EventTopicRelationId) other;

		return ((this.getEid() == castOther.getEid()) || (this.getEid() != null
				&& castOther.getEid() != null && this.getEid().equals(
				castOther.getEid())))
				&& ((this.getTid() == castOther.getTid()) || (this.getTid() != null
						&& castOther.getTid() != null && this.getTid().equals(
						castOther.getTid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getEid() == null ? 0 : this.getEid().hashCode());
		result = 37 * result
				+ (getTid() == null ? 0 : this.getTid().hashCode());
		return result;
	}

}