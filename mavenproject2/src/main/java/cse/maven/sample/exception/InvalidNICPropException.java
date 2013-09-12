package cse.maven.sample.exception;

public class InvalidNICPropException extends Exception {

	//private static final long serialVersionUID = 1L;

	public InvalidNICPropException() {
		super("Invalid NIC is entered.");
	}
}
