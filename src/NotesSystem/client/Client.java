package NotesSystem.client;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

import NotesSystem.main.*;
import com.trolltech.qt.QSignalEmitter;
import com.trolltech.qt.QtBlockedSlot;

import static java.lang.Thread.sleep;

/**
 * Created by Sasha on 30.09.2015.
 */
public class Client extends QSignalEmitter {
    private SocketListener _listener;
    private Ui_MainWindow _uiMain;
    private Ui_LoginWindow _uiLogin;
    private RequestsParser _parser;
    private boolean isAuth;

    public Client(int port, String host) {
        _uiMain = new Ui_MainWindow();
        _uiMain.setupUi(_uiMain);
        _uiLogin = new Ui_LoginWindow();
        _uiLogin.setupUi(_uiLogin);
        _listener = new SocketListener(port, host);
        _parser = new RequestsParser();
        isAuth = false;

        /**/
        _uiLogin.pushButton.clicked.connect(this, "CreateUser()");
        _uiLogin.pushButton_2.clicked.connect(this, "Login()");
        /**/
    }

    public void startProcess() {
        Thread t = new Thread(_listener);
        t.start();
        //_uiMain.show();
        _uiLogin.show();
        //CreateUser();
    }

    public void stopListener() {
        _listener.StopListener();
    }

    @QtBlockedSlot
    public void Login() {
        String _log = _uiLogin.lineEdit.text();
        String _pass = _uiLogin.lineEdit_2.text();
        ArrayList<String> s = new ArrayList<String>();
        s.add(_log);
        s.add(_pass);
        String st = _parser.Build(s, CommonData.O_LOGIN);
        _listener.WriteToBuffer(st);
        String str = WaitForServer();
        if (str != "")
        {
            ArrayList<Integer> buff = _parser.ParseListOfInteger(str);
            if (buff.size() > 1)
                if (buff.get(0) == CommonData.O_RESPOND)
                {
                    if (buff.get(1) == CommonData.SERV_YES)
                    {
                        isAuth = true;
                        _uiLogin.hide();
                        _uiMain.show();
                        _uiMain.statusbar.showMessage("Successfully logged in!");

                    }
                    //else
                     //   _uiLogin.label.showMessage("User name or password is incorrect!");
                }
        }
    }

    @QtBlockedSlot
    public void Logout() {
        String st = _parser.Build("", CommonData.O_LOGOUT);
        _listener.WriteToBuffer(st);
        String str = WaitForServer();
        if (str != "")
        {
            ArrayList<Integer> buff = _parser.ParseListOfInteger(str);
            if (buff.size() > 1)
                if (buff.get(0) == CommonData.O_RESPOND)
                {
                    if (buff.get(1) == CommonData.SERV_YES)
                    {
                        isAuth = true;
                        _uiMain.hide();
                        _uiLogin.show();
                        //_uiMain.statusbar.showMessage("Successfully logged out!");
                    }
                    else
                        _uiMain.statusbar.showMessage("User is not logged in or server is unreachable!");
                }
        }
    }

    @QtBlockedSlot
    public void CreateUser() {
        String _log = _uiLogin.lineEdit.text();
        String _pass = _uiLogin.lineEdit_2.text();
        ArrayList<String> s = new ArrayList<String>();
        s.add(_log);
        s.add(_pass);
        String st = _parser.Build(s, CommonData.O_CREATE_U);
        _listener.WriteToBuffer(st);
        String str = WaitForServer();
        if (str != "")
        {
            ArrayList<Integer> buff = _parser.ParseListOfInteger(str);
            if (buff.size() > 1)
                if (buff.get(0) == CommonData.O_RESPOND)
                {
                    if (buff.get(1) == CommonData.SERV_YES)
                    {
                        isAuth = true;
                        _uiMain.statusbar.showMessage("User account is successfully created!");
                    }
                    else
                        _uiMain.statusbar.showMessage("User name already exists or server is unreachable!");
                }
        }
    }

    @QtBlockedSlot
    public void DeleteUser(int user_id) {
        String st = _parser.Build(user_id, CommonData.O_DELETE_U);
        _listener.WriteToBuffer(st);
        String str = WaitForServer();
        if (str != "")
        {
            ArrayList<Integer> buff = _parser.ParseListOfInteger(str);
            if (buff.size() > 1)
                if (buff.get(0) == CommonData.O_RESPOND)
                {
                    if (buff.get(1) == CommonData.SERV_YES)
                    {
                        isAuth = true;
                        _uiMain.statusbar.showMessage("Successfully logged in!");
                    }
                    else
                        _uiMain.statusbar.showMessage("User name or password is incorrect!");
                }
        }
    }

    @QtBlockedSlot
    public void CreateNote(String note) {
        String st = _parser.Build(note, CommonData.O_CREATE_N);
        _listener.WriteToBuffer(st);
        String str = WaitForServer();
        if (str != "")
        {
            ArrayList<Integer> buff = _parser.ParseListOfInteger(str);
            if (buff.size() > 1)
                if (buff.get(0) == CommonData.O_RESPOND)
                {
                    if (buff.get(1) == CommonData.SERV_YES)
                    {
                        isAuth = true;
                        _uiMain.statusbar.showMessage("Successfully logged in!");
                    }
                    else
                        _uiMain.statusbar.showMessage("User name or password is incorrect!");
                }
        }
    }

