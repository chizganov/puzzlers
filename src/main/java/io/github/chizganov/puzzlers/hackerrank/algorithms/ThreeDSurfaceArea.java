package io.github.chizganov.puzzlers.hackerrank.algorithms;

/**
 * <a href="https://www.hackerrank.com/challenges/3d-surface-area/problem">3D Surface Area challenge</a>
 *
 * @author Ev Chizganov
 * */
class ThreeDSurfaceArea {

    @SuppressWarnings("ForLoopReplaceableByForEach")
    int surfaceArea(int[][] a) {
        int h = a.length;
        int w = a[0].length;
        int r = 2*h*w;

        for(int i = 0; i < h; i++) {
            r += a[i][0];
            r += a[i][w-1];
        }

        for(int j = 0; j < w; j++) {
            r += a[0][j];
            r += a[h-1][j];
        }

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if(i > 0) r += Math.max(0, a[i][j]-a[i-1][j]);
                if(i < h-1) r += Math.max(0, a[i][j]-a[i+1][j]);
                if(j > 0) r += Math.max(0, a[i][j]-a[i][j-1]);
                if(j < w-1)r += Math.max(0, a[i][j]-a[i][j+1]);
            }
        }

        return r;
    }

}
