package compiler.lib.type;

import compiler.ast.type.BoolTypeNode;
import compiler.ast.type.IntTypeNode;
import compiler.lib.node.TypeNode;

/**
 * Type relations utility class.
 */
public class TypeRelations {

    /**
     * Check if a is subtype of b
     *
     * @param a - type a
     * @param b - type b
     * @return true if a is subtype of b, false otherwise
     */
    public static boolean isSubtype(final TypeNode a, final TypeNode b) {
        return a.getClass().equals(b.getClass()) || ((a instanceof BoolTypeNode) && (b instanceof IntTypeNode));
    }

}
