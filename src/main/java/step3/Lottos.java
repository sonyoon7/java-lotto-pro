package step3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {

    private final static int LOTTO_PRICE = 1000;
    private final List<Lotto> lottos;
    private final Map<Integer, Integer> statistics;

    public Lottos() {
        lottos = new ArrayList<>();
        statistics = new HashMap<>();
        initStatistics();
    }

    public int calculateLottoCount(int money) {
        return money / LOTTO_PRICE;
    }

    public List<Lotto> generateLottos(int count) {
        System.out.println(count + Message.COUNT.getMessage());
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }

    public void matchWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        lottos.forEach(lotto -> {
            lotto.matchBonusball(bonusNumber);
            lotto.match(winningNumbers);
        });
    }

    public double statisticLottos(int money) {
        lottos.forEach(lotto -> {
            if (isBonus(lotto)) {
                statistics.computeIfPresent(Award.FIVE_BONUS.getCount() + 2, (k, v) -> v + 1);
                return;
            }
            statistics.computeIfPresent(lotto.getMatchCount(), (k, v) -> v + 1);
        });
        double sum = statistics.get(Award.THREE.getCount()) * Award.THREE.getAmount();
        sum += statistics.get(Award.FOUR.getCount()) * Award.FOUR.getAmount();
        sum += statistics.get(Award.FIVE.getCount()) * Award.FIVE.getAmount();
        sum += statistics.get(Award.FIVE_BONUS.getCount() + 2) * Award.FIVE_BONUS.getAmount();
        sum += statistics.get(Award.SIX.getCount()) * Award.SIX.getAmount();
        return Math.floor(sum / money * 100) / 100;
    }

    private boolean isBonus(Lotto lotto) {
        return lotto.getMatchCount() == Award.FOUR.getCount() && lotto.hasBonusNumber();
    }

    public Map<Integer, Integer> getStatistics() {
        return statistics;
    }

    private void initStatistics() {
        statistics.put(Award.THREE.getCount(), 0);
        statistics.put(Award.FOUR.getCount(), 0);
        statistics.put(Award.FIVE.getCount(), 0);
        statistics.put(Award.FIVE_BONUS.getCount() + 2, 0);
        statistics.put(Award.SIX.getCount(), 0);
    }


}
