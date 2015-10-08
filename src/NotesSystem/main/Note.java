package NotesSystem.main;

import java.time.LocalDateTime;

import java.util.ArrayList;

/**
 * Created by Sasha on 30.09.2015.
 */
public class Note {
    private int _id;
    private ArrayList<NotePrimitive> _note;
    private LocalDateTime _n_cdate;
    private LocalDateTime _n_mdate;

    Note (String data, int id) {
        _note.clear();
        NotePrimitive n = new NotePrimitive(data, id*10000);
        _note.add(n);
        _id = id;
        _n_cdate = LocalDateTime.now();
        _n_mdate = LocalDateTime.now();
    }

    NotePrimitive getNote() {
        if (_id > _note.size()) _id = 0;
        return _note.get(0);
    }

    NotePrimitive getNoteByPos(int id) {
        if (_id > _note.size()) _id = 0;
        return _note.get(id - _id*10000);
    }

    /*
    NotePrimitive getNoteByCreateDate(LocalDateTime date) {
        NotePrimitive res = new NotePrimitive("");
        if (_id > _note.size()) _id = 0;
        if (_note.size() > 0 && (date == (this._n_cdate) )) ////////////!!!!!!!!!!!!!!!!!!!!!!!!
        for (int i = 0; i < _note.size(); i++)
        {
            if ((_note.get(i)).GetCDate()==date)
                res = _note.get(i);
;       }
        return res;
    }

    NotePrimitive getNoteByModifyDate(LocalDateTime date) {
        NotePrimitive res = new NotePrimitive("");
        if (_id > _note.size()) _id = 0;
        if (_note.size() > 0 && (date == this._n_mdate) )
            for (int i = 0; i < _note.size(); i++)
            {
                if ((_note.get(i)).GetMDate()==date)
                    res = _note.get(i);
            }
        return res;
    }
    */

    long GetLastVersion()
    {
        if (_id > _note.size()) _id = 0;
        return _note.get(_note.size()-1).GetID();
    }

    void DelNote(int ident) {
        if (_id > _note.size()) _id = 0;
        _note.remove(ident - _id*10000);
        _n_mdate = LocalDateTime.now();
    }

    void ModifyNote(String data, int ident, int pos) {
        if (_id > _note.size()) _id = 0;
        _note.get(ident - _id*10000).ChangeNote(pos, data);
        _n_mdate = LocalDateTime.now();
    }
}
