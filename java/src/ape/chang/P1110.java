package ape.chang;

import java.io.FileInputStream;
import java.util.Scanner;

public class P1110 {
	static class FSM {
		static enum State{
			Start {
				@Override
				public State on(Event event) {
					switch (event) {
					case OneOrZero:
						return State.OneOrZero;
					case Parenleft:
						return State.Parenleft;
					default:
						throw new RuntimeException();
					}
				}
			},
			OneOrZero {

				@Override
				public State on(Event event) {
					switch (event) {
					case OneOrZero:
						return State.OneOrZero;
					case Bar:
						return State.Bar;
					case Parenleft:
						return State.Parenleft;
					case Parenright:
						return State.Parenright;
					case Asterisk:
						return State.Asterisk;
					case EndOfEvent:
						return State.End;
					default:
						throw new RuntimeException();
					}
				}
			},
			Bar {
				@Override
				public State on(Event event) {
					switch (event) {
					case OneOrZero:
						return State.OneOrZero;
					case Parenleft:
						return State.Parenleft;
					default:
						throw new RuntimeException();
					}
				}
			} ,
			Parenleft {
				@Override
				public State on(Event event) {
					++State.parenthesis;
					switch (event) {
					case OneOrZero:
						return State.OneOrZero;
					case Parenleft:
						return State.Parenleft;
					default:
						throw new RuntimeException();
					}

				}
			} ,
			Parenright {
				@Override
				public State on(Event event) {
					--State.parenthesis;
					switch (event) {
					case OneOrZero:
						return State.OneOrZero;
					case Asterisk:
						return State.Asterisk;
					case Bar:
						return State.Bar;
					case EndOfEvent:
						return State.End;
					default:
						throw new RuntimeException();
					}
				}
			},
			Asterisk {
				@Override
				public State on(Event event) {
					switch (event) {
					case OneOrZero:
						return State.OneOrZero;
					case Parenleft:
						return State.Parenleft;
					case Parenright:
						return State.Parenright;
					case Bar:
						return State.Bar;
					case EndOfEvent:
						return State.End;
					default:
						throw new RuntimeException();
					}
				}
			},
			End {
				@Override
				public State on(Event event) {
					throw new RuntimeException();
				}
			};
			public static int parenthesis = 0;
			public abstract State on(Event event);
		}
		static enum Event{
			OneOrZero, Parenleft, Parenright, Bar, Asterisk, EndOfEvent;
			public static Event instance(char c) {
				switch (c) {
				case '0':
				case '1':
					return Event.OneOrZero;
				case '(':
					return Event.Parenleft;
				case ')':
					return Event.Parenright;
				case '*':
					return Event.Asterisk;
				case '|':
					return Event.Bar;
				default:
					return Event.EndOfEvent;
				}
			}
		}
	
		public boolean run(String s) {
			State state = State.Start;
			State.parenthesis = 0;
			char[] A = s.toCharArray();
			for (char c : A) {
				state = state.on(Event.instance(c));
			}
			state.on(Event.EndOfEvent);
			return State.parenthesis == 0;
		}
	}

    public static void main(String[] args) {
		try{System.setIn(new FileInputStream("input"));}catch(Exception e){return;}
		Scanner scanner = new Scanner(System.in);
		FSM fsm = new FSM();
		while (scanner.hasNext()) {
			try {
				if (fsm.run(scanner.next()))
					System.out.println("yes");
				else 
					System.out.println("no");
			} catch (Exception e) {
				System.out.println("no");
			}
		}
		scanner.close();
    }

}
