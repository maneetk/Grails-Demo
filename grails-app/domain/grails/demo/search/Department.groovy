package grails.demo.search

class Department {

    String name
	String hodName
	Long somelongNumber
	
	String toString(){
		"${this.name}"
	}
    static mapping = {
		version false
    }
	
	static constraints = {
		name()
		hodName()
		somelongNumber()  
	}
}
