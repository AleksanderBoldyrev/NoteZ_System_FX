/********************************************************************************
 ** Form generated from reading ui file 'Note.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.7
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_MainWindow implements com.trolltech.qt.QUiForm<QMainWindow>
{
    public QAction actionInformation;
    public QWidget centralwidget;
    public QFrame frame;
    public QListView tagList;
    public QPushButton tagCreateButton;
    public QLineEdit tagEdit;
    public QPushButton searchButton;
    public QFrame frame_2;
    public QTextEdit noteField;
    public QLineEdit lineEdit;
    public QLabel label_2;
    public QScrollBar verticalScrollBar;
    public QPushButton noteCommitButton;
    public QLabel modeLabel;
    public QFrame frame_3;
    public QPushButton newNoteButton;
    public QPushButton saveButton;
    public QPushButton searchByNameButton;
    public QFrame frame_4;
    public QPushButton changeModeButton;
    public QPushButton quitButton;
    public QListView noteList;
    public QScrollBar verticalScrollBar_2;
    public QMenuBar menubar;
    public QMenu menuAbout;
    public QStatusBar statusbar;

    public Ui_MainWindow() { super(); }

    public void setupUi(QMainWindow MainWindow)
    {
        MainWindow.setObjectName("MainWindow");
        MainWindow.resize(new QSize(1008, 739).expandedTo(MainWindow.minimumSizeHint()));
        actionInformation = new QAction(MainWindow);
        actionInformation.setObjectName("actionInformation");
        centralwidget = new QWidget(MainWindow);
        centralwidget.setObjectName("centralwidget");
        frame = new QFrame(centralwidget);
        frame.setObjectName("frame");
        frame.setGeometry(new QRect(20, 60, 181, 541));
        frame.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        frame.setFrameShadow(com.trolltech.qt.gui.QFrame.Shadow.Raised);
        tagList = new QListView(frame);
        tagList.setObjectName("tagList");
        tagList.setGeometry(new QRect(0, 0, 161, 481));
        tagCreateButton = new QPushButton(frame);
        tagCreateButton.setObjectName("tagCreateButton");
        tagCreateButton.setGeometry(new QRect(110, 500, 61, 23));
        tagEdit = new QLineEdit(frame);
        tagEdit.setObjectName("tagEdit");
        tagEdit.setGeometry(new QRect(0, 500, 101, 20));
        searchButton = new QPushButton(frame);
        searchButton.setObjectName("searchButton");
        searchButton.setGeometry(new QRect(190, 530, 41, 23));
        frame_2 = new QFrame(centralwidget);
        frame_2.setObjectName("frame_2");
        frame_2.setGeometry(new QRect(210, 60, 581, 541));
        frame_2.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        frame_2.setFrameShadow(com.trolltech.qt.gui.QFrame.Shadow.Raised);
        noteField = new QTextEdit(frame_2);
        noteField.setObjectName("noteField");
        noteField.setGeometry(new QRect(0, 0, 581, 451));
        QFont font = new QFont();
        font.setPointSize(9);
        noteField.setFont(font);
        lineEdit = new QLineEdit(frame_2);
        lineEdit.setObjectName("lineEdit");
        lineEdit.setGeometry(new QRect(0, 470, 511, 20));
        label_2 = new QLabel(frame_2);
        label_2.setObjectName("label_2");
        label_2.setGeometry(new QRect(530, 470, 46, 13));
        verticalScrollBar = new QScrollBar(frame_2);
        verticalScrollBar.setObjectName("verticalScrollBar");
        verticalScrollBar.setGeometry(new QRect(560, 0, 21, 451));
        verticalScrollBar.setOrientation(com.trolltech.qt.core.Qt.Orientation.Vertical);
        noteCommitButton = new QPushButton(frame_2);
        noteCommitButton.setObjectName("noteCommitButton");
        noteCommitButton.setGeometry(new QRect(530, 500, 31, 23));
        modeLabel = new QLabel(centralwidget);
        modeLabel.setObjectName("modeLabel");
        modeLabel.setGeometry(new QRect(20, 630, 951, 51));
        QFont font1 = new QFont();
        font1.setPointSize(12);
        modeLabel.setFont(font1);
        frame_3 = new QFrame(centralwidget);
        frame_3.setObjectName("frame_3");
        frame_3.setGeometry(new QRect(820, 60, 181, 161));
        frame_3.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        frame_3.setFrameShadow(com.trolltech.qt.gui.QFrame.Shadow.Raised);
        newNoteButton = new QPushButton(frame_3);
        newNoteButton.setObjectName("newNoteButton");
        newNoteButton.setGeometry(new QRect(50, 20, 75, 23));
        saveButton = new QPushButton(frame_3);
        saveButton.setObjectName("saveButton");
        saveButton.setGeometry(new QRect(50, 70, 75, 23));
        searchByNameButton = new QPushButton(frame_3);
        searchByNameButton.setObjectName("searchByNameButton");
        searchByNameButton.setGeometry(new QRect(50, 120, 91, 23));
        frame_4 = new QFrame(centralwidget);
        frame_4.setObjectName("frame_4");
        frame_4.setGeometry(new QRect(20, 10, 951, 41));
        frame_4.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        frame_4.setFrameShadow(com.trolltech.qt.gui.QFrame.Shadow.Raised);
        changeModeButton = new QPushButton(frame_4);
        changeModeButton.setObjectName("changeModeButton");
        changeModeButton.setGeometry(new QRect(0, 10, 111, 23));
        quitButton = new QPushButton(frame_4);
        quitButton.setObjectName("quitButton");
        quitButton.setGeometry(new QRect(130, 10, 75, 23));
        noteList = new QListView(centralwidget);
        noteList.setObjectName("noteList");
        noteList.setGeometry(new QRect(820, 230, 171, 351));
        verticalScrollBar_2 = new QScrollBar(centralwidget);
        verticalScrollBar_2.setObjectName("verticalScrollBar_2");
        verticalScrollBar_2.setGeometry(new QRect(970, 230, 21, 351));
        verticalScrollBar_2.setOrientation(com.trolltech.qt.core.Qt.Orientation.Vertical);
        MainWindow.setCentralWidget(centralwidget);
        menubar = new QMenuBar(MainWindow);
        menubar.setObjectName("menubar");
        menubar.setGeometry(new QRect(0, 0, 1008, 21));
        menuAbout = new QMenu(menubar);
        menuAbout.setObjectName("menuAbout");
        MainWindow.setMenuBar(menubar);
        statusbar = new QStatusBar(MainWindow);
        statusbar.setObjectName("statusbar");
        MainWindow.setStatusBar(statusbar);

        menubar.addAction(menuAbout.menuAction());
        menuAbout.addAction(actionInformation);
        retranslateUi(MainWindow);

        MainWindow.connectSlotsByName();
    } // setupUi

    void retranslateUi(QMainWindow MainWindow)
    {
        MainWindow.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "MainWindow", null));
        actionInformation.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Information.", null));
        tagCreateButton.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Create tag", null));
        searchButton.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Search", null));
        label_2.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Title", null));
        noteCommitButton.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "OK", null));
        modeLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Writing mode.", null));
        newNoteButton.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "New Note", null));
        saveButton.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Save", null));
        searchByNameButton.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Search by Name", null));
        changeModeButton.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Write/Read", null));
        quitButton.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "\u0412\u044b\u0445\u043e\u0434", null));
        menuAbout.setTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "About", null));
    } // retranslateUi

}

