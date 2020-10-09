package onetoone.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CODERS")
public class Coder {
   
	@Id
    @Column(name = "coder_id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "hire_date")
    private LocalDate hireDate;

    private Double salary;
    
    @OneToOne(optional = true, mappedBy = "leader")
    private Team leadingTeam;

    public Coder() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    
	public Team getLeadingTeam() {
		return leadingTeam;
	}

	public void setLeadingTeam(Team leadingTeam) {
		this.leadingTeam = leadingTeam;
	}

	@Override
	public String toString() {
		return String.format("Coder id = %s, First Name = %s, Last Name = %s, Hire Date = %s, Salary = %s, Leading Team = %s", id, firstName,
				lastName, hireDate, salary, leadingTeam != null ? leadingTeam.getName() : "" );
	}
    
    
}
