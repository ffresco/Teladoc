package com.teladoc.validator;

public class NumberValidator extends GenericValidator<Double>{

	
	private NumberValidator() {
		super();
	}
	
	private static NumberValidator instance = null;

	public static NumberValidator getInstance() {
		if (instance == null)
			instance = new NumberValidator();

		return instance;
	}

	
	protected void configureValidators() {
		addValidator(n->n>=0);
	}


	
	

}
