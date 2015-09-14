package ape.chang;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
  
  static class Candidate {
    public int id;
    public int ability;
    public int salary;
    public Candidate(int id, int ability, int salary) {
      this.id = id;
      this.ability = ability; 
      this.salary = salary;
    }
  }
   
  static class Combination {
      public List<Candidate> elements;
      public Combination() {
	  elements = new ArrayList<Candidate>();
      }
      public int salary;
      public int ability;
  }
  
  private static List<Combination> combine(List<Candidate> all, int k, int budget) {
      List<Combination> result = new ArrayList<Combination>();
      if (k == 0) return result;
      
      int n = all.size();
      int[] index = new int[k];
      for (int i = 0; i < index.length; ++i) index[i] = -1;
      index[0] = 0;
      int current = 1;
      while (true) {
        if (current == -1) break;
        if (current == k) {
          
            Combination combination = new Combination();
            for (int i = 0; i < k; ++i) {
                Candidate candidate = all.get(index[i]);
                combination.salary += candidate.salary;
                combination.ability += candidate.ability;
                combination.elements.add(candidate);
            }
            if (combination.salary <= budget)
                result.add(combination);
          
          --current;
        } else {
          if (index[current] == -1) {
            index[current] = index[current-1] + 1;
            ++current;
          } else {
            if (index[current] + 1 > n-k+current) {
              index[current] = -1;
              --current;
            } else {
              index[current]++;
              ++current;
            }
          }
        }
      }
      
      return result;
  }
  
  public static Combination merge(Combination female, Combination male) {
      Combination result = new Combination();
      result.salary = female.salary + male.salary;
      result.ability = female.ability + male.ability;
      int i = 0, j = 0;
      while (i < female.elements.size() && j < male.elements.size()) {
	  Candidate f = female.elements.get(i);
	  Candidate m = male.elements.get(j);
	  if (f.id < m.id) {
	      result.elements.add(f);
	      ++i;
	  } else {
	      result.elements.add(m);
	      ++j;
	  }
      }
      while (i < female.elements.size()) {
	  result.elements.add(female.elements.get(i));
	  ++i;
      }
      while (j < male.elements.size()) {
	  result.elements.add(male.elements.get(j));
	  ++j;
      }
      return result;
  }
  
  private static List<Combination> crossProduct(List<Combination> female, List<Combination> male, int budget) {
      if  (female.size() == 0) return male;
      if (male.size() == 0) return female;
      List<Combination> result = new ArrayList<Combination>();
      for (int i = 0; i < female.size(); ++i)
	  for (int j = 0; j < male.size(); ++j) {
	      if (female.get(i).salary + male.get(j).salary <= budget) 
		  result.add(merge(female.get(i), male.get(j)));
	  }
      return result;
  }
  
  public static void solve(List<Candidate> female, List<Candidate> male, int budget, int x, int y) {
      int minSalary = 0;
      int maxAbility = 0;
      List<Combination> possibilities = new ArrayList<Combination>();
      
    for (Combination combination : crossProduct(combine(female, y, budget), combine(male, x, budget), budget)) {
        if (combination.ability == maxAbility) {
            if (combination.salary == minSalary)
        	possibilities.add(combination);
            if (combination.salary < minSalary) {
        	minSalary = combination.salary;
        	possibilities.clear();
        	possibilities.add(combination);
            }
        }
        if (combination.ability > maxAbility) {
            minSalary = combination.salary;
            maxAbility = combination.ability;
            possibilities.clear();
            possibilities.add(combination);
        }	
    }
    
    System.out.println(String.format("%d %d", maxAbility, minSalary));
    
    Collections.sort(possibilities, new Comparator<Combination>(){
      @Override
      public int compare(Combination lhs, Combination rhs) {
        for (int i = 0; i < lhs.elements.size(); ++i) {
          if (lhs.elements.get(i).id > rhs.elements.get(i).id)
            return 1;
          if (lhs.elements.get(i).id < rhs.elements.get(i).id)
            return -1;
        }
        return 0;
      }});
    
    StringBuffer buffer = new StringBuffer();
    for (Candidate candidate : possibilities.get(0).elements) 
      buffer.append(candidate.id).append(" ");
    System.out.println(buffer.toString());
  }
  
  public static void main(String[] args) {
    try{System.setIn(new FileInputStream("input"));}catch(Exception e){return;}
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    int X = scanner.nextInt(); // x == 0?
    int Y = scanner.nextInt(); // y == 0?
    int B = scanner.nextInt();
    List<Candidate> female = new ArrayList<Main.Candidate>();
    List<Candidate> male = new ArrayList<Main.Candidate>();
    for (int i = 1; i <= N; ++i) {
      String gender = scanner.next();
      int ability = scanner.nextInt();
      int salary = scanner.nextInt();
      if (gender.equals("F"))
        female.add(new Candidate(i, ability, salary));
      else 
        male.add(new Candidate(i, ability, salary));
    }
    solve(female, male, B, X, Y);
    scanner.close();
  }
  
}

