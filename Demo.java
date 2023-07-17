package iterator.BrowserHistory;

import iterator.Iterator;

public class Demo {

    public static void main(String[] args) {
        var history = new BrowserHistory();

        history.push("a");
        history.push("b");
        history.push("c");

        //Main doesn't know anything about the logic of BrowserHistory. We are programming against an interface
        //We can change the implementation details of history without affecting this class.

        Iterator iterator = history.createIterator();
        while (iterator.hasNext()){
            var item = iterator.current();
            System.out.println(item);
            //Go to the next item
            iterator.next();
        }


    }
}
