package NotesSystem.client;

/**
 * Created by Alex on 19.11.2015.
 */
    import com.trolltech.qt.core.*;
    import com.trolltech.qt.gui.*;

    public class Ui_LoginWindow extends QDialog
    {
        public QLineEdit lineEdit;
        public QLineEdit lineEdit_2;
        public QLabel label;
        public QLabel label_2;
        public QLabel label_3;
        public QLabel label_4;
        public QPushButton pushButton;
        public QPushButton pushButton_2;

        public Ui_LoginWindow() { super(); }

        public void setupUi(QDialog Dialog)
        {
            Dialog.setObjectName("Dialog");
            Dialog.resize(new QSize(400, 300).expandedTo(Dialog.minimumSizeHint()));
            lineEdit = new QLineEdit(Dialog);
            lineEdit.setObjectName("lineEdit");
            lineEdit.setGeometry(new QRect(100, 60, 241, 20));
            lineEdit_2 = new QLineEdit(Dialog);
            lineEdit_2.setObjectName("lineEdit_2");
            lineEdit_2.setGeometry(new QRect(102, 130, 241, 20));
            label = new QLabel(Dialog);
            label.setObjectName("label");
            label.setGeometry(new QRect(30, 270, 351, 20));
            label_2 = new QLabel(Dialog);
            label_2.setObjectName("label_2");
            label_2.setGeometry(new QRect(10, 60, 46, 13));
            label_3 = new QLabel(Dialog);
            label_3.setObjectName("label_3");
            label_3.setGeometry(new QRect(20, 140, 46, 13));
            label_4 = new QLabel(Dialog);
            label_4.setObjectName("label_4");
            label_4.setGeometry(new QRect(100, 20, 251, 20));
            pushButton = new QPushButton(Dialog);
            pushButton.setObjectName("pushButton");
            pushButton.setGeometry(new QRect(100, 210, 75, 23));
            pushButton_2 = new QPushButton(Dialog);
            pushButton_2.setObjectName("pushButton_2");
            pushButton_2.setGeometry(new QRect(240, 210, 75, 23));
            retranslateUi(Dialog);

            Dialog.connectSlotsByName();
        } // setupUi

        void retranslateUi(QDialog Dialog)
        {
            Dialog.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Dialog", null));
            label.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "TextLabel", null));
            label_2.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "TextLabel", null));
            label_3.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "TextLabel", null));
            label_4.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "TextLabel", null));
            pushButton.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "PushButton", null));
            pushButton_2.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "PushButton", null));
        } // retranslateUi

    }

