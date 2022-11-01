package assignment_6;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.Atom;
import main.lisp.parser.terms.NilAtomicExpressionFactory;
import main.lisp.parser.terms.SExpression;
import main.lisp.parser.terms.TAtomicExpressionFactory;

public class NotEvaluator implements Evaluator {

	@Override
	public SExpression eval(SExpression arg0, Environment arg1) {
		// TODO Auto-generated method stub		
		SExpression r = arg0.getTail().getHead().eval(arg1);
		if (r.toString().equals("NIL")) {
			return TAtomicExpressionFactory.newInstance();
		}
		return NilAtomicExpressionFactory.newInstance();
	}

}
