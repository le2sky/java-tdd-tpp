package com.tdd.primefactors;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class PrimeFactorsTest {

    @Test
    void factors() {
        assertThat(factorsOf(1)).isEqualTo(intList());
        assertThat(factorsOf(2)).isEqualTo(intList(2));
        assertThat(factorsOf(3)).isEqualTo(intList(3));
        assertThat(factorsOf(4)).isEqualTo(intList(2, 2));

        // 5,6,7은 의미없는 테스트
        assertThat(factorsOf(5)).isEqualTo(intList(5));
        assertThat(factorsOf(6)).isEqualTo(intList(2, 3));
        assertThat(factorsOf(7)).isEqualTo(intList(7));

        assertThat(factorsOf(8)).isEqualTo(intList(2, 2, 2));
        assertThat(factorsOf(9)).isEqualTo(intList(3, 3));
        assertThat(factorsOf(2 * 2 * 3 * 3 * 3 * 7 * 7 * 11 * 11 * 13))
            .isEqualTo(intList(2, 2, 3, 3, 3, 7, 7, 11, 11, 13));
    }

    private List<Integer> intList(Integer... i) {
        return List.of(i);
    }

    private List<Integer> factorsOf(int n) {
        ArrayList<Integer> factors = new ArrayList<>();
        for (int divisor = 2; n > 1; divisor++) {
            for (; n % divisor == 0; n /= divisor) {
                factors.add(divisor);
            }
        }

        return factors;
    }
}
