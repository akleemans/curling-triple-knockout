import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class UtilTest {

  @Test
  void listSizes() {
    var list = Util.readFile("tournament-data/32_ibdc20.txt");
    assertEquals(list.size(), 82);

    list = Util.readFile("tournament-data/32_gpinter21.txt");
    assertEquals(list.size(), 82);

    list = Util.readFile("tournament-data/24_ibdc19.txt");
    assertEquals(list.size(), 55);

    list = Util.readFile("tournament-data/other/24_womens_masters14.txt");
    assertEquals(list.size(), 56);

    list = Util.readFile("tournament-data/16_ibdc22.txt");
    assertEquals(list.size(), 33);
  }


  @Test
  void roadRound() {
    Util.readFile("tournament-data/32_ibdc20.txt");
    assertEquals(Util.roadRound("A01"), Util.roadRound("A03"));
    assertNotEquals(Util.roadRound("B08"), Util.roadRound("B09"));
    assertEquals(Util.roadRound("B26"), Util.roadRound("B27"));
    assertNotEquals(Util.roadRound("C14"), Util.roadRound("C16"));

    assertEquals(Util.roadRound("A25"), Util.roadRound("A28"));
    assertEquals(Util.roadRound("C01"), Util.roadRound("C12"));
  }
}
