package zc.study.struts1.action;

import java.io.PrintStream;

import javax.naming.Context;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;

/**
 * Dump a JNDI tree to the output.
 *
 * @author t048981
 */
public class JNDITree {
	private Context context = null;
	private PrintStream out;

	public JNDITree(Context context) throws NamingException {
		this.context = context;
		this.out = System.out;
	}

	public JNDITree on(PrintStream out) {
		this.out = out;
		return this;
	}
	
	public void printJNDITree(String ctxName) {
		try {
			NamingEnumeration<NameClassPair> list = context.list(ctxName);
			printNE(list, ctxName);
		} catch (NamingException e) {
			// ignore leaf node exception
		}
	}

	private void printNE(NamingEnumeration<?> ne, String parentctx)
			throws NamingException {
		while (ne.hasMoreElements()) {
			NameClassPair next = (NameClassPair) ne.nextElement();
			out.println(indent() + next);
			increaseIndent();

			printJNDITree((parentctx.length() == 0) ? next.getName()
					: parentctx + "/" + next.getName());

			decreaseIndent();
		}
	}

	private int indentLevel = 0;

	private void increaseIndent() {
		indentLevel += 4;
	}

	private void decreaseIndent() {
		indentLevel -= 4;
	}

	private String indent() {
		StringBuffer buf = new StringBuffer(indentLevel);
		for (int i = 0; i < indentLevel; i++) {
			buf.append(" ");
		}
		return buf.toString();
	}
}