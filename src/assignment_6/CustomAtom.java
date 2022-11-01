package assignment_6;

import java.util.Optional;

import main.lisp.scanner.tokens.Token;
import main.lisp.evaluator.Environment;
import main.lisp.evaluator.environment.EnvironmentFactory;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.NilAtomicExpressionFactory;
import main.lisp.parser.terms.SExpression;

public class CustomAtom extends IdentifierAtom {

	public CustomAtom(String string) {
		super(string);
		// TODO Auto-generated constructor stub
	}
	public CustomAtom(Token token) {
		super(token);
	}
	
	@Override
	public SExpression eval(Environment environment) {
		Optional<SExpression> s = environment.lookup(this);
		if (s.isPresent()) {
			return s.get();
		} else {
			return NilAtomicExpressionFactory.newInstance();
		}
	}

}
