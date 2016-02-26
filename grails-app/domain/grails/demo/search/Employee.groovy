package grails.demo.search

class Employee {

    String firstName
	String lastName
	Department department
	
    static mapping = {
		version false
    }
}
