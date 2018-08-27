package com.rz.repository.s;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rz.domain.s.Student;


public interface StudentRepository extends JpaRepository<Student, Long>{

}
