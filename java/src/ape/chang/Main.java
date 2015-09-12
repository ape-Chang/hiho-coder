package ape.chang;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  
  static class M2x2{
    public long a1, a2, a3, a4;
    public M2x2(long a1, long a2, long a3, long a4) {
      this.a1 = a1;
      this.a2 = a2;
      this.a3 = a3;
      this.a4 = a4;
    }
    public M2x2(M2x2 mat) {
      a1 = mat.a1; 
      a2 = mat.a2;
      a3 = mat.a3;
      a4 = mat.a4;
    }
    public void multiply(M2x2 mat) {
      long b1 = a1 * mat.a1 + a2 * mat.a3;
      long b2 = a1 * mat.a2 + a2 * mat.a4;
      long b3 = a3 * mat.a1 + a4 * mat.a3;
      long b4 = a3 * mat.a2 + a4 * mat.a4;
      a1 = b1%19999997; a2 = b2%19999997; a3 = b3%19999997; a4 = b4%19999997;
    }
  }

  public static long control(long n) {
    long a = 0, b = 1;
    while (n-- > 0) {
      b = a+b;
      a = b-a;
      if (a > 19999997) a %= 19999997;
      if (b > 19999997) b %= 19999997;
    }
    return b;
  }
  
  public static void main(String[] args) {
    try{System.setIn(new FileInputStream("input"));}catch(Exception e){return;}
    Scanner scanner = new Scanner(System.in);
    long n = scanner.nextLong();
    List<M2x2> expo = new ArrayList<Main.M2x2>();
    expo.add(new M2x2(0, 1, 1, 1));
    for (int i = 0; i < 64; ++i) {
      M2x2 mat = new M2x2(expo.get(i));
      mat.multiply(expo.get(i));
      expo.add(mat);
    }
    M2x2 ret = new M2x2(1, 0, 0, 1);
    for (int i = 0; n != 0; ++i, n >>= 1) 
      if ((0x1 & n) == 1) 
        ret.multiply(expo.get(i));
      
    System.out.println(ret.a4);
    
    scanner.close();
  }
  
}
