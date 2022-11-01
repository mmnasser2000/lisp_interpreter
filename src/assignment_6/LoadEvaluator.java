package assignment_6;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.interpreter.InterpreterModel;
import main.lisp.interpreter.InterpreterModelSingleton;
import main.lisp.parser.terms.NilAtomicExpressionFactory;
import main.lisp.parser.terms.SExpression;
import main.lisp.parser.terms.TAtomicExpressionFactory;

public class LoadEvaluator  implements Evaluator {

	@Override
	public SExpression eval(SExpression arg0, Environment arg1) {
		// TODO Auto-generated method stub
		InterpreterModel interpreter = InterpreterModelSingleton.get();
		String fileName = ((String) arg0.getTail().getHead().toString()).replace("\"", "");

	    Charset charset = Charset.forName("ISO-8859-1");
		Path filePath = Paths.get(fileName);
	    try {
	    	List<String> lines = Files.readAllLines(filePath, charset);

	      for (String line : lines) {
	    	  interpreter.newInput(line);
	      }
	      return TAtomicExpressionFactory.newInstance();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return NilAtomicExpressionFactory.newInstance();
		}
		
	}

}
