package assignment_6;

import main.lisp.evaluator.BasicExpressionEvaluator;
import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.evaluator.function.Lambda;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.SExpression;

public class SExpressionLambdaApplication extends BasicExpressionEvaluator implements Evaluator {
	
	@Override
	public SExpression eval(SExpression expr, Environment environment) {
		try {
			if (expr.getHead().getHead().toString().equals("LAMBDA")) {
				SExpression evaluatedLambda = expr.getHead().eval(environment);
				SExpression input = expr.getTail();
				Environment childEnvironment = new CustomEnvironment(environment).newChild();
				IdentifierAtom[] evaluatedLambdaArgsNames = ((Lambda) evaluatedLambda).getArgumentNames();

				for(int counter = 0; counter < evaluatedLambdaArgsNames.length; counter++) {
					childEnvironment.assign(evaluatedLambdaArgsNames[counter], input.getHead().eval(environment));
					input = input.getTail();
				}
				
				return expr.getHead().getTail().getTail().getHead().eval(childEnvironment);
			}
			return basicEval(expr, environment);
		} catch (Exception e) {
			return basicEval(expr, environment);
		}
	}
	
	private SExpression basicEval(SExpression expr, Environment environment) {
		return new BasicExpressionEvaluator().eval(expr, environment);
	}

}
