package NotesSystem.main;

import java.util.List;

/**
 * Created by Sasha on 30.09.2015.
 */
public class User {
    private String _login;
    private String _pass;
    private int _u_id;
    private List<Integer> _notes;

    public int authUser(String l, String p) {
        if (l==_login && p==_pass)
            return _u_id;
        return -1;
    }

    public int getId() {
        return this._u_id;
    }
    public void setId(int id) { this._u_id = id; }
}
