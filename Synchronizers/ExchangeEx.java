package Multithreading.Synchronizers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

enum Action {
    STONE, SCISSORS, PAPER
}

public class ExchangeEx {
    public static void main(String[] args) {
        Exchanger<Action> exchanger = new Exchanger<>();
        List<Action> friend1Action = new ArrayList<>();
        friend1Action.add(Action.SCISSORS);
        friend1Action.add(Action.PAPER);
        friend1Action.add(Action.SCISSORS);
        List<Action> friend2Action = new ArrayList<>();
        friend2Action.add(Action.PAPER);
        friend2Action.add(Action.STONE);
        friend2Action.add(Action.STONE);
        new BestFriend("Anton", friend1Action, exchanger);
        new BestFriend("Vasya", friend2Action, exchanger);
    }
}

class BestFriend extends Thread {
    private String name;
    private List<Action> myActions;
    private Exchanger<Action> exchanger;
    public BestFriend(String name, List<Action> myActions, Exchanger<Action> exchanger) {
        this.name = name;
        this.myActions = myActions;
        this.exchanger = exchanger;
        this.start();
    }

    private void whoWins(Action myAction, Action hisAction) {
        if((myAction == Action.STONE && hisAction == Action.SCISSORS)
            || (myAction == Action.SCISSORS && hisAction == Action.PAPER)
            || (myAction == Action.PAPER && hisAction == Action.STONE)) {
            System.out.println(name + " wins!");
        }
    }

    @Override
    public void run() {
        Action reply;
        for(Action a : myActions) {
            try {
                reply = exchanger.exchange(a);
                whoWins(a, reply);
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}