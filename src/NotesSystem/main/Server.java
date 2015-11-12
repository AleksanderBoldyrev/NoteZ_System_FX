package NotesSystem.main;

import java.io.*;
import java.net.Socket;

/**
 * Created by Sasha on 30.09.2015.
 */
public class Server extends Thread{
    //private int _port;
    private Socket _socket;
    BufferedReader _in;
    // Вывод автоматически выталкивается из буфера PrintWriter'ом
    PrintWriter _out;
    RequestsParser _parser = new RequestsParser();

    private void createNewUser() {

    }

    private void createNewNote() {

    }

    Server(Socket s) {
        _socket = s;
        _parser.SetUserId(-1);
        try {
            _in = new BufferedReader(new InputStreamReader(_socket.getInputStream()));
            // Вывод автоматически выталкивается из буфера PrintWriter'ом
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
                _out.println(_parser.Parse(str));
            }
            // Всегда закрываем два сокета...
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
