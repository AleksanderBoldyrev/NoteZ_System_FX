package NotesSystem.server;

import NotesSystem.main.CommonData;
import NotesSystem.main.RequestsParser;

import java.io.*;
import java.net.Socket;

/**
 * Created by Sasha on 30.09.2015.
 */
public class Server extends Thread{
    //private int _port;
    private Socket _socket;
    private BufferedReader _in;
    private PrintWriter _out;
    private RequestsParser _parser;

    private void createNewUser() {

    }

    private void createNewNote() {

    }

    Server(Socket s) {
        _socket = s;
        _parser = new RequestsParser();
        _parser.SetUserId(-1);
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
            while (true) {
                str = _in.readLine();
                if (str.equals(CommonData.TERMCOMMAND))
                    break;

                //Parsing
                if (str.length()>0)
                    _out.println(_parser.Parse(str));

                try {
                    this.sleep(10);
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

    public void Login() {

    }

    public void Logout() {

    }

    public void CreateUser() {

    }

    public void DeleteUser() {

    }

    public void ChangeUser() {

    }

    public void CreateRequest() {

    }

    public void ChangeRequest() {

    }

    public void DeleteRequest() {

    }

    public void CreateTag() {

    }

    public void DeleteTag() {

    }

    public void AddTagToRequest() {

    }

    public void GetRequestListByTags() {

    }

    public void GetTagList() {

    }

    public void HandleRequest() {

    }

    public void GetNoteTitleList() {

    }

}
