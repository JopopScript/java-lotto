package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoShopTest {


    @DisplayName("로또 구매 테스트")
    @ParameterizedTest
    @CsvSource(value = {"2000:2", "15000:15", "5000:5"}, delimiter = ':')
    public void purchaseLottoTest(int purchasePrice, int expected) {

        //Given & When
        LottoShop shop = new LottoShop();
        Lottos lottos = shop.purchase(LottoPrice.from(purchasePrice), new LottoAutoMachine());

        //Then
        assertThat(lottos.quantity()).isEqualTo(expected);

    }
}