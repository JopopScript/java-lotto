package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.controller.LottoController;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    @DisplayName("로또 갯수 대로 입력되는지")
    public void 로또_갯수_대로_입력되는지() {
        LottoController lottoController = LottoController.of(14000);
        Lotto lotto = lottoController.lottoTicketCreate();
        assertThat(lotto.getLottos().size()).isEqualTo(6);
    }
}
