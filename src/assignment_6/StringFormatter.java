package assignment_6;

import main.lisp.parser.terms.Atom;
import main.lisp.parser.terms.BasicExpression;
import main.lisp.parser.terms.SExpression;

public class StringFormatter extends BasicExpression implements SExpression {

	public StringFormatter(SExpression head, SExpression tail) {
		super(head, tail);
	}

	@Override
	public boolean isList() {
		// TODO Auto-generated method stub
		if (this.getTail().isNIL()) {
			return true;
		}
		if (this.getTail() == null) {
			return false;
		}
		return this.getTail().isList();
	}

	@Override
	public String toStringAsList() {
		// TODO Auto-generated method stub
		String ret = this.getHead().toString();
		if (!this.getTail().isNIL()) { 
			if (this.getTail().isList() || this.getTail().isNIL()) {
				ret = ret + " " + this.getTail().toStringAsList(); 
			} else {
				ret = ret + " " + this.getTail().toString(); 	
			}
		}
		
		return ret;

	}
	
	@Override
	public String toStringAsListHelperPublic() {
		if (this.getHead() instanceof Atom && this.getTail().isNIL()) {

			return "(" + this.toStringAsList() + ")";
		}
		if (!this.getHead().isList() && this.getTail().isNIL()) {
			return this.toStringAsList();
		}
		if (!this.getHead().isAtom() && this.getTail().isNIL()) {
			return this.toStringAsList();
		}
		return "(" + this.toStringAsList() + ")";
	}

	@Override
	public String toStringAsSExpression() {
		// TODO Auto-generated method stub
		return "(" + this.getHead().toString() + " . " + this.getTail().toString() + ")";
	}

	@Override
	public String toStringAsSExpressionDeep() {

		return  "(" + this.getHead().toStringAsSExpressionDeep() +
		         " . " +
		         this.getTail().toStringAsSExpressionDeep() + ")";	
		}
	
	public String toString() {
		return this.isList()? this.toStringAsListHelperPublic(): this.toStringAsSExpression();
	}

	@Override
	public boolean isAtom() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isNIL() {
		// TODO Auto-generated method stub
		return false;
	}
}
