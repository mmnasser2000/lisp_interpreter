package assignment_6;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.ExpressionFactory;
import main.lisp.parser.terms.SExpression;

public class ConsEvaluator  implements Evaluator {

	@Override
	public SExpression eval(SExpression arg0, Environment arg1) {
		// TODO Auto-generated method stub
		
		SExpression head = arg0.getHead();
		SExpression tail = arg0.getTail();
		
		SExpression ret = ExpressionFactory.newInstance(head, tail);
		
		return ret;
	}

}
