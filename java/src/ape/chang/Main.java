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
  
  public static List<List<Candidate>> combine(List<Candidate> all, int from, int size) {
    List<List<Candidate>> result = new ArrayList<List<Candidate>>();
    if (all.size() == from + size) {
      List<Candidate> list = new ArrayList<Candidate>();
      for(int i = 0; i < size; ++i)
        list.add(all.get(from+i));
    } else {
      result.addAll(combine(all, from+1, size));
      for (List<Candidate> list : combine(all, from+1, size-1)) {
        list.add(all.get(from));
        result.add(list);
      }
    }
    return result;
  }
  
  public static void solve(List<Candidate> female, List<Candidate> male, int budget, int x, int y) {
    List<List<Candidate>> femaleCombination = combine(female, 0, x);
    List<List<Candidate>> maleCombination = combine(male, 0, y);
    
    int maxAbility = 0;
    int minSalary = 0;
    List<List<Candidate>> possibilities = new ArrayList<List<Candidate>>();
    for (int i = 0; i < femaleCombination.size(); ++i)
      for (int j = 0; j < maleCombination.size(); ++j) {
        int ability = 0;
        int salary = 0;
        List<Candidate> possibility = new ArrayList<Candidate>();
        for(Candidate candidate : femaleCombination.get(i)) {
          ability += candidate.ability;
          salary += candidate.salary;
          possibility.add(candidate);
        }
        for (Candidate candidate : maleCombination.get(j)) {
          ability += candidate.ability;
          salary += candidate.salary;
          possibility.add(candidate);
        }
        if (salary > budget) continue;
        if (ability == maxAbility) {
          if (salary < minSalary) possibilities.clear();
          possibilities.add(possibility);
        }
        if (ability > maxAbility) {
          possibilities.clear();
          possibilities.add(possibility);
        }
      }
    
    System.out.println(String.format("%d %d", maxAbility, minSalary));
    
    for (List<Candidate> possibility : possibilities) 
      Collections.sort(possibility, new Comparator<Candidate>() {
        @Override
        public int compare(Candidate lhs, Candidate rhs) {
          return rhs.id - lhs.id;
        }});
    
    Collections.sort(possibilities, new Comparator<List<Candidate>>(){
      @Override
      public int compare(List<Candidate> lhs, List<Candidate> rhs) {
        for (int i = 0; i < lhs.size(); ++i) {
          if (lhs.get(i).id < rhs.get(i).id)
            return 1;
          if (lhs.get(i).id < rhs.get(i).id)
            return -1;
        }
        return 0;
      }});
    
    StringBuffer buffer = new StringBuffer();
    for (Candidate candidate : possibilities.get(0)) {
      buffer.append(candidate.id).append(" ");
    }
    System.out.println(buffer.toString());
  }
  
  public static void main(String[] args) {
    try{System.setIn(new FileInputStream("input"));}catch(Exception e){return;}
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    int X = scanner.nextInt();
    int Y = scanner.nextInt();
    int B = scanner.nextInt();
    List<Candidate> female = new ArrayList<Main.Candidate>();
    List<Candidate> male = new ArrayList<Main.Candidate>();
    for (int i = 1; i <= N; ++i) {
      String gender = scanner.next();
      int ability = scanner.nextInt();
      int salary = scanner.nextInt();
      if (gender == "F")
        female.add(new Candidate(i, ability, salary));
      else 
        male.add(new Candidate(i, ability, salary));
    }
    solve(female, male, B, X, Y);
    scanner.close();
  }
  
}
