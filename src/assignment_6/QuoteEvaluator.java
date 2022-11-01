package assignment_6;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.SExpression;

public class QuoteEvaluator implements Evaluator {


	@Override
	public SExpression eval(SExpression expr, Environment environment) {
		expr = expr.getTail();
		return expr;
		
	}

}