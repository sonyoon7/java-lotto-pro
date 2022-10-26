package step3;

public class LottoApplication {
    public static void main(String[] args) {

        View view = new View();
        Lottos lottos = new Lottos();

        int money = view.purchase();
        int purchasingNumber = lottos.calculateLottoCount(money);
        lottos.generateLottos(purchasingNumber);
        lottos.matchWinningNumbers(view.inputWinnerNumbers());

        view.statistic(lottos.getStatistics(), lottos.statisticLottos(money));


    }
}
