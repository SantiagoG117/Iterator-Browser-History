/**
*   @author Santiago Garcia
*   @version 1.0
*   @since Java 17
*   @see iterator.BrowserHistory.Demo
*   @see iterator.Iterator
*/

package iterator.BrowserHistory;

import iterator.Iterator;

import java.util.ArrayList;
import java.util.List;


public class BrowserHistory {
    //Attributes
    private List<String> urls = new ArrayList<>();

    //Public methods
    /**
     *
     * @param url appends the url to the end of the list
     */
    public void push(String url){
        urls.add(url);
    }


    /**
     *
     * @return remove and return the last URL in the history.
     */
    public String pop(){
        if (urls.isEmpty())
            return "";
        var lastIndex = urls.size()-1;
        var lastUrl = urls.get(lastIndex);
        urls.remove(lastUrl);

        return lastUrl;
    }

    /**
     *
     * @return an Iterator object holding the implementation details about how to iterate
     * over the BrowserHistory class
     */
    public Iterator<String> createIterator(){
        //As parameter, we pass a reference to the history we want to iterate over:
        return new ListIterator(this);
    }

    /*
        ListIterator class is a nested class because it holds the
        implementation details about how to iterate over the BrowserHistory object.

        If we change the way we store the URLs, this will be the only place
        where we need to make changes about how to iterate over the Browser History.
     */
    private class ListIterator implements Iterator<String> {
        //Attributes
        private BrowserHistory history;//History we are going to iterate over
        private int index; //Represent a state: How many items have we visited so far

        //Constructor
        public ListIterator(BrowserHistory history) {
            this.history = history;
        }

        /**
         * advances to the next index
         */
        @Override
        public void next() {
            index++;
        }

        /**
         * 
         * @return true of the current index is smaller than the size of urls
         * ListIterator is part of the implementation of BrowserHistory, so
         * it has access to all its members (private or public).
         * As long as index is smaller than the number of items in the history
         * we will have more items to visit.
         */
        @Override
        public boolean hasNext() {
            return index < history.urls.size();
        }

        /**
         *
         * @return current item
         */
        @Override
        public String current() {
            return history.urls.get(index);
        }
    }
}
