package com.teladoc.validator;

public class StringToNumberValidator extends GenericValidator<String>{

	
	private StringToNumberValidator() {
		super();
	}
	
	private static StringToNumberValidator instance = null;

	public static StringToNumberValidator getInstance() {
		if (instance == null)
			instance = new StringToNumberValidator();

		return instance;
	}

	
	protected void configureValidators() {
		addValidator(s->s!=null);
		addValidator(s->!s.isEmpty());
		addValidator(s->s.matches("-?\\d+(\\.\\d+E?(\\d+)?)?"));
	}


	
	

}
