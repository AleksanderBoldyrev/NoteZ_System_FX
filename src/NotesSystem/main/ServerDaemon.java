package NotesSystem.main;

import java.util.ArrayList;

/**
 * Created by Sasha on 08.10.2015.
 */
public class ServerDaemon {
    private ArrayList<Server> _serverThreads;
    private int _lastPort;
    public static SecurityHelper clSH;

    ServerDaemon() {
        _serverThreads.clear();
        _lastPort = 10000;
    }

    private void CreateThread(int port)
    {
        /*TODO = Check if port is busy*/
        Server s = new Server(_lastPort);
        _serverThreads.add(s);
        _lastPort+=16;
    }

    public void start() {

    }

    public void stop() {

    }

    public void pause() {

    }

    public void resume() {

    }
}
