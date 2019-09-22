package com.chizganov.puzzlers.hackerrank.algorithms;

import java.util.Arrays;

/**
 * <a href="https://www.hackerrank.com/challenges/fraudulent-activity-notifications/problem">Fraudulent Activity Notifications challenge</a>
 *
 * @author Ev Chizganov
 */
class FraudulentActivityNotifications {

    int activityNotifications(int[] expenditure, int d) {
        int notifications = 0;
        int[] trailing = new int[d];
        for (int i = d; i < expenditure.length; i++) {
            System.arraycopy(expenditure, i - d, trailing, 0, d);
            double m = median(trailing);

            if (Double.compare(expenditure[i], m * 2) >= 0) notifications++;
        }

        return notifications;
    }

    private double median(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        if (n % 2 == 1) return arr[n / 2];
        else return ((double) arr[n / 2] + (double) arr[n / 2 + 1]) / 2;
    }

}
