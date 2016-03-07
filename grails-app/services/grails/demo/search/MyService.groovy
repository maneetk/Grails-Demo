package grails.demo.search

import grails.transaction.Transactional

@Transactional
class MyService {

    def serviceMethod() {
		println "service test"
    }
}
