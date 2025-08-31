package com.company.item7;


import java.util.ArrayList;
import java.util.List;

class TestCase  {

    public static void main(String[] args) throws Exception {

      List<String> list = new ArrayList<>();
      StringBuilder sb = new StringBuilder("mrx");
      sb.append("ppppppppppppp");
      String s = sb.toString();
      list.add(s);
      System.out.println(s.getClass());
      System.out.println(list.getClass());
    }

  }
