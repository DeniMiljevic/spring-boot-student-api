package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // 1. SPREMI NOVOG STUDENTA
    public Student spremiStudenta(Student student) {
        return studentRepository.save(student);
    }

    // 2. DOHVATI SVE STUDENTE
    public List<Student> dobaviSveStudente() {
        return studentRepository.findAll();
    }

    // 3. DOHVATI STUDENTA PO ID-u
    public Student dobaviStudentaPoId(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    // UPDATE - AŽURIRAJ STUDENTA
    public Student azurirajStudenta(Long id, Student noviPodaci) {
        Student student = dobaviStudentaPoId(id);
        if (student != null) {
            student.setIme(noviPodaci.getIme());
            student.setPrezime(noviPodaci.getPrezime());
            student.setEmail(noviPodaci.getEmail());
            student.setGodinaStudija(noviPodaci.getGodinaStudija());
            return studentRepository.save(student);
        }
        return null;
    }

    // DELETE - OBRISI STUDENTA
    public boolean obrisiStudenta(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}