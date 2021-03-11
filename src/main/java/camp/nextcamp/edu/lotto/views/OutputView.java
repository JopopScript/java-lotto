package camp.nextcamp.edu.lotto.views;

import java.util.List;
import java.util.Map;

import camp.nextcamp.edu.lotto.entity.Lotto;
import camp.nextcamp.edu.lotto.entity.LottoTicket;
import camp.nextcamp.edu.lotto.module.WinningScore;

public class OutputView extends View {
	private static final String WINNING = "(수익률이 엄청나군요 당신은 로또천재..?)";
	private static final String FAIL = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

	public void showLottoTicketCount(LottoTicket lottoTicket) {
		out.println(lottoTicket.getTicketCount() + "개를 구매했습니다.");
	}

	public void showPurchasedLottos(List<Lotto> lottos) {
		lottos.stream()
			.map(lotto -> "[" + lotto.getNumbersString() + "]")
			.forEach(out::println);
	}

	public void showResultStatistics(Map<WinningScore, Long> winningScore) {
		out.println("당첨 통계");
		out.println("----------");

		out.println(String.format("꽝\t\t\t\t(0원)  -  %s개", winningScore.get(WinningScore.NONE)));

		winningScore.forEach(this::showExactNoneScore);
	}

	public void showProfit(double profit) {
		String message = profit > 1 ? WINNING : FAIL;
		out.println(String.format("총 수익률은 %s 입니다. %s", profit, message));
	}

	private void showExactNoneScore(WinningScore score, Long count) {
		if (score != WinningScore.NONE) {
			String result = String.format("%s개 일치\t\t\t (%s원) - %s개", score.getCorrectCount(), score.getPrice(), count);
			out.println(result);
		}
	}
}