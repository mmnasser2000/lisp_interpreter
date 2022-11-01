package assignment_6;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.ExpressionFactory;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.SExpression;

public class FuncallEvaluator implements Evaluator {

	@Override
	public SExpression eval(SExpression arg0, Environment arg1) {
		// TODO Auto-generated method stub
		SExpression s;
		SExpression ret = null;
		arg0 = arg0.getTail();
		try {
			if(arg1.lookup((IdentifierAtom) arg0.getHead()).isPresent()) {
				s = arg1.lookup((IdentifierAtom) arg0.getHead()).get();
				ret = new SExpressionLambdaApplication().eval(ExpressionFactory.newInstance(s, arg0.getTail()), arg1);
				System.out.println("s1: " + s);
			} else {
				s = new SExpressionLambdaApplication().eval(arg0, arg1);
				System.out.println("s2: " + s);
			}
		}catch (Exception e) {
			 ret = new SExpressionLambdaApplication().eval(arg0, arg1);
			System.out.println("s3: " + ret);
			
		}
		
		return ret;
	}

}
