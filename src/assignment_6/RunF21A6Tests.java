package assignment_6;
import gradingTools.comp524f21.assignment6.F21Assignment6Suite;
import trace.grader.basics.GraderBasicsTraceUtility;
import util.trace.Tracer;

public class RunF21A6Tests {
	
	public static void main (String[] args) {
		Tracer.showInfo(true);
		GraderBasicsTraceUtility.setBufferTracedMessages(true);
		F21Assignment6Suite.main(args);
	}
}
