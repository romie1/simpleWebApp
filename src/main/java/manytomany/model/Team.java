package manytomany.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.Hibernate;

@Entity(name = "teamManyToMany")
@Table(name = "TEAMS")
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TeamGen")
	@SequenceGenerator(sequenceName = "TEAM_SEQ", allocationSize = 1, name = "TeamGen")
	@Column(name = "team_id")
	private int id;

	private String name;

	@OneToOne(optional = false)
	@JoinColumn(name = "leader_id")
	private Coder leader;

	@ManyToMany
	@JoinTable(name = "team_coder", joinColumns = @JoinColumn(name = "team_id"), inverseJoinColumns = @JoinColumn(name = "coder_id"))
	private Set<Coder> coders;

	public Team() {
	}

	public Team(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Coder getLeader() {
		return leader;
	}

	public void setLeader(Coder leader) {
		this.leader = leader;
	}

	public Set<Coder> getCoders() {
		return coders;
	}

	public void setCoders(Set<Coder> coders) {
		this.coders = coders;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(String.format("Team name = %s - Leader = %s", name, leader));
		if (Hibernate.isInitialized(coders)) {
			sb.append(" - Coders = ").append(coders);
		}
		return sb.toString();
	}

}
