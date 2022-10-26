package step3;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {

        View view = new View();
        Lottos lottos = new Lottos();

        int money = view.purchase();
        int purchasingNumber = lottos.calculateLottoCount(money);
        lottos.generateLottos(purchasingNumber);
        List<Integer> winnerNumbers= view.inputWinnerNumbers();
        int bonusball = view.inputBonusball();
        lottos.matchWinningNumbers(winnerNumbers, bonusball);

        view.statistic(lottos.getStatistics(), lottos.statisticLottos(money));


    }
}
