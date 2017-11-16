package cs5500.project.engine.ast;

import cs5500.project.engine.CustomComparator;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.StructuralPropertyDescriptor;

import java.util.Iterator;
import java.util.List;

public class ASTTreeCompare {

    @SuppressWarnings("unchecked")
    public static boolean compare(ASTNode ast1, ASTNode ast2) {
        // if both are null, they are equal, but if only one, they aren't
        if (ast1 == null && ast2 == null) {
            return true;
        } else if (ast1 == null || ast2 == null) {
            return false;
        }
        // if node types are the same we can assume that they will have the same
        // properties
        if (ast1.getNodeType() != ast2.getNodeType()) {
            return false;
        }

        List<StructuralPropertyDescriptor> props = ast1.structuralPropertiesForType();
        for (StructuralPropertyDescriptor property : props) {
            Object ast1Val = ast1.getStructuralProperty(property);
            Object ast2Val = ast2.getStructuralProperty(property);
            if (property.isSimpleProperty()) {
                // check for simple properties (primitive types, Strings, ...)
                // with normal equality
                if (!ast1Val.equals(ast2Val)) {
                    return false;
                }
            } else if (property.isChildProperty()) {
                // recursively call this function on child nodes
                if (!compare((ASTNode) ast1Val, (ASTNode) ast2Val)) {
                    return false;
                }
            } else if (property.isChildListProperty()) {
                Iterator<ASTNode> ast1ValIt = ((Iterable<ASTNode>) ast1Val).iterator();
                Iterator<ASTNode> ast2ValIt = ((Iterable<ASTNode>) ast2Val).iterator();
                while (ast1ValIt.hasNext() && ast2ValIt.hasNext()) {
                    // recursively call this function on child nodes
                    if (!compare(ast1ValIt.next(), ast2ValIt.next())) {
                        return false;
                    }
                }
                // one of the value lists have additional elements
                if (ast1ValIt.hasNext() || ast2ValIt.hasNext()) {
                    return false;
                }
            }
        }
        return true;
    }
}
