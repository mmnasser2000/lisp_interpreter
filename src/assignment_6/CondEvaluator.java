package assignment_6;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.Atom;
import main.lisp.parser.terms.NilAtomicExpressionFactory;
import main.lisp.parser.terms.SExpression;
import main.lisp.parser.terms.TAtomicExpressionFactory;

public class CondEvaluator implements Evaluator {

	@Override
	public SExpression eval(SExpression arg0, Environment arg1) {
		// TODO Auto-generated method stub
		arg0 = arg0.getTail();
		if (arg0.isNIL()) {
			return NilAtomicExpressionFactory.newInstance();
		}		
		if (length(arg0.getHead()) == 1) {
			if (length(arg0) == 1) {
				String s;
				if (arg0 instanceof Atom) {
					s = arg0.toString();
				} else {
					s = arg0.getHead().toString();
				}
				if (s.equals("(T)")) {
					return TAtomicExpressionFactory.newInstance();
				} else if (s.equals("(NIL)")) {
					return NilAtomicExpressionFactory.newInstance();
				} else {
					return arg0.getTail().eval(arg1);
				}
			} else {
				arg0 = arg0.getTail().getHead().getHead();
				return arg0.eval(arg1);
			}
			
		}
	
		return evalHelper(arg0, arg1);
	}
	
	private SExpression evalHelper(SExpression arg0, Environment arg1) {
		SExpression cond = arg0.getHead().getHead();
		if(!cond.eval(arg1).isNIL()) {
			SExpression statement = arg0.getHead().getTail().getHead().eval(arg1);
			return statement;
		} else {
			arg0 = arg0.getTail();
			return evalHelper(arg0, arg1);
		}
	}
	private int length(SExpression arg0) {
		if (arg0.isNIL()) {
			return 0;
		}
		return 1 + length(arg0.getTail());
	}

}
