package university.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import university.student.entity.Student;
import university.student.repository.Repository;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "*")
public class Controller {
    @Autowired
    private Repository repo;

    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return repo.findAll();
    }


    @PostMapping("/add")
    public Student createStudent(@RequestBody Student student) {
        return repo.save(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        student.setId(id);
        return repo.save(student);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
