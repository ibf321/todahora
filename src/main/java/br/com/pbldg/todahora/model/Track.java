package br.com.pbldg.todahora.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TRACK", schema="todahora")
@SequenceGenerator(name = "TrackSequence", sequenceName = "TRACK_ID_SQ", allocationSize = 1, schema="todahora")
public class Track implements Serializable {
		
	private static final long serialVersionUID = -22182505811411503L;

	@Id
	@GeneratedValue(generator = "TrackSequence", strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name="TITLE", nullable=false)
	private String title;
	
	@Column(name="BAND", nullable=false)
	private String band;
	
	@Column(name="ALBUM", nullable=true)
	private String album;
	
	@Column(name="YEAR", nullable=true)
	private Integer year;
	
	@Column(name="GENRE", nullable=true)
	private String genre;
	
	@Column(name="DURATION", nullable=true)
	private String duration;
	
	@Column(name="TRACK_PATH", nullable=false)
	private String trackPath;

	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;
	
	public Track(){}
	
	public Track(String title, String band, String album, Integer year, String genre, String duration) {
		this.title = title;
		this.band = band;
		this.album = album;
		this.year = year;
		this.genre = genre;
		this.duration = duration;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBand() {
		return band;
	}

	public void setBand(String band) {
		this.band = band;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Long getId() {
		return id;
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
		Track other = (Track) obj;
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

	public String getTrackPath() {
		return trackPath;
	}

	public void setTrackPath(String trackPath) {
		this.trackPath = trackPath;
	}

}
