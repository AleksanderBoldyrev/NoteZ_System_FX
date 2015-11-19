package NotesSystem.client;

/**
 * Created by Alex on 12.11.2015.
 */

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_MainWindow extends QMainWindow
{
    public QWidget centralwidget;
    public QFrame frame;
    public QListView listView;
    public QPushButton sortByNameButton;
    public QPushButton sortByTagButton;
    public QPushButton sortByIdButton;
    public QLineEdit lineEdit_2;
    public QPushButton searchButton;
    public QPushButton newNoteButton;
    public QFrame frame_2;
    public QTextEdit noteField;
    public QPushButton changeModeButton;
    public QPushButton quitButton;
    public QLineEdit lineEdit;
    public QPushButton saveButton;
    public QLabel label;
    public QMenuBar menubar;
    public QStatusBar statusbar;

    public Ui_MainWindow() { super(); }

    public void setupUi(QMainWindow MainWindow)
    {
        MainWindow.setObjectName("MainWindow");
        MainWindow.resize(new QSize(817, 640).expandedTo(MainWindow.minimumSizeHint()));
        centralwidget = new QWidget(MainWindow);
        centralwidget.setObjectName("centralwidget");
        frame = new QFrame(centralwidget);
        frame.setObjectName("frame");
        frame.setGeometry(new QRect(20, 30, 241, 571));
        frame.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        frame.setFrameShadow(com.trolltech.qt.gui.QFrame.Shadow.Raised);
        listView = new QListView(frame);
        listView.setObjectName("listView");
        listView.setGeometry(new QRect(-5, 51, 241, 431));
        sortByNameButton = new QPushButton(frame);
        sortByNameButton.setObjectName("sortByNameButton");
        sortByNameButton.setGeometry(new QRect(10, 490, 51, 23));
        sortByTagButton = new QPushButton(frame);
        sortByTagButton.setObjectName("sortByTagButton");
        sortByTagButton.setGeometry(new QRect(80, 490, 51, 23));
        sortByIdButton = new QPushButton(frame);
        sortByIdButton.setObjectName("sortByIdButton");
        sortByIdButton.setGeometry(new QRect(150, 490, 75, 23));
        lineEdit_2 = new QLineEdit(frame);
        lineEdit_2.setObjectName("lineEdit_2");
        lineEdit_2.setGeometry(new QRect(0, 530, 171, 20));
        searchButton = new QPushButton(frame);
        searchButton.setObjectName("searchButton");
        searchButton.setGeometry(new QRect(190, 530, 41, 23));
        newNoteButton = new QPushButton(frame);
        newNoteButton.setObjectName("newNoteButton");
        newNoteButton.setGeometry(new QRect(20, 10, 75, 23));
        frame_2 = new QFrame(centralwidget);
        frame_2.setObjectName("frame_2");
        frame_2.setGeometry(new QRect(280, 30, 511, 571));
        frame_2.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        frame_2.setFrameShadow(com.trolltech.qt.gui.QFrame.Shadow.Raised);
        noteField = new QTextEdit(frame_2);
        noteField.setObjectName("noteField");
        noteField.setGeometry(new QRect(0, 0, 511, 451));
        changeModeButton = new QPushButton(frame_2);
        changeModeButton.setObjectName("changeModeButton");
        changeModeButton.setGeometry(new QRect(230, 520, 111, 23));
        quitButton = new QPushButton(frame_2);
        quitButton.setObjectName("quitButton");
        quitButton.setGeometry(new QRect(400, 520, 75, 23));
        lineEdit = new QLineEdit(frame_2);
        lineEdit.setObjectName("lineEdit");
        lineEdit.setGeometry(new QRect(2, 470, 511, 20));
        saveButton = new QPushButton(frame_2);
        saveButton.setObjectName("saveButton");
        saveButton.setGeometry(new QRect(50, 520, 75, 23));
        label = new QLabel(centralwidget);
        label.setObjectName("label");
        label.setGeometry(new QRect(150, 595, 621, 31));
        MainWindow.setCentralWidget(centralwidget);
        menubar = new QMenuBar(MainWindow);
        menubar.setObjectName("menubar");
        menubar.setGeometry(new QRect(0, 0, 817, 21));
        MainWindow.setMenuBar(menubar);
        statusbar = new QStatusBar(MainWindow);
        statusbar.setObjectName("statusbar");
        MainWindow.setStatusBar(statusbar);
        retranslateUi(MainWindow);

        MainWindow.connectSlotsByName();
    } // setupUi

    void retranslateUi(QMainWindow MainWindow)
    {
        MainWindow.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "MainWindow", null));
        sortByNameButton.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "S Name", null));
        sortByTagButton.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "S Tag", null));
        sortByIdButton.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "S Id", null));
        searchButton.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Search", null));
        newNoteButton.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "New Note", null));
        changeModeButton.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "\u0421\u043c\u0435\u043d\u0438\u0442\u044c \u0440\u0435\u0436\u0438\u043c", null));
        quitButton.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "\u0412\u044b\u0445\u043e\u0434", null));
        saveButton.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Save", null));
        label.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "\u042f \u043c\u0435\u0442\u043a\u043e", null));
    } // retranslateUi

}
