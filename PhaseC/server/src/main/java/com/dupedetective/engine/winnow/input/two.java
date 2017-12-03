package com.dupedetective.engine.winnow.input;


import org.apache.log4j.Logger;

public class two {
    /*
      Logger for error or info messages
       */
    final static Logger logger = Logger.getLogger(two.class);

    public static void main(String a[]) {
        int i;
        int array[] = {12, 9, 4, 99, 120, 1, 3, 10, 13};

        logger.info("\n\n RoseIndia\n\n");
        logger.info(" Quick Sort\n\n");
        logger.info("Values Before the sort:\n");
        for (i = 0; i < array.length; i++)
            logger.info(array[i] + "  ");

        quick_srt(array, 0, array.length - 1);
        logger.info("Values after the sort:\n");
        for (i = 0; i < array.length; i++)
            logger.info(array[i] + "  ");

        logger.info("PAUSE");
    }

    public static void quick_srt(int array[], int low, int n) {
        int lo = low;
        int hi = n;
        if (lo >= n) {
            return;
        }
        int mid = array[(lo + hi) / 2];
        while (lo < hi) {
            while (lo < hi && array[lo] < mid) {
                lo++;
            }
            while (lo < hi && array[hi] > mid) {
                hi--;
            }
            if (lo < hi) {
                int T = array[lo];
                array[lo] = array[hi];
                array[hi] = T;
            }
        }
        if (hi < lo) {
            int T = hi;
            hi = lo;
            lo = T;
        }
        quick_srt(array, low, lo);
        quick_srt(array, lo == low ? lo + 1 : lo, n);
    }
}