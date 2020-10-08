package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TEAMS")
public class Team {
    
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TeamGen")
    @SequenceGenerator(sequenceName = "TEAM_SEQ", allocationSize = 1, name = "TeamGen")
    @Column(name = "team_id")
    private int id;

    private String name;

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

	@Override
	public String toString() {
		return String.format("Team: id=%s -  name=%s]", id, name);
	}

    
}
