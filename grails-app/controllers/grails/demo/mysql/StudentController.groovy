package grails.demo.mysql

import org.apache.commons.logging.LogFactory;

import grails.demo.mysql.Student;

class StudentController {

	private static final log = LogFactory.getLog(this)

	StudentController(){
		log.info("info log StudentController")
		log.error("error in StudentController")
	}
	
	def scaffold = Student
}
