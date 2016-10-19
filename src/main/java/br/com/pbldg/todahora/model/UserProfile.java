package br.com.pbldg.todahora.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "USER_PROFILE", schema="todahora")
@SequenceGenerator(name = "UserProfileSequence", sequenceName = "USER_PROFILE_ID_SQ", initialValue = 1, allocationSize = 1, schema="todahora")
public class UserProfile implements Serializable {

	private static final long serialVersionUID = -6327591337127181910L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UserProfileSequence")
	@Basic(optional = false)
	@Column(name="ID")
	private Long id;

	@Column(name = "TYPE")
	private String type;

	@ManyToMany(mappedBy = "userProfiles")
	private List<User> users;

	public UserProfile() {	}

	public UserProfile(Long id) {
		this.id = id;
	}

	public UserProfile(Long id, String type) {
		this.id = id;
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "todahora.UserProfile[ id=" + id + " ]";
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
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
		UserProfile other = (UserProfile) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
