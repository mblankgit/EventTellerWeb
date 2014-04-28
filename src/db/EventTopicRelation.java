package db;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * EventTopicRelation entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "EventTopicRelation", catalog = "EventTeller")
public class EventTopicRelation implements java.io.Serializable {

	// Fields

	private EventTopicRelationId id;

	// Constructors

	/** default constructor */
	public EventTopicRelation() {
	}

	/** full constructor */
	public EventTopicRelation(EventTopicRelationId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "eid", column = @Column(name = "eid", nullable = false)),
			@AttributeOverride(name = "tid", column = @Column(name = "tid", nullable = false)) })
	public EventTopicRelationId getId() {
		return this.id;
	}

	public void setId(EventTopicRelationId id) {
		this.id = id;
	}

}