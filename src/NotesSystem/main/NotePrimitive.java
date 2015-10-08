package NotesSystem.main;

import java.time.LocalDateTime;

/**
 * Created by Sasha on 30.09.2015.
 */
public class NotePrimitive {
    private String _data;
    private LocalDateTime _cdate;
    private LocalDateTime _mdate;
    private int _id;

    NotePrimitive(String s, int ident) {
        _data = s;
        _cdate = LocalDateTime.now();
        _mdate = LocalDateTime.now();
        _id = ident;
    }

    String GetData() { return _data; }
    LocalDateTime GetCDate() {return _cdate; }
    LocalDateTime GetMDate()
    {
        return _mdate;
    }
    void SetData(String ns)
    {
        _data = ns;
    }
    void SetCDate(LocalDateTime nd)
    {
        _cdate = nd;
    }
    void SetMDate(LocalDateTime nd) { _mdate = nd; }

    int GetID() {
        return _id;
    }

    void ChangeNote(int pos, String newData) {
        for (int i = 0; i < (pos+newData.length()-_data.length()); i++)
            _data+=" ";
        char arr[] = _data.toCharArray();
        for (int i = pos; i < pos + newData.length(); i++)
            arr[i] = newData.charAt(i - pos);
        _data = new String(arr);
        _mdate = LocalDateTime.now();
    }

    void delSubstr(int beg, int end) {
        int swapper = (beg > end) ? beg : end;
        beg = (beg > end) ? end : beg;
        end = swapper;
        String ss = _data;
        _data = "";
        for (int i = 0; i<ss.length(); i++)
            if ((i<beg) && (i>end))
                _data+=ss.charAt(i);

        _mdate = LocalDateTime.now();
    }
}

