package step2.app;

import step2.domain.*;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.List;

public class LottoApp {

    public static void main(String[] args) {
        Money money = new Money(InputView.receiveMoney());
        int lottoPurchaseCount = money.calculateLottoPurchaseCount();
        ResultView.printLottoPurchaseCount(lottoPurchaseCount);
        List<Lotto> lottos = LottoFactory.create(lottoPurchaseCount);
        ResultView.printLottos(lottos);
        String winningNumberLine = InputView.receiveWinningNumberLine();
        WinningNumbers winningNumbers = new WinningNumbers(LottoUtils.splitWinningNumberLineAndReturnLottoNumbers(winningNumberLine));
        LottoResults lottoResults = new LottoResults(LottoUtils.collectWinningNumberCount(lottos, winningNumbers));
        ResultView.printWinningCountStatistics(lottoResults.calculateWinningCountStatistics());
        ResultView.printYield(lottoResults.calculateYield(money));
    }

}