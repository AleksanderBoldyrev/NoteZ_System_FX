package NotesSystem.main;

/**
 * Created by Alex on 04.11.2015.
 */
public final class CommonData {
    public static final int PORT = 25000;
    public static final String HOST = "localhost";
    public static final char SEP = '|';
    public static final char SEPID = '.';
    public static final String TERMCOMMAND = "***";
    /*Client - server commands*/
    public static final int O_RESPOND = 0;
    public static final int O_LOGIN = 1;
    public static final int O_CREATE_U = 2;
    public static final int O_DELETE_U = 3;
    public static final int O_LOGOUT = 4;
    public static final int O_IS_SERVER_ALIVE = 333;
}
