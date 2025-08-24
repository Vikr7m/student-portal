package com.saranathan.student.Service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.saranathan.student.Model.*;
import com.saranathan.student.Repository.StaffRepository;
import com.saranathan.student.Repository.StudentRepository;

import lombok.RequiredArgsConstructor;


/**@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepo.findByUsername(username);
        if (user == null) {
            System.out.println("User Not Found");
            throw new UsernameNotFoundException("user not found");
        }
        
        return new UserPrincipal(user);
    }
}**/

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
    private StudentRepository studentRepository;
    
	//private final StaffRepository staffRepository = null;

    @Override
    public UserDetails loadUserByUsername(String input) throws UsernameNotFoundException {
        // input can be email or username
    	
    	System.out.println("******** loadUserByUsername triggered for: " + input);

        Optional<Student> studentOpt = studentRepository.findByEmail(input);
        if (studentOpt.isPresent()) {
            Student s = studentOpt.get();
            return new UserPrincipal(s.getUsername(), s.getPassword());
        }

        /**Optional<Staff> staffOpt = staffRepository.findByEmail(input);
        if (staffOpt.isPresent()) {
            Staff s = staffOpt.get();
            return new UserPrincipal(s.getUsername(), s.getPassword(), Role.ROLE_STAFF);
        }**/

        throw new UsernameNotFoundException("User not found with email: " + input);
    }
}

