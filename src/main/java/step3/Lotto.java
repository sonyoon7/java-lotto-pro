package step3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> range;

    private List<Integer> lottoNumbers;

    private int matchCount;

    private boolean hasBonusNumber;

    public Lotto() {
        this.range = new ArrayList<>();
        initLotto();
        shuffle(range);
        this.lottoNumbers = range.subList(0, 6);
        System.out.println(lottoNumbers);
    }

    public List<Integer> gainAutoNumbers() {
        return lottoNumbers;
    }

    public void match(List<Integer> winningNumbers) {
        Collections.sort(winningNumbers);
        Collections.sort(lottoNumbers);
        lottoNumbers.retainAll(winningNumbers);
        this.matchCount = lottoNumbers.size();
    }

    public void matchBonusball(int bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            this.hasBonusNumber = true;
        }
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean hasBonusNumber() {
        return hasBonusNumber;
    }

    private List<Integer> initLotto() {
        for (int i = 1; i <= 45; i++) {
            range.add(i);
        }
        return range;
    }

    private void shuffle(List<Integer> initLottoNumbers) {
        Collections.shuffle(initLottoNumbers);
    }

}
