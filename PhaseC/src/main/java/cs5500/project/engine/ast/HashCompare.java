package cs5500.project.engine.ast;

import cs5500.project.engine.CustomComparator;

import java.util.Arrays;
import java.util.List;

/**
 * Compare two list with hash values
 */
public class HashCompare implements CustomComparator<List<Integer>> {

    /**
     * @param l1 the first list
     * @param l2 the second list
     * @return the similarity value
     */
    public float compare(List<Integer> l1, List<Integer> l2) {
//        Arrays.sort(l2);
//        for (int i =0,int j =0; i<l2.length&&j< l1.length;) {
//            if (SuspectedHashListArray To(OriginalHashListArray [0]) ==0){
//                //TODO: Add all the nodes into the database;
//                break;
//            }
//            P1=SuspectedHashListArray[i].jjgetparent();
//
//            P2=OriginalHashListArray[j].jjgetparent(); /*
//*If the hash value of parent is equal,
//[0].compare-
//*skip the comparison of their children
//*/
//            if (P1!=null&&P2!=null&&P1.compareTo(P2)==0) {
//                i++;
//                j++;
//                continue;
//            }
//
//            if (SuspectedHashListArray[i].compareTo(OriginalHash-ListArray[j])< 0) {
//                i++;
//            }
//
//            else if (SuspectedHashListArray[i].compareTo(OriginalHashListArray [j])>0) {
//                j++;
//            }
//
//            else {
//                //TODO: Add the nodes into the database;
//                i++;
//                j++;
//            }
//        }
        return 1.0f;
    }

}
