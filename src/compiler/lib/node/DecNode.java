package compiler.lib.node;

import compiler.lib.TypeNode;

/**
 * A declaration node in the AST.
 */
public abstract class DecNode extends Node {

	protected TypeNode type;

	public TypeNode getType() {
		return type;
	}

}
