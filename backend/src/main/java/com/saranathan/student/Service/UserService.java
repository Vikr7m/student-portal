package com.saranathan.student.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.saranathan.student.DTOs.StudentLoginDTO;
import com.saranathan.student.Model.Student;
import com.saranathan.student.Repository.StudentRepository;

@Service
public class UserService {

    @Autowired
    private JWTService jwtService;

    @Autowired
    AuthenticationManager authManager;

    
    
    @Autowired
    private StudentRepository studentRepo;


    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public StudentLoginDTO register(StudentLoginDTO student) {
    	Student stud = new Student();
    	stud.setUsername(student.getUsername());
        stud.setPassword(encoder.encode(student.getPassword()));
        studentRepo.save(stud);
        return student;
    }

    public String verify(StudentLoginDTO student) {
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(student.getUsername(), student.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(student.getUsername());
        } else {
            return "fail";
        }
    }
}
