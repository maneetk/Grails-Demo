package grails.demo.helloWorld

import org.apache.commons.logging.LogFactory;

class HelloWorld2Controller {
	
	private static final log = LogFactory.getLog(this)

    //def test2() { 
		//render 'Hello World!';
	//}
	
	//this returns the test page in views/helloWorld2/test.gsp
	def test() {
		log.info("in test")
		log.error("error in test")
	}
	 
}
