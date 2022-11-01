package assignment_6;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.ExpressionFactory;
import main.lisp.parser.terms.SExpression;

public class ListEvaluator implements Evaluator {

	@Override
	public SExpression eval(SExpression arg0, Environment arg1) {
		// TODO Auto-generated method stub
		arg0 = arg0.getTail();
		return evalHelper(arg0, arg1);
	}
	
	private SExpression evalHelper(SExpression arg0, Environment arg1) {
		SExpression head = arg0.getHead().eval(arg1);
		SExpression tail = arg0.getTail();
		
		if (tail.isNIL()) {
			return ExpressionFactory.newInstance(head, tail);
		} else {
			return ExpressionFactory.newInstance(head, evalHelper(arg0.getTail(), arg1));
		}
		
	}
}
