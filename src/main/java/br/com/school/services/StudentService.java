package br.com.school.services;

import br.com.school.domain.Student;
import br.com.school.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.school.repositories.StudentRepository;


@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public void insertStudent(Student student) {
        studentRepository.save(student);
    }

    public Student getStudentById(Integer id){
        return studentRepository.findById(id).orElseThrow(() -> new NotFoundException("Não foi encontrado o estudante"));
    }

    public void updateStudent(int identificador, Student newStudentData) {
        Student currentStudentData = getStudentById(identificador);
        currentStudentData.setName(newStudentData.getName());
        currentStudentData.setAge(newStudentData.getAge());
        currentStudentData.setEmail(newStudentData.getEmail());
        studentRepository.save(currentStudentData);
    }

    public void deleteStudent(int identificador) {
        Student student = getStudentById(identificador);
        studentRepository.delete(student);
    }
}
