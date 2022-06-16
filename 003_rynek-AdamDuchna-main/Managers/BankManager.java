package Managers;

import Listeners.BankListener;
import java.util.ArrayList;


public class BankManager{
    ArrayList<BankListener> listeners = new ArrayList<>();

    public BankManager() {}

    public void subscribe(BankListener listener) { listeners.add(listener); }

    public void notify(Double inflation ) {
        for (BankListener listener : listeners) {
            listener.updateInflation(inflation);
        }
    }
}
