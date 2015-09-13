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
   
  public static List<List<Candidate>> combine(List<Candidate> all, int k) {
    List<List<Candidate>> result = new ArrayList<List<Candidate>>();
    if (k == 0) return result;
    
    int n = all.size();
    int[] index = new int[k];
    for (int i = 0; i < index.length; ++i) index[i] = -1;
    index[0] = 0;
    int current = 1;
    while (true) {
      if (current == -1) break;
      if (current == k) {
        
        List<Candidate> combination = new ArrayList<Candidate>();
        for (int i = 0; i < k; ++i) combination.add(all.get(index[i]));
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
  
  public static List<Candidate> merge(List<Candidate> female, List<Candidate> male) {
      List<Candidate> result = new ArrayList<Candidate>();
      int i = 0, j = 0;
      while (i < female.size() && j < male.size()) {
	  Candidate f = female.get(i);
	  Candidate m = male.get(j);
	  if (f.id < m.id) {
	      result.add(f);
	      ++i;
	  } else {
	      result.add(m);
	      ++j;
	  }
      }
      while (i < female.size()) {
	  result.add(female.get(i));
	  ++i;
      }
      while (j < male.size()) {
	  result.add(male.get(j));
	  ++j;
      }
      return result;
  }
  
  public static List<List<Candidate>> crossProduct(List<List<Candidate>> female, List<List<Candidate>> male) {
      if (female.size() == 0) return male;
      if (male.size() == 0) return female;
      
      List<List<Candidate>> result = new ArrayList<List<Candidate>>();
      for (int i = 0; i < female.size(); ++i)
	  for (int j = 0; j < male.size(); ++j)
	      result.add(merge(female.get(i), male.get(j)));
      return result;
  }
  
  public static void solve(List<Candidate> female, List<Candidate> male, int budget, int x, int y) {
      int minSalary = 0;
    int maxAbility = 0;
    List<List<Candidate>> possibilities = new ArrayList<List<Candidate>>();
    for (List<Candidate> comb : crossProduct(combine(female, y), combine(male, x))) {
        int ability = 0;
        int salary = 0;
        for (Candidate candidate : comb) {
            salary += candidate.salary;
            ability += candidate.ability;
        }

        if (salary > budget) continue;
        if (ability == maxAbility) {
            if (salary > minSalary)
        	continue;
            if (salary == minSalary)
        	possibilities.add(comb);
            if (salary < minSalary) {
        	minSalary = salary;
        	possibilities.clear();
        	possibilities.add(comb);
            }
        }
        if (ability > maxAbility) {
            minSalary = salary;
            maxAbility = ability;
            possibilities.clear();
            possibilities.add(comb);
        }	
    }
    
    System.out.println(String.format("%d %d", maxAbility, minSalary));
    
    assert possibilities.size() != 0;
    Collections.sort(possibilities, new Comparator<List<Candidate>>(){
      @Override
      public int compare(List<Candidate> lhs, List<Candidate> rhs) {
        for (int i = 0; i < lhs.size(); ++i) {
          if (lhs.get(i).id > rhs.get(i).id)
            return 1;
          if (lhs.get(i).id < rhs.get(i).id)
            return -1;
        }
        return 0;
      }});
    
    StringBuffer buffer = new StringBuffer();
    for (Candidate candidate : possibilities.get(0)) 
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
