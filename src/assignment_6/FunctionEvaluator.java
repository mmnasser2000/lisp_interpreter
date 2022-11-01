package assignment_6;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.evaluator.function.FunctionFactory;
import main.lisp.evaluator.function.Lambda;
import main.lisp.parser.terms.SExpression;

public class FunctionEvaluator implements Evaluator {

	@Override
	public SExpression eval(SExpression arg0, Environment arg1) {
		// TODO Auto-generated method stub
		arg0 = arg0.getTail().getHead();

		return FunctionFactory.newInstance((Lambda) arg0.eval(arg1), arg1.getParent());
	}

}
