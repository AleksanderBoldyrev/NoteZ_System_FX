package NotesSystem.main;

import java.util.ArrayList;

/**
 * Created by Sasha on 08.10.2015.
 */
public class BaseWorker {
    private ArrayList<User> _users;
    private ArrayList<Note> _notes;
    private String _usersBasePath;
    private String _notesBasePath;

    BaseWorker()
    {
        LoadNotes();
        LoadUsers();
    }

    private void LoadUsers() {
        /*Load data from file to ArrayList*/
    }


    private void LoadNotes() {
        /*Load data from file to ArrayList*/
    }

    private void SaveUsers() {
        /*Load data from file to ArrayList*/
    }


    private void SaveNotes() {
        /*Load data from file to ArrayList*/
    }

    public void SaveData()
    {
        SaveNotes();
        SaveUsers();
    }

    public void SetNote(Note dat, int id)
    {

    }

    public void SetUser(User u, int id)
    {

    }


}
