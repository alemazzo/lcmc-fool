package compiler.lib;

import compiler.lib.visit.Visitable;

public abstract class Node implements Visitable {
	
	int line=-1;  // line -1 means unset
	
	public void setLine(int l) { line=l; }

	public int getLine() { return line; }

}

	  