    @QtBlockedSlot
    public void DeleteNote(int note) {
        String st = _parser.Build(note, CommonData.O_DELETE_N);
        _listener.WriteToBuffer(st);
        String str = WaitForServer();
        if (str != "")
        {
            ArrayList<Integer> buff = _parser.ParseListOfInteger(str);
            if (buff.size() > 1)
                if (buff.get(0) == CommonData.O_RESPOND)
                {
                    if (buff.get(1) == CommonData.SERV_YES)
                    {
                        isAuth = true;
                        _uiMain.statusbar.showMessage("Successfully logged in!");
                    }
                    else
                        _uiMain.statusbar.showMessage("User name or password is incorrect!");
                }
        }
    }

    @QtBlockedSlot
    public void CreateTag(String tag) {
        String st = _parser.Build(tag, CommonData.O_CREATE_T);
        _listener.WriteToBuffer(st);
        String str = WaitForServer();
        if (str != "")
        {
            ArrayList<Integer> buff = _parser.ParseListOfInteger(str);
            if (buff.size() > 1)
                if (buff.get(0) == CommonData.O_RESPOND)
                {
                    if (buff.get(1) == CommonData.SERV_YES)
                    {
                        isAuth = true;
                        _uiMain.statusbar.showMessage("Successfully logged in!");
                    }
                    else
                        _uiMain.statusbar.showMessage("User name or password is incorrect!");
                }
        }
    }

    @QtBlockedSlot
    public void DeleteTag(String tag) {
        String st = _parser.Build(tag, CommonData.O_DELETE_T);
        _listener.WriteToBuffer(st);
        String str = WaitForServer();
        if (str != "")
        {
            ArrayList<Integer> buff = _parser.ParseListOfInteger(str);
            if (buff.size() > 1)
                if (buff.get(0) == CommonData.O_RESPOND)
                {
                    if (buff.get(1) == CommonData.SERV_YES)
                    {
                        isAuth = true;
                        _uiMain.statusbar.showMessage("Successfully logged in!");
                    }
                    else
                        _uiMain.statusbar.showMessage("User name or password is incorrect!");
                }
        }
    }

    @QtBlockedSlot
    public void SaveNote(int note_id) {
        String st = _parser.Build(note_id, CommonData.O_SAVE_N);
        _listener.WriteToBuffer(st);
        String str = WaitForServer();
        if (str != "")
        {
            ArrayList<Integer> buff = _parser.ParseListOfInteger(str);
            if (buff.size() > 1)
                if (buff.get(0) == CommonData.O_RESPOND)
                {
                    if (buff.get(1) == CommonData.SERV_YES)
                    {
                        isAuth = true;
                        _uiMain.statusbar.showMessage("Successfully logged in!");
                    }
                    else
                        _uiMain.statusbar.showMessage("User name or password is incorrect!");
                }
        }
    }

    @QtBlockedSlot
    public void DeleteNoteByVersion(int ver) {
        String st = _parser.Build(ver, CommonData.O_DELETE_N_V);
        _listener.WriteToBuffer(st);
        String str = WaitForServer();
        if (str != "")
        {
            ArrayList<Integer> buff = _parser.ParseListOfInteger(str);
            if (buff.size() > 1)
                if (buff.get(0) == CommonData.O_RESPOND)
                {
                    if (buff.get(1) == CommonData.SERV_YES)
                    {
                        isAuth = true;
                        _uiMain.statusbar.showMessage("Successfully logged in!");
                    }
                    else
                        _uiMain.statusbar.showMessage("User name or password is incorrect!");
                }
        }
    }

    @QtBlockedSlot
    public void SearchNotes(String title) {
        ArrayList<String> s = new ArrayList<String>();
        s.add(title);
        String st = _parser.Build(s, CommonData.O_SEARCH_N);
        _listener.WriteToBuffer(st);
        String str = WaitForServer();
        if (str != "")
        {
            ArrayList<Integer> buff = _parser.ParseListOfInteger(str);
            if (buff.size() > 1)
                if (buff.get(0) == CommonData.O_RESPOND)
                {
                    if (buff.get(1) == CommonData.SERV_YES)
                    {
                        isAuth = true;
                        _uiMain.statusbar.showMessage("Successfully logged in!");
                    }
                    else
                        _uiMain.statusbar.showMessage("User name or password is incorrect!");
                }
        }
    }

    public void GetTagList() {

    }

    public void GetNoteByTag() {

    }
    /*private String GetData(String s) {
        String res = new String();
        return res;
    }*/

    private String WaitForServer() {
        int i;
        String str = new String();
        for (i = CommonData.RETRIES_COUNT; i > 0 ;i--)
        {
            try {
                sleep(CommonData.SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            str =  _listener.ReadBuffer();
            if (str != "")
            {
                break;
            }
        }
        return str;
    }
}