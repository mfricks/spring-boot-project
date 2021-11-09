package br.com.school.controllers;


import br.com.school.controllers.dto.StudentDto;
import br.com.school.domain.Student;
import br.com.school.exceptions.BadRequestException;
import br.com.school.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(path = "/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<StudentDto> buscarPorId(@PathVariable String id) {

        int identificador = validaParseIntDo(id);
        Student student = studentService.getStudentById(identificador);
        return ResponseEntity.ok(new StudentDto(student));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> cadastrarNovoAluno(@RequestBody Student student, UriComponentsBuilder uriComponentsBuilder) {

        studentService.insertStudent(student);
        URI uri = uriComponentsBuilder.path("/students/{id}").buildAndExpand(student.getId()).toUri();
        return ResponseEntity.created(uri).body(student);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void AlterarAluno(@PathVariable String id, @RequestBody Student student) {

        int identificador = validaParseIntDo(id);
        studentService.updateStudent(identificador, student);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void DeletarAluno(@PathVariable String id) {

        int identificador = validaParseIntDo(id);
        studentService.deleteStudent(identificador);
    }

    private Integer validaParseIntDo(String identificador) {
        try {
            return Integer.parseInt(identificador);
        } catch (Exception e) {
            throw new BadRequestException("A requisição precisa de um id válido");
        }
    }
}
