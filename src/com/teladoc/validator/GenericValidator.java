package com.teladoc.validator;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public abstract class GenericValidator<T> implements Predicate<T>{
	
	private List<Predicate<T>> validators;
	
	
	protected GenericValidator() {
		super();
		this.validators = new LinkedList<>();
		this.configureValidators();
	}
	
	

	@Override
	public boolean test(T t) {
		return validators.stream().allMatch(p->p.test(t));
	}
	
	protected abstract void configureValidators();
	
	protected boolean addValidator(Predicate<T> validator) {
		return validators.add(validator);
	}

}
