package com.chizganov.puzzlers.hackerrank.algorithms;

/**
 * <a href="https://www.hackerrank.com/challenges/fraudulent-activity-notifications/problem">Fraudulent Activity Notifications challenge</a>
 *
 * @author Ev Chizganov
 */
class FraudulentActivityNotifications {

    int activityNotifications(int[] expenditure, int d) {
        int notifications = 0;
        int[] counting = new int[201]; // 201 - input constraint
        for (int i = 0; i < d; i++)
            counting[expenditure[i]]++;

        for (int i = d; i < expenditure.length; i++) {
            double m = median(counting, d);
            if (Double.compare(expenditure[i], m * 2) >= 0) notifications++;

            counting[expenditure[i - d]]--;
            counting[expenditure[i]]++;
        }

        return notifications;
    }

    // Find median using counting
    private double median(int[] counting, int length) {
        int count = 0;
        int i = -1;

        if (length % 2 == 0) {
            double m;
            while (count < length / 2) count += counting[++i];
            m = i;
            while (count < length / 2 + 1) count += counting[++i];
            return (i + m) / 2;
        } else {
            while (count <= length / 2) count += counting[++i];
            return i;
        }
    }

}
