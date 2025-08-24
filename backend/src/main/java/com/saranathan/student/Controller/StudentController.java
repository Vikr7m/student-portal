package com.saranathan.student.Controller;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;


import com.saranathan.student.DTOs.StudentDashboardDTO;
import com.saranathan.student.DTOs.StudentLoginDTO;
import com.saranathan.student.DTOs.StudentProfileDTO;
import com.saranathan.student.DTOs.StudentProjectDTO;
import com.saranathan.student.DTOs.TimetableDTO1;
import com.saranathan.student.Model.ProjectDTO;
import com.saranathan.student.Service.JWTService;
import com.saranathan.student.Service.ProjectDTOService;
import com.saranathan.student.Service.StudentDashboardDTOService;
import com.saranathan.student.Service.StudentProfileDTOService;
import com.saranathan.student.Service.TimetableDTO1Service;
import com.saranathan.student.Service.UserService;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {
	
	private String email;
	byte[] imageData;
	
	@Autowired
	private UserService service;
	
	@Autowired
	StudentDashboardDTOService dashboardService;
	
	@Autowired
	ProjectDTOService projectDTOService;
	
	@Autowired
	private JWTService jwtService;
	
	@Autowired
	private TimetableDTO1Service timetableService;
	
	@Autowired
	private StudentProfileDTOService profileService;
	
	 @PostMapping("/register")
	 public StudentLoginDTO register(@RequestBody StudentLoginDTO user) {
	        return service.register(user);

	    }
	
	@PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody StudentLoginDTO user) {
		String token = service.verify(user);
		//System.out.println("Received login for: " + user.getUsername());
		System.out.println("Generated Token: " + token);
		email = jwtService.extractUserName(token);
		
		Map<String, String> response = new HashMap<>();
	    response.put("token", token);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
	
	@GetMapping("/{id}/image")
	public ResponseEntity<byte[]> getImageData(@PathVariable Integer id){
		System.out.println("******************** "+id);
		byte[] result = dashboardService.getImageData(id);
		if (result == null) {
            return ResponseEntity.notFound().build();
        }
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType("image/jpeg")) // or IMAGE_PNG depending on your uploads
                .body(result);
	}
	
	@PostMapping("/{id}/update-image")
	public ResponseEntity<String> updateImage(@PathVariable Integer id, @RequestParam("coverImage") MultipartFile file){
		
		try {
			String fileName = file.getOriginalFilename();
            long size = file.getSize();
            imageData = file.getBytes();
            dashboardService.updateStudentImage(id, imageData);
            System.out.println("Image size :"+size+"\nImage name :"+fileName+"\nImage Data :"+imageData);
            return ResponseEntity.ok("Image uploaded : " + fileName);
            
		} catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Upload failed: " + e.getMessage());
        }
	}
	
	@PostMapping("/{id}/edit-project")
	public ResponseEntity<String> uploadImage(
			@PathVariable Integer id,
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("link") String link,
            @RequestParam("technologies") List<String> technologies,
            @RequestParam("coverImage") MultipartFile file) {
        try {
            // Text fields
            System.out.println("Title: " + title);
            System.out.println("Description: " + description);
            System.out.println(link+"\n"+technologies);

            // File details
            String fileName = file.getOriginalFilename();
            long size = file.getSize();
            imageData = file.getBytes();
            
            ProjectDTO projectDTO = new ProjectDTO();
            projectDTO.setTitle(title);
            projectDTO.setDescription(description);
            projectDTO.setProjectLink(link);
            projectDTO.setTags(technologies);
            projectDTO.setBatchNo(id);
            projectDTO.setCoverImage(imageData);
            projectDTOService.addProject(projectDTO);
            
            System.out.println(imageData);

            // ✅ Store text + image in database
            // You could map this into an Entity
            // Example:
            // ProjectEntity project = new ProjectEntity(title, description, imageData);
            // projectRepository.save(project);

            return ResponseEntity.ok("Uploaded project: " + title + " with file " + fileName);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Upload failed: " + e.getMessage());
        }
    }
	
	@GetMapping("/dashboard")
	public ResponseEntity<StudentDashboardDTO> dashboard() {
	    return ResponseEntity.ok(dashboardService.getStudentDashboardDetails(email));
	}
	
	@GetMapping("/timetable/{date}")
	public ResponseEntity<TimetableDTO1> timetable(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
		System.out.println("Fetching timetable for: " + date + " and user: " + email);
		return ResponseEntity.ok(timetableService.getTimetableDTO1Details(date, email));
	}
	
	@GetMapping("/profile")
	public ResponseEntity<StudentProfileDTO> profile(){
		return ResponseEntity.ok(profileService.getStudentProfileDTODetails(email));
	}
	
	
	

}
