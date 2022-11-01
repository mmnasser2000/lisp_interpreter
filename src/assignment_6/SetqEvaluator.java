package assignment_6;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.evaluator.function.Function;
import main.lisp.parser.terms.SExpression;

public class SetqEvaluator implements Evaluator {

	@Override
	public SExpression eval(SExpression arg0, Environment arg1) {
		// TODO Auto-generated method stub
		SExpression E1 = arg0.getTail().getHead();
		SExpression unevaluatedE2 = arg0.getTail().getTail().getHead();
		SExpression evaluatedE2 = unevaluatedE2.eval(arg1);
		SExpression finalE2;
		CustomAtom atom = new CustomAtom(E1.toString());
		try {
			if (arg0.getTail().getTail().getHead().getHead().toString().equals("LAMBDA")) {
				finalE2 = unevaluatedE2;
				arg1.assign(atom, finalE2);
			} /*else if (arg0.getTail().getTail().getHead().getTail().getTail().getHead().getHead().toString().equals("FUNCTION")) {
				finalE2 = arg0.getTail().getTail().getHead().getTail().getTail().getHead().eval(arg1);
				arg1.assignFun(atom, (Function) finalE2);
			}*/ 
			else {
			
				finalE2 = evaluatedE2;
				arg1.assign(atom, finalE2);
			}
		} catch (Exception e) {
			finalE2 = evaluatedE2;
			arg1.assign(atom, finalE2);
		}
		
		atom.eval(arg1);
		return finalE2;
	}

}
