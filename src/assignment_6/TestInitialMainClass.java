package assignment_6;

import main.Main;
import main.lisp.evaluator.ExpressionEvaluatorFactory;
import main.lisp.evaluator.environment.EnvironmentFactory;
import main.lisp.parser.terms.ExpressionFactory;
import main.lisp.parser.terms.IdentifierAtomFactory;

public class TestInitialMainClass {
	public static void main(String[] args) {
		ExpressionFactory.setClass(StringFormatter.class);
		ExpressionEvaluatorFactory.setClass(SExpressionLambdaApplication.class);
		
		EnvironmentFactory.setClass(CustomEnvironment.class);
		IdentifierAtomFactory.setClass(CustomAtom.class);
		new OperationsRegistererClass().registerOperations();
		Main.main(args);
	}
}