package cs5500.project.engine.ast;

import java.util.List;

public class ASTUtilities {
    /**
     * Remove the nodes not in LCS from the given list
     * @param l the list to clean
     * @param lcsList the list with LCS nodes
     * @return new list with only the LCS nodes as objects
     */
    public static void cleanLists(List<ASTHashObject> l, List<ASTHashObject> lcsList) {
        int tmpIndex = 0;
        //Store the similar nodes in the reportItem object
        for (int i=0; i < lcsList.size(); i++) {
            boolean found = false;

            while (!found) {
                if ((long) l.get(tmpIndex).getType() == lcsList.get(i).getType()) {
                    found = true;
                    tmpIndex++;
                } else {
                    l.remove(tmpIndex);
                }
            }
        }
    }
}
