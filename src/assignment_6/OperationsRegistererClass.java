package assignment_6;

import main.lisp.evaluator.BuiltinOperationManagerSingleton;
import main.lisp.evaluator.OperationRegisterer;

public class OperationsRegistererClass implements OperationRegisterer {

	@Override
	public void registerOperations() {
		// TODO Auto-generated method stub
		OperationsRegistererClass.registerAll();
		BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("setq", new SetqEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("lambda", new LambdaEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("funcall", new FuncallEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("function", new FunctionEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("let", new LetEvaluator());
	}

	public static void registerComparison() {
		BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew(">", new GreaterThanEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("<", new LessThanEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew(">=", new GreaterThanEqualToEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("<=", new LessThanEqualToEvaluator());
	}

	public static void registerExpressionFunctions() {
		BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("load", new LoadEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("quote", new QuoteEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("list", new ListEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("cons", new ConsEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("eval", new EvalEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("cond", new CondEvaluator());
	}
	
	public static void registerLogical() {
		BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("not", new NotEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("or", new OrEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("and", new AndEvaluator());
	}
	
	public static void registerAll() {
		OperationsRegistererClass.registerExpressionFunctions();
		OperationsRegistererClass.registerComparison();
		OperationsRegistererClass.registerLogical();
	}

}
