package NotesSystem.server;

import NotesSystem.main.Note;

import java.util.ArrayList;

/**
 * Created by Sasha on 08.10.2015.
 */
public class SecurityHelper {

    private static BaseWorker _dataBase;
    private static ArrayList<Integer> _activeUsers;

    SecurityHelper() {
        _dataBase = new BaseWorker();
        _activeUsers = new ArrayList<Integer>();
    }

    public synchronized boolean Login(String name, String pass) {
        int res = _dataBase.CheckUser(name, pass);  //*** NARROW!. ***
        if (res >= 0) {
            if (_activeUsers.contains(res))
                return false;
            else {
                _activeUsers.add(res);
                return true;
            }
        }
        return false;
    }

    public synchronized void Logout(int userId) {
        if (_activeUsers.contains(userId))
            for (int i = 0; i < _activeUsers.size(); i++) {
                if (_activeUsers.get(i) == userId)
                    _activeUsers.remove(i);
            }
    }

    public synchronized  int GetNotesCount(int userId) {
        if (_activeUsers.contains(userId)) return _dataBase.GetNotesCountByUser(userId);
        return 0;
    }

    public synchronized  ArrayList<Integer> GetNotesListByUserId(int userId) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (_activeUsers.contains(userId))
            return _dataBase.GetNotesByUserId(userId);
        return res;
    }

    public synchronized String GetNoteVersionById(int userId, int noteId, int verId) {
        String res = new String();
        if (_activeUsers.contains(userId)) {
            return _dataBase.GetNoteVerById(userId, noteId, verId);
        }
        return res;
    }

    public synchronized String GetNoteVersioDatanById(int userId, int noteId, int verId) {
        String res = new String();
        if (_activeUsers.contains(userId)) {
            return _dataBase.GetNoteVerDateById(userId, noteId, verId);
        }
        return res;
    }

    public synchronized ArrayList<String> GetNotesTitlesById(int userId) {
        ArrayList<String> res = new ArrayList<String>();
        if (_activeUsers.contains(userId))
            return _dataBase.GetNotesTitles(userId);
        return res;
    }

    public synchronized int GetNoteVersCount(int userId, int noteId) {//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        int res = 0;
        if (_activeUsers.contains(userId))
            return _dataBase.GetNoteVersCount(userId,noteId);
        return 0;

    }

    public synchronized ArrayList<Integer> GetNoteVersionsListById(int userId, int noteId) {
        ArrayList<Integer> res = new ArrayList<Integer>();

        /***********************/

        return res;
    }

    public synchronized void CreateNote(int userId, ArrayList<Integer> tagList, String data, String title) { //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        if (_activeUsers.contains(userId)) if (/*belongs to user?*/) _dataBase.AddNote(userId, tagList, data, title);
    }

    public synchronized void DeleteNote(int noteId, int userId) { //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        _dataBase.DeleteNote(noteId, userId);
    }

    public synchronized void GetUserNoteHeaderList() {

    }

    public synchronized boolean CreateUser(String name, String pass) { //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        boolean res = _dataBase.DoesUserExist(name);  //*** NARROW!. ***
        if (!res)
            _dataBase.AddUser(name, pass);
        return !res;
    }

    public synchronized void DeleteUser(int userId) {//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        _dataBase.DeleteUser(userId);
    }

    public void AddTagToNote(String t) {
        _dataBase.AddTag(t);
    }

    public synchronized void ChangeUser() {

    }

    public void DeleteTagFromNote() {

    }

    public void GetNoteListByTag() {

    }

    public void GetTagList() {

    }

    public void GetTitleNoteList() {

    }

}
