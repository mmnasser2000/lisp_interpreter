package assignment_6;

import java.util.Optional;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.Atom;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.SExpression;

public class EvalEvaluator implements Evaluator {

	@Override
	public SExpression eval(SExpression arg0, Environment arg1) {
		// TODO Auto-generated method stub
		arg0 = arg0.getTail().getHead();
		if (arg0 instanceof Atom) {
			if (arg0.isNIL()) {
				return arg0;
			}
			try {
				Integer.valueOf(arg0.toString());
			} catch (Exception e) {
				Optional<SExpression> atom = arg1.lookup((IdentifierAtom) arg0);
				if (atom.isPresent()) {
					return atom.get();
				}
				return arg0;
			}
			return arg0;
		}

		return evalHelper(arg0, arg1);
	}
	private SExpression evalHelper(SExpression arg0, Environment arg1) {
		if (arg0.getHead().toString().equals("QUOTE")) {
			return eval(arg0, arg1);
		} else {
			return arg0.eval(arg1);
		}
	}

}
