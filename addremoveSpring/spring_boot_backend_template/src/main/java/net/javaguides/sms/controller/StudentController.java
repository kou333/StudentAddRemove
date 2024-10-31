package net.javaguides.sms.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import net.javaguides.sms.entity.Student;
import net.javaguides.sms.service.StudentService;

@Controller
public class StudentController {

	
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	
	
	//handler method to handle list student and return mode and view
	
	@GetMapping("/students")
	public String listStudents(Model model)
	{
		model.addAttribute("students",studentService.getAllStudents());
		
		return "students";
		
	}
	
	
	 @GetMapping("/student/new")
	 public String createStudentForm(Model model) {
	     Student student = new Student(); // New empty Student object
	     model.addAttribute("student", student);
	     return "create_student";
	 }

	 @PostMapping("/students")
	 public String saveStudent(@ModelAttribute("student")Student student)
	
	 {
		 studentService.saveStudent(student);
		 return"redirect:/students";
	 }
	 
	 @GetMapping("/students/edit/{id}")
	 public String editStudentForm(@PathVariable Long id,Model model)
	 {
           		 model.addAttribute("student", studentService.getStudentById(id));
	        return "edit_student";
	 }
	 
	 @PostMapping("/students/{id}")
	   public String updateStudent(@PathVariable Long id ,@ModelAttribute("student")Student student ,Model model)
	   {
		 //gte student from database by id
		 
		 Student existingStudent=studentService.getStudentById(id);
		 
		 existingStudent.setId(id);
		 existingStudent.setFirstName(student.getFirstName());
		 
		 existingStudent.setLastName(student.getLastName());
		 
		 existingStudent.setEmail(student.getEmail());
		 
		 //save updatedb stsudent object
		 
		 studentService.updateStudent(existingStudent);
		 return "redirect:/students";
	   }
	   
	   //handler medthod to deleted sudent request
	@GetMapping("/students/{id}")
	 public String deleteStudent(@PathVariable Long id)
	 {
		 studentService.deleteStudentById(id);
		 return "redirect:/students";
		 
	 }
	 
	   
}
