package assignment_6;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.Atom;
import main.lisp.parser.terms.NilAtomicExpressionFactory;
import main.lisp.parser.terms.SExpression;
import main.lisp.parser.terms.TAtomicExpressionFactory;

public class LessThanEqualToEvaluator implements Evaluator {

	@Override
	public SExpression eval(SExpression arg0, Environment arg1) {
		// TODO Auto-generated method stub
		SExpression first = arg0.getTail().getHead();
		if (!(first instanceof Atom)) {
			first = first.eval(arg1);
		}
		arg0 = arg0.getTail();
		SExpression second = arg0.getTail().getHead();
		if (!(second instanceof Atom)) {
			second = second.eval(arg1);
		}
		
		return Double.parseDouble(first.toString()) <= Double.parseDouble(second.toString()) ? TAtomicExpressionFactory.newInstance(): NilAtomicExpressionFactory.newInstance();
	}
}
