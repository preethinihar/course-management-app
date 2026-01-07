package com.example.demo;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:5173")
@RequestMapping("/api/courses")
public class CourseController {
  private final CourseRepository repo;
  public CourseController(CourseRepository repo){this.repo=repo;}

  @GetMapping public List<Course> all(){ return repo.findAll(); }

  @PostMapping public Course create(@RequestBody Course c){ return repo.save(c); }

  @PutMapping("/{id}") public Course update(@PathVariable Long id, @RequestBody Course c){
    c.setId(id); return repo.save(c);
  }

  @DeleteMapping("/{id}") public void delete(@PathVariable Long id){ repo.deleteById(id); }
}
