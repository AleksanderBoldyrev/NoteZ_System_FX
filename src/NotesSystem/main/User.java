package NotesSystem.main;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sasha on 30.09.2015.
 */
public class User {
    private String _login;
    private String _pass;
    private int _u_id;
    private ArrayList<Integer> _notes;

    User(int id, String buffLogin, String buffPass, ArrayList<Integer> notes) {
        _u_id = id;
        System.out.print(_u_id + "|");
        _login = buffLogin;
        System.out.print(_login + "|");
        _pass = buffPass;
        System.out.print(_pass + "|");
        _notes = new ArrayList<Integer>();
        for (int i = 0; i < notes.size(); i++) {
            _notes.add(i, notes.get(i));
            System.out.print(_notes.get(i) + ".");
        }
        System.out.println("|");
    }

    public int AuthUser(String l, String p) {
        if (l == _login && p == _pass)
            return _u_id;
        return -1;
    }

    public int GetId() {
        return this._u_id;
    }
    public void SetId(int id) { this._u_id = id; }
    public String GetName() { return this._login; }
    public String GetPass() { return this._pass; }
    public int GetNotesCount() { return this._notes.size(); }
    public int GetNotesByPos(int i) { return this._notes.get(i); }
}
