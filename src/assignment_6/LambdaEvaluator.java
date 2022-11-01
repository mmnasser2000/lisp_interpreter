package assignment_6;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.SExpression;
import main.lisp.evaluator.function.LambdaFactory;

public class LambdaEvaluator implements Evaluator {

	@Override
	public SExpression eval(SExpression arg0, Environment arg1) {
		// TODO Auto-generated method stub
		SExpression body = arg0.getTail().getTail().getHead();
		SExpression parameters = arg0.getTail().getHead();

		int amountOfParameters = length(arg0.getTail().getHead());
		IdentifierAtom[] atoms = new IdentifierAtom[amountOfParameters];
		for (int counter = 0; counter < amountOfParameters; counter++) {
			atoms[counter] = new CustomAtom(parameters.getHead().toString());
			parameters = parameters.getTail();
		}
		
		if (body.getHead().toString().equals("FUNCTION")) {
			arg1 = arg1.newChild();
			body.eval(arg1);
		}

		return LambdaFactory.newInstance(atoms, body);
	}
	
	private int length(SExpression arg0) {
		if (arg0.isNIL()) {
			return 0;
		}
		return 1 + length(arg0.getTail());
	}

}
