package courseEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Course {



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String course;
	private int fee;
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Course(Long id, String studentname, String course, int fee) {
		super();
		this.id = id;

		this.course = course;
		this.fee = fee;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}


	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}

}
