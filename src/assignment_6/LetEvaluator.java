package assignment_6;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.SExpression;

public class LetEvaluator implements Evaluator{

	@Override
	public SExpression eval(SExpression arg0, Environment arg1) {
		// TODO Auto-generated method stub
		System.out.println("Let: " + arg0);
		Environment child = arg1.newChild();
		
		SExpression storing = arg0.getTail().getHead();
		try {
			while (storing.getTail() != null) {
				SExpression element = storing.getHead();
				child.assign(new CustomAtom(element.getHead().toString()), element.getTail().getHead().eval(arg1));
				storing = storing.getTail();
			}
		} catch(Exception c) {}
		
		return arg0.getTail().getTail().getHead().eval(child);
	}

}
