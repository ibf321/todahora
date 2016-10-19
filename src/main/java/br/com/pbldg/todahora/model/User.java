package br.com.pbldg.todahora.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "USER", schema = "todahora")
@SequenceGenerator(name="UserSequence", sequenceName="USER_ID_SQ", allocationSize=1, initialValue=1, schema="todahora")
public class User implements Serializable {

	private static final long serialVersionUID = -8793738068211537546L;

	public User() {	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UserSequence")
	private Long id;

	@Column(name = "PASSWORD", nullable = false)
	private String password;

	@Column(name = "EMAIL", length = 200, nullable = false, unique = true)
	private String email;
	
	@Column(name = "enabled")
	private Boolean enabled;	

	@OneToMany(mappedBy="user")
	private List<Track> tracks;

	@OneToMany(mappedBy = "user")
	private List<Event> events;

	@JoinTable(name = "AUTHORITY", schema="todahora", joinColumns = { 
			@JoinColumn(name = "USER_ID", referencedColumnName = "ID") 
		}, inverseJoinColumns =	{
			@JoinColumn(name = "USER_PROFILE_ID", referencedColumnName = "ID") 
		})
	@ManyToMany(fetch = FetchType.EAGER)
	private List<UserProfile> userProfiles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public List<Track> getTracks() {
		return tracks;
	}

	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}

	public List<UserProfile> getUserProfiles() {
		return userProfiles;
	}

	public void setUserProfiles(List<UserProfile> userProfiles) {
		this.userProfiles = userProfiles;
	}

	public Boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

}
