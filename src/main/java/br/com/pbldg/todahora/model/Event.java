package br.com.pbldg.todahora.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="EVENT", schema="todahora")
@SequenceGenerator(name="EventSequence", allocationSize=1, initialValue=1, schema="todahora", sequenceName="EVENT_ID_SQ")
public class Event implements Serializable {
	
	private static final long serialVersionUID = 5508925124920973286L;

	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE , generator="EventSequence")
	private Long id;
	
	@Column(name = "NAME", nullable=false)
	private String name;

	@Column(name = "DESCRIPTION", nullable=false)
	private String description;

	@Column(name = "PHOTO_URL", nullable=true)
	private String photoUrl;

	@Column(name = "START_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startTime;

	@Column(name = "FINISH_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date finishTime;
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
