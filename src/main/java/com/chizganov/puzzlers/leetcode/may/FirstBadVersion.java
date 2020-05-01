package com.chizganov.puzzlers.leetcode.may;

/**
 * <a href="https://leetcode.com/explore/featured/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3316/">First Bad Version challenge</a>
 *
 * @author Ev Chizganov
 */
class FirstBadVersion {

    private int versionsNumber;
    private int firstBadVersion;

    int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) right = mid;
            else left = mid + 1;
        }

        return left;
    }

    void setFirstBadVersions(int firstBadVersion) {
        this.firstBadVersion = firstBadVersion;
    }

    void setVersionsNumber(int versionsNumber) {
        this.versionsNumber = versionsNumber;
    }

    private boolean isBadVersion(int i) {
        if (firstBadVersion == 0)
            throw new IllegalStateException("Set first bad version before calling firstBadVersion method.");
        if (i < 1 || i > versionsNumber)
            throw new IndexOutOfBoundsException(String.format("Version %d not exists.", i));
        return i >= firstBadVersion;
    }

}
