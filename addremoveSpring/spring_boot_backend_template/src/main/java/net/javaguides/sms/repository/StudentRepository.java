//
//package net.javaguides.sms.repository;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import net.javaguides.sms.entity.Student;
//
//public interface StudentRepository extends JpaRepository<Student ,Long>{
//
//
//	
//	
//}
package net.javaguides.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.javaguides.sms.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
