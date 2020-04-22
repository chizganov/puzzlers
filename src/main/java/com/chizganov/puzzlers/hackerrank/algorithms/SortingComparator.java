package com.chizganov.puzzlers.hackerrank.algorithms;

import java.util.Comparator;
import java.util.Objects;

/**
 * <a href="https://www.hackerrank.com/challenges/ctci-comparator-sorting/problem">Sorting: Comparator challenge</a>
 *
 * @author Ev Chizganov
 */
class SortingComparator implements Comparator<SortingComparator.Player> {

    @Override
    public int compare(Player a, Player b) {
        int result = b.getScore() - a.getScore();
        if (result == 0) return a.getName().compareTo(b.getName());

        return result;
    }

    static class Player {

        private final String name;
        private final int score;

        Player(String name, int score) {
            Objects.requireNonNull(name);

            this.name = name;
            this.score = score;
        }

        String getName() {
            return name;
        }

        int getScore() {
            return score;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Player player = (Player) o;
            return score == player.score &&
                    name.equals(player.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, score);
        }
    }

}
