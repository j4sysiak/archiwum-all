package com.company.item6;

public interface T1 {
  int VALUE = 1;
  void m();
}

 interface T2 {
  int VALUE = 2;
  void m();
}


  class TestCase implements T1, T2  {

    public static void main(String[] args) throws Exception {

      TestCase testCase = new TestCase();
      testCase.m();


      T1 t1 = new TestCase();
      t1.m();
      int o = T1.VALUE;

    }

    @Override
    public void m() {
      System.out.println();
      TestCase testCase = new TestCase();

    }
  }
