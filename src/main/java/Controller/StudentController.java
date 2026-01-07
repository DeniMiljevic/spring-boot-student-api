package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/studenti")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // 1. DODAJ NOVOG STUDENTA
    @PostMapping
    public ResponseEntity<Student> spremiStudenta(@Valid @RequestBody Student student) {
        Student spremljenStudent = studentService.spremiStudenta(student);
        return ResponseEntity.ok(spremljenStudent);
    }

    // 2. DOHVATI SVE STUDENTE
    @GetMapping
    public ResponseEntity<List<Student>> dobaviSveStudente() {
        List<Student> studenti = studentService.dobaviSveStudente();
        return ResponseEntity.ok(studenti);
    }

    // 3. DOHVATI JEDNOG STUDENTA
    @GetMapping("/{id}")
    public ResponseEntity<Student> dobaviStudentaPoId(@PathVariable Long id) {
        Student student = studentService.dobaviStudentaPoId(id);
        if (student != null) {
            return ResponseEntity.ok(student);
        }
        return ResponseEntity.notFound().build();
    }

    // UPDATE - AŽURIRAJ STUDENTA
    @PutMapping("/{id}")
    public ResponseEntity<Student> azurirajStudenta(@PathVariable Long id,@Valid @RequestBody Student student) {
        Student azuriranStudent = studentService.azurirajStudenta(id, student);
        if (azuriranStudent != null) {
            return ResponseEntity.ok(azuriranStudent);
        }
        return ResponseEntity.notFound().build();
    }

    // DELETE - OBRISI STUDENTA
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> obrisiStudenta(@PathVariable Long id) {
        if (studentService.obrisiStudenta(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}