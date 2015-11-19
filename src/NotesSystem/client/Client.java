package NotesSystem.client;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

import NotesSystem.main.*;

/**
 * Created by Sasha on 30.09.2015.
 */
public class Client {
    private SocketListener _listener;
    private Ui_MainWindow _uiMain;
    private RequestsParser _parser;

    public Client(int port, String host) {
        _uiMain = new Ui_MainWindow();
        _uiMain.setupUi(_uiMain);
        _listener = new SocketListener(port, host);
        _parser = new RequestsParser();
    }

    public void startProcess() {
        Thread t = new Thread(_listener);
        t.start();
        _uiMain.show();

        CreateUser();
    }

    public void stopListener() {
        _listener.StopListener();
    }

    public void Login(String _log, String _pass) {


    }

    public void Logout() {

    }

    public void CreateUser(String login, String pass) {
        ArrayList<String> s = new ArrayList<String>();
        s.add(login);
        s.add(pass);
        String st = _parser.Build(s, CommonData.O_CREATE_U);
        _listener.WriteToBuffer(st);
        /*Необходимо подождать ответ о создании

         */
    }

    public void DeleteUser() {

    }

    public void CreateNote() {

    }

    public void DeleteNote() {

    }

    public void SaveNote() {

    }

    public void DeleteNoteByVersion() {

    }

    public void GetTagList() {

    }

    public void GetNoteByTag() {

    }

    public void SearchNotes() {

    }
}
