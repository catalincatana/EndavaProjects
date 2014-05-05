/**
 * Created by ccatana on 5/5/2014.
 */
public class PersistenceComponent {
    void persist(Object arg) throws PersistenceException {
        throw new PersistenceException("Cannot persist object " + arg.toString());
    }
}
