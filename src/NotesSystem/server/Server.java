package NotesSystem.server;

import NotesSystem.main.CommonData;
import NotesSystem.main.RequestsParser;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by Sasha on 30.09.2015.
 */
public class Server extends Thread{
    //private int _port;
    private Socket _socket;
    private BufferedReader _in;
    private PrintWriter _out;
    private RequestsParser _parser;
    private int _userId;

    private void createNewUser() {

    }

    private void createNewNote() {

    }

    Server(Socket s) {
        _socket = s;
        _parser = new RequestsParser();
        //_parser.SetUserId(-1);
        _userId = -1;
        try {
            _in = new BufferedReader(new InputStreamReader(_socket.getInputStream()));
            _out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(_socket.getOutputStream())), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try{
            String str = new String();
            String resp = new String();
            while (true) {
                str = _in.readLine();
                if (str.equals(CommonData.TERMCOMMAND))
                    break;
                resp = "";
                //Parsing
                if (str.length()>0) {
                    ArrayList<String> buff = _parser.ParseListOfString(str);

                    try {
                        int command = Integer.parseInt(buff.get(0));
                        switch (command) {
                            case CommonData.O_CREATE_U:
                                resp = CreateUser(buff);
                                break;
                            case CommonData.O_CREATE_N:
                                resp = CreateNote(buff);
                                break;
                            case CommonData.O_CREATE_T:
                                resp = CreateTag(buff);
                                break;
                            case CommonData.O_DELETE_N:
                                resp = DeleteNote(buff);
                                break;
                            case CommonData.O_DELETE_N_V:
                                resp = DeleteNoteByVer(buff);
                                break;
                            case CommonData.O_DELETE_T:
                                resp = DeleteTag(buff);
                                break;
                            case CommonData.O_DELETE_U:
                                resp = DeleteUser(buff);
                                break;
                            case CommonData.O_LOGIN:
                                resp = Login(buff);
                                break;
                            case CommonData.O_LOGOUT:
                                resp = Logout(buff);
                                break;
                            case CommonData.O_SAVE_N:
                                resp = SaveNote(buff);
                                break;
                            case CommonData.O_SEARCH_N:
                                resp = SearchNote(buff);
                                break;

                        }

                    } catch (NumberFormatException e)
                    {
                        System.out.println(e.toString());
                    }


                }

                if (resp!="")
                    _out.println(resp);

                try {
                    this.sleep(CommonData.SLEEP_TIME);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("closing...");
            try {
                _socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String Login(ArrayList<String> buff ) {
        ArrayList<String> res = new ArrayList<String>();

        boolean suc = false;
        if (buff.size()>2) {
            suc = ServerDaemon.sHelper.Login(buff.get(1), buff.get(2));
        }
        if (suc)
            res.add(new String(CommonData.SERV_YES + ""));
        else
            res.add(new String(CommonData.SERV_NO + ""));
        return _parser.Build(res, CommonData.O_RESPOND);
    }

    public String Logout(ArrayList<String> buff ) {
        String res = new String();
        return res;
    }

    public String CreateUser(ArrayList<String> buff ) {
        ArrayList<String> res = new ArrayList<String>();

        boolean suc = false;
        if (buff.size()>2) {
            suc = ServerDaemon.sHelper.CreateUser(buff.get(1), buff.get(2));
        }
        if (suc)
            res.add(new String(CommonData.SERV_YES + ""));
        else
            res.add(new String(CommonData.SERV_NO + ""));
        return _parser.Build(res, CommonData.O_RESPOND);
    }

    public String CreateNote(ArrayList<String> buff ) {
        String res = new String();
        return res;
    }

    public String DeleteUser(ArrayList<String> buff ) {
        String res = new String();
        return res;
    }

    public String DeleteNote(ArrayList<String> buff ) {
        String res = new String();
        return res;
    }

    public String DeleteNoteByVer(ArrayList<String> buff ) {
        String res = new String();
        return res;
    }

    public String ChangeUser(ArrayList<String> buff ) {
        String res = new String();
        return res;
    }

    public String SaveNote(ArrayList<String> buff ) {
        String res = new String();
        return res;
    }

    public String SearchNote(ArrayList<String> buff ) {
        String res = new String();
        return res;
    }
    public String CreateRequest(ArrayList<String> buff ) {
        String res = new String();
        return res;
    }

    public String ChangeRequest(ArrayList<String> buff ) {
        String res = new String();
        return res;
    }

    public String DeleteRequest(ArrayList<String> buff ) {
        String res = new String();
        return res;
    }

    public String CreateTag(ArrayList<String> buff ) {
        String res = new String();
        return res;
    }

    public String DeleteTag(ArrayList<String> buff ) {
        String res = new String();
        return res;
    }

    public String AddTagToRequest(ArrayList<String> buff ) {
        String res = new String();
        return res;
    }

    public String GetRequestListByTags(ArrayList<String> buff ) {
        String res = new String();
        return res;
    }

    public String GetTagList(ArrayList<String> buff ) {
        String res = new String();
        return res;
    }

    public String HandleRequest(ArrayList<String> buff ) {
        String res = new String();
        return res;
    }

    public String GetNoteTitleList(ArrayList<String> buff ) {
        String res = new String();
        return res;
    }
}
