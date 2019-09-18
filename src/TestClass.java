public class TestClass {

  public static void main(String[] args) {
    int x = 3;
    int y = 6;
    y = y - x / 2;
    System.out.println(y);

    int n = 1;
    while (n < 10) {
      System.out.println(n + " ");
      n *= 2;

      int s = 10;
      int z = s - 1;
      while (z > 1) {
        if ((s % z) == 0) {
          System.out.println(z + ", ");
        }
        z--;
      }
      int a = 2;
      for (int i = 5; i < 8; i++) {
        System.out.println("(" + i + "," + a + ")");
      }
      System.out.println();
    }
    for ( int j = 2; j < 14; j = j+3){
      System.out.println(j + " ");
    }
  }
}
