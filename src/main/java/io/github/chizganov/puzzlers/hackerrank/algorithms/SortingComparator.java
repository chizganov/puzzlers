package io.github.chizganov.puzzlers.hackerrank.algorithms;

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
        int result = b.score() - a.score();
        if (result == 0) return a.name().compareTo(b.name());

        return result;
    }

    record Player(String name, int score) {

        Player {
            Objects.requireNonNull(name);

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Player player = (Player) o;
            return score == player.score &&
                    name.equals(player.name);
        }

    }

}
