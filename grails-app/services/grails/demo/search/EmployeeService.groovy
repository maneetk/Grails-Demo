package grails.demo.search

import grails.converters.JSON
import grails.transaction.Transactional
import grails.util.Environment;
import groovy.json.JsonSlurper

@Transactional
class EmployeeService {
	
	def grailsApplication
	
	def fetchPropertyFromConfig(){
		//print the property from Config.groovy
		println grailsApplication.config.grails.project.groupId
		/*
		 * in grails 3.x versions
		 * println "with getProperty" + grailsApplication.config.getProperty('grails.project.groupId')
		println "with []" + grailsApplication.config['grails.project.groupId']*/
	}
	
	def parseJson(){
		def inputFile = new File("/home/maneet/Desktop/address-latlng.json")
		//println "file read and contents - > "  + inputFile.text
		def inputJson = new JsonSlurper().parseText(inputFile.text)
		//inputJson.each { println it}
		
		//Read the JSON from the graph: results(0) -> locations(0) -> displayLatLng -> lat, lng
		println "lat: " + inputJson.results[0].locations[0].displayLatLng.lat
		println "lon: " + inputJson.results[0].locations[0].displayLatLng.lng
	}
	
	def processHttpGet(){
		try {
			def data = new URL('http://ip.jsontest.com/').text
			println "data : " + data
				
			// alternatively use Groovy JDK methods
			println "direct: " + 	'http://ip.jsontest.com/'.toURL().text
			println "direct wrong: " + 	'http://maneet.jsontest.com/'.toURL().text
			
		} catch (Exception e) {
				println "Failed Http call in environment: " + Environment.current
				if(Environment.current == Environment.DEVELOPMENT){
					println "Hurray!! Error in development environment"
				} 
			e.printStackTrace()
		}
		def data = new URL('http://ip.jsontest.com/').text
		println "data : " + data
			
		// alternatively use Groovy JDK methods
		println "direct: " + 	'http://ip.jsontest.com/'.toURL().text
	}

	def toAndFromJson(Department department){
		println "Sel depar " + department
		def deptJson = department as JSON
		println "JSON: "  + deptJson
		
		def newDepartment = new Department(JSON.parse(deptJson.toString()))
		println "converted from json: " + newDepartment
	}
}
