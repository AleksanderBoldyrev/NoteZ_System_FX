package NotesSystem.main;

public class Main {

    public static void main(String[] args) {
        /*BaseWorker bs = new BaseWorker();

        bs.SaveData();*/

        System.out.println("Creating server.");
        ServerDaemon mainServer = new ServerDaemon(25000);
        System.out.println("Server created.");
        Thread serverThread = new Thread(mainServer);
        System.out.println("ServerThread created.");
        serverThread.start();
        System.out.println("Server stopped.");
    }
}
