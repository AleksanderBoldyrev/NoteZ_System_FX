package NotesSystem.main;

import java.util.List;

/**
 * Created by Sasha on 30.09.2015.
 */
public class User {
    private String _login;
    private String _pass;
    private long _u_id;
    private List<Integer> _notes;

    public long getId() {
        return this._u_id;
    }

    public long setId() {
        return this._u_id;
    }
}
