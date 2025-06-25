package university.student.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import university.student.entity.Student;

@Component
public interface Repository extends JpaRepository<Student, Long> {

}
