package ru.geekbrains.java_two.chat.client;

import ru.geekbrains.java_two.network.SocketThread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeLoginFrame extends JFrame implements ActionListener,
        Thread.UncaughtExceptionHandler {

    private static final int WIDTH = 500 ;
    private static final int HEIGHT = 140;
    private static final String WINDOW_TITLE = "Chat client: change login";

    private ClientGUI clientGUI;

    private final JPanel panelTextFields = new JPanel(new GridLayout(4, 2));

    private final JTextArea textAreaCurrentLogin = new JTextArea("Login:", 1,1);
    private final JTextArea textAreaPassword     = new JTextArea("Password:", 1,1);
    private final JTextArea textAreaNewNickName  = new JTextArea("New nickname:", 1,1);

    private final JTextField tfLogin        = new JTextField();
    private final JPasswordField tfPassword = new JPasswordField();
    private final JTextField tfNewNickname  = new JTextField("");

    private final JButton btnChange = new JButton("Change");
    private final JButton btnCancel = new JButton("Cancel");


    private final JButton btnDisconnect = new JButton("<html><b>Disconnect</b></html>");
    private final JTextField tfMessage = new JTextField();
    private final JButton btnSend = new JButton("Send");

    private final JList<String> userList = new JList<>();
    private boolean shownIoErrors = false;
    private SocketThread socketThread;


    public ChangeLoginFrame(ClientGUI clientGUI) {

        Thread.setDefaultUncaughtExceptionHandler(this);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(WIDTH, HEIGHT);
        setTitle(WINDOW_TITLE);

        this.clientGUI = clientGUI;

        btnCancel.addActionListener(this);
        btnChange.addActionListener(this);

        textAreaCurrentLogin.setEditable(false);
        textAreaNewNickName.setEditable(false);
        textAreaPassword.setEditable(false);

        panelTextFields.add(textAreaCurrentLogin);
        panelTextFields.add(tfLogin);

        panelTextFields.add(textAreaPassword);
        panelTextFields.add(tfPassword);

        panelTextFields.add(textAreaNewNickName);
        panelTextFields.add(tfNewNickname);

        panelTextFields.add(btnChange);
        panelTextFields.add(btnCancel);

        add(panelTextFields, BorderLayout.NORTH);

        btnChange.addActionListener(this);
        btnCancel.addActionListener(this);

        setResizable(false);
        setVisible(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == btnChange) {
            clientGUI.sendMessageForChangeLogin(tfLogin.getText(), new String(tfPassword.getPassword()), tfNewNickname.getText());
            setVisible(false);
        } else if (src == btnCancel) {
          setVisible(false);
        }  else {
            throw new RuntimeException("Undefined source: " + src);
        }
    }

    private void showException(Thread t, Throwable e) {
        String msg;
        StackTraceElement[] ste = e.getStackTrace();
        if (ste.length == 0)
            msg = "Empty Stacktrace";
        else {
            msg = String.format("Exception in thread \"%s\" %s: %s\n\tat %s",
                    t.getName(), e.getClass().getCanonicalName(), e.getMessage(), ste[0]);
            JOptionPane.showMessageDialog(this, msg, "Exception", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        e.printStackTrace();
        showException(t, e);
        System.exit(1);
    }
}
