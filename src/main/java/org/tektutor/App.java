package org.tektutor;

public class App {

	public String sayHello() {
		return "Hello Maven!";
	}

	public String someLowPriorityNewFeature() {
		System.out.println ( "Work in Progress ..." );
	}

	public static void main ( String args[] ) {		
		App obj = new App();
		System.out.println ( obj.sayHello() );
	}
	
}
