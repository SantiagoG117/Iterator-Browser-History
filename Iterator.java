/**
 * @author Santiago Garcia
 * @version 1.0
 * @since Java 17
 * @see iterator.BrowserHistory.BrowserHistory
 * @see iterator.BrowserHistory.Demo
 */

package iterator;

/**
 *
 * @param <T> To add flexibility to the interface and allow it to be reusable
 * we set it to a general purpose (generic) interface. When implementing
 * this interface, we must supply an argument for the type T:
 *           class implements Iterator<String>
 *           class implements Iterator<User>
 *           ...
 */
public interface Iterator<T> {
    void next();
    boolean hasNext();
    T current();
}
