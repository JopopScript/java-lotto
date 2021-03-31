package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinNumbers {
    private final static int BONUS_NUMBER_INIT = 0;

    private final List<Integer> winNumbers;
    private final int bonusNumber;

    public WinNumbers(String[] winNumbers, int bonusNumber) {
        this.winNumbers = toWinNumbers(winNumbers);
        this.bonusNumber = bonusNumber;
    }

    public WinNumbers(List<Integer> winNumbers) {
        this(winNumbers, BONUS_NUMBER_INIT);
    }

    public WinNumbers(List<Integer> winNumbers, int bonusNumber) {
        this.winNumbers = winNumbers;
        this.bonusNumber = bonusNumber;
    }

    private List<Integer> toWinNumbers(String[] winNumber) {
        List<Integer> winNumberList = new ArrayList<>();
        for (String number : winNumber) {
            winNumberList.add(Integer.parseInt(number));
        }

        return winNumberList;
    }

    public HitCount hitNumberCount(Numbers numbers) {
        int hitCount = 0;
        for (int winNumber : this.winNumbers) {
            hitCount += toInteger(numbers.contains(winNumber));
        }

        return new HitCount(hitCount, numbers.contains(bonusNumber));
    }

    private int toInteger(boolean isContain) {
        return isContain ? 1 : 0;
    }
}