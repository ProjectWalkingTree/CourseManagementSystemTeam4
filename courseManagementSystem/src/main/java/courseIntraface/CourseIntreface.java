package courseIntraface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import courseEntity.Course;

@Repository
public interface CourseIntreface extends JpaRepository<Course, Long>{

		
	
	
	
}
