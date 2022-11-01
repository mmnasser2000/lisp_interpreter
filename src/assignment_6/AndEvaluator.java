package assignment_6;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.NilAtomicExpressionFactory;
import main.lisp.parser.terms.SExpression;

public class AndEvaluator implements Evaluator{

	@Override
	public SExpression eval(SExpression arg0, Environment arg1) {
		// TODO Auto-generated method stub
		arg0 = arg0.getTail();
		return evalHelper(arg0, arg1);
	}
	
	private SExpression evalHelper(SExpression arg0, Environment arg1) {
		if (arg0.getTail().isNIL()) {
			return arg0.getHead().eval(arg1);
		}
		
		if (arg0.getHead().eval(arg1).isNIL()) {
			return NilAtomicExpressionFactory.newInstance();
		} else {
			return eval(arg0, arg1);
		}
		
	}

}
