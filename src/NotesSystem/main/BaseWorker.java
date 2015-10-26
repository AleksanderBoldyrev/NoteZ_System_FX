package NotesSystem.main;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Created by Sasha on 08.10.2015.
 */
public class BaseWorker {
    private ArrayList<User> _users;
    private ArrayList<Note> _notes;
    private ArrayList<Tag> _tags;

    private static final String path_1 = "F://Base/File_1.txt";
    private static final String path_2 = "F://Base/File_2.txt";
    private static final String path_3 = "F://Base/File_3.txt";
    private static final char sep = '|';
    private static final char sepId = '.';

    private String _usersBasePath;
    private String _notesBasePath;

    BaseWorker()
    {
        _users = new ArrayList<User>();
        _notes = new ArrayList<Note>();
        _tags = new ArrayList<Tag>();
        LoadNotes(path_3);
        LoadUsers(path_2);
        LoadTags(path_1);
    }

    private void LoadUsers(String fileName) {
        StringBuilder sb = new StringBuilder();
        File file = new File(fileName);

        try {
            BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                in.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

        //*** Parsing of the file content. ***

        String str = new String(sb);

        byte stage = 0;
        StringBuilder buff = new StringBuilder();
        int buffId = 0;
        String buffLogin = new String();
        String buffPass = new String();
        ArrayList<Integer> buffNotesId = new ArrayList<Integer>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == sep) {
                switch(stage)
                {
                    case 0:         //*** Read user's ID. ***
                        stage++;
                        if (buff.length() != 0)
                            buffId = Integer.parseInt(buff.toString());
                        else
                            buffId = 0;
                        break;
                    case 1:         //*** Read username. ***
                        buffLogin = buff.toString();
                        stage++;
                        break;
                    case 2:         //*** Read user's password. ***
                        buffPass = buff.toString();
                        stage++;
                        break;
                    case 3:         //*** Read user's note list. ***
                        stage = 0;
                        int data = 0;
                        StringBuilder notes_id = new StringBuilder();
                        for (int j = 0; j < buff.length(); j++) {
                            if(buff.charAt(j) == sepId) {
                                buffNotesId.add(Integer.parseInt(notes_id.toString()));
                                notes_id.delete(0, notes_id.length());
                            }
                            else {
                                notes_id.append(buff.charAt(j));
                            }
                        }
                        _users.add(new User(buffId, buffLogin, buffPass, buffNotesId));
                        break;
                }
                buff.delete(0, buff.length());
            }
            else buff.append(str.charAt(i));
        }
    }

    private void LoadNotes(String fileName) {
        StringBuilder sb = new StringBuilder();
        File file = new File(fileName);

        try {
            BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                in.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

        //*** Parsing of the file content. ***

        String str = new String(sb);

        byte stage = 0;
        StringBuilder buff = new StringBuilder();
        int buffId = 0;
        int buffVersNum = 0;
        ArrayList<Integer> buffTagsId = new ArrayList<Integer>();
        ArrayList<NotePrimitive> buffNoteVers = new ArrayList<NotePrimitive>();
        String buffText = new String();
        StringBuilder lBuf = new StringBuilder();
        int readOfPrimitivesCount = 0;
        LocalDateTime buffDate = LocalDateTime.now();
        String buffNotePrimData = new String();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == sep) {
                switch(stage) {
                    case 0:         //*** Read user's ID. ***
                        stage++;
                        if (buff.length() != 0)
                            buffId = Integer.parseInt(buff.toString());
                        else
                            buffId = 0;
                        break;
                    case 1:         //*** Read number of versions. ***
                        buffVersNum = Integer.parseInt(buff.toString());
                        stage++;
                        break;
                    case 2:         //*** Read note's tags id list. ***
                        stage++;
                        //lBuf.replace(0, lBuf.length() - 1, "");
                        for (int j = 0; j < buff.length(); j++) {
                            if (buff.charAt(j) == sepId) {
                                buffTagsId.add(Integer.parseInt(lBuf.toString()));
                                lBuf.delete(0, lBuf.length());
                            } else {
                                lBuf.append(buff.charAt(j));
                            }
                        }
                        break;
                    case 3:         //*** Creation date of Note Primitive. ***
                        stage++;
                        buffDate = LocalDateTime.parse(buff);
                        break;
                    case 4:         //*** Text of Note Primitive. ***
                        buffNotePrimData = buff.toString();
                        buffNoteVers.add(new NotePrimitive(readOfPrimitivesCount, buffDate, buffNotePrimData));

                        if (readOfPrimitivesCount < (buffVersNum - 1)) {
                            stage--; //read next primitive at next case
                            readOfPrimitivesCount++;
                        }
                        else {
                            stage = 0; //end of reading note primitives
                            _notes.add(new Note(buffId, buffTagsId, buffNoteVers));
                            buffTagsId.clear();
                            buffNoteVers.clear();
                            readOfPrimitivesCount=0;
                        }
                        break;
                }
                buff.delete(0, buff.length());
            }
            else buff.append(str.charAt(i));
        }
    }

    public void LoadTags(String fileName) {
        StringBuilder sb = new StringBuilder();
        File file = new File(fileName);

        try {
            BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                in.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

        String str = new String(sb);

        byte stage = 0;
        StringBuilder buff = new StringBuilder();
        int buffId = 0;
        String buffData = new String();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == sep) {
                if (stage == 0) {
                    stage++;
                    if (buff.length() != 0)
                        buffId = Integer.parseInt(buff.toString());
                    else
                        buffId = 0;
                }
                else if (stage == 1) {
                    buffData = buff.toString();
                    stage--;
                    _tags.add(new Tag(buffId, buffData));
                }
                buff.delete(0, buff.length());
            }
            else buff.append(str.charAt(i));
        }
        /*for (int i = 0; i < _tags.size(); i++) {
            System.out.println(_tags.get(i).GetId() + " | " + _tags.get(i).GetStrData());
        }*/

    }

    private void SaveUsers(String fileName) {
        File file = new File(fileName);
        try
        {
            if(!file.exists())
                file.createNewFile();
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            for (int i = 0; i < _users.size(); i++) {
                out.print(_users.get(i).GetId());
                out.print(sep);
                out.print(_users.get(i).GetName());
                out.print(sep);
                out.print(_users.get(i).GetPass());
                out.print(sep);
                int t = _users.get(i).GetNotesCount();
                for (int j = 0; j < t; j++) {
                    out.print(_users.get(i).GetNotesByPos(j));
                    out.print(sepId);
                }
                out.print(sep);
            }
            out.close();
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void SaveNotes(String fileName) {
        File file = new File(fileName);
        try
        {
            if(!file.exists())
                file.createNewFile();
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            for (int i = 0; i < _notes.size(); i++) {
                out.print(_notes.get(i).GetId());
                out.print(sep);
                int vcount = _notes.get(i).GetVersionsCount();
                out.print(vcount);
                out.print(sep);
                int t = _notes.get(i).GetVersionsCount();
                for (int j = 0; j < t; j++) {
                    out.print(_notes.get(i).GetTagById(j));
                    out.print(sepId);
                }
                out.print(sep);
                for (int j = 0; j < vcount; j++)
                {
                    NotePrimitive nt = _notes.get(i).GetNoteByPos(j);
                    out.print(nt.GetCDate().toString());
                    out.print(sep);
                    out.print(nt.GetData());
                    out.print(sep);
                }
            }
            out.close();
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void SaveTags(String fileName) {
        File file = new File(fileName);
        try
        {
            if(!file.exists())
                file.createNewFile();
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            for (int i = 0; i < _tags.size(); i++) {
                out.print(_tags.get(i).GetId());
                out.print(sep);
                out.print(_tags.get(i).GetStrData());
                out.print(sep);
            }
            out.close();
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void SaveData()
    {
        SaveNotes(path_3);
        SaveUsers(path_2);
        SaveTags(path_1);
    }

    public void SetNote(Note dat, int id)
    {

    }

    public void ReadNote() {

    }

    public void AddNote() {

    }

    public void DeleteNote() {

    }

    public void SetUser(User u, int id) {

    }

    public void ReadUser() {

    }

    public void AddUser() {

    }

    public void DeleteUser() {

    }

    public void CreateBackup() {

    }

    public void GetFromBackup() {

    }

    public void PushBaseToDisk() {

    }

    public void Initialise() {

    }

    public void DeleteTag() {

    }

    public void AddTag() {

    }

    public void DeleteUnusedTags() {

    }

    public void Verify() {

    }
}
