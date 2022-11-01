package assignment_6;

import java.util.Optional;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.environment.AbstractEnvironment;
import main.lisp.evaluator.function.Function;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.SExpression;

public class CustomEnvironment extends AbstractEnvironment {

	// must have public constructor that calls this in your version
	// called by factory, must be accessible
	public CustomEnvironment() {
		super();
	}

	// must have constructor that calls this in your version
	// called in your version to make child
	public CustomEnvironment(Environment parent) {
		super(parent);
	}
		
	@Override
	public void assign(IdentifierAtom arg0, SExpression arg1) {
		// TODO Auto-generated method stub
		put(arg0, arg1);
	}

	@Override
	public void assignFun(IdentifierAtom arg0, Function arg1) {
		// TODO Auto-generated method stub
		putFun(arg0, arg1);
	}

	@Override
	public Environment copy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<SExpression> lookup(IdentifierAtom arg0) {
		// TODO Auto-generated method stub
		return get(arg0);
	}

	@Override
	public Optional<Function> lookupFun(IdentifierAtom arg0) {
		// TODO Auto-generated method stub
		return getFun(arg0);
	}

	@Override
	public Environment newChild() {
		// TODO Auto-generated method stub
		return new CustomEnvironment(getParent());
	}

}
