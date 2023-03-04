package compiler.lib.node;

import compiler.lib.visit.Visitable;

/**
 * A node in the AST.
 */
public abstract class Node implements Visitable {

	private int line = -1;  // line -1 means unset

	public int getLine() {
		return line;
	}

	public void setLine(int l) {
		line = l;
	}

}

	  