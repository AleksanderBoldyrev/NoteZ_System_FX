package NotesSystem.client;

import com.trolltech.qt.gui.*;
import NotesSystem.main.*;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        QApplication.initialize("Notes Client", args);

        QApplication.setQuitOnLastWindowClosed(true);

        String fileString = QApplication.arguments().size() > 1 ? QApplication.arguments().get(1) : "";

        Client cl_1 = null;

        cl_1 = new Client(CommonData.PORT, CommonData.HOST);
        cl_1.startProcess();

        QApplication.execStatic();

        cl_1.stopListener();

        QApplication.shutdown();

    }
}
