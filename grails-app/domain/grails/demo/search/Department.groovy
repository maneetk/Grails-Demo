package grails.demo.search

class Department {

    String name
	
	String toString(){
		"${this.name}"
	}
    static mapping = {
		version false
    }
}
