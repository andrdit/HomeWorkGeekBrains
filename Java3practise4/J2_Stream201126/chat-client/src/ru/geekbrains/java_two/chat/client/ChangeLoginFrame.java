package ru.geekbrains.java_two.chat.client;

import ru.geekbrains.java_two.network.SocketThread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ChangeLoginFrame extends JFrame implements ActionListener,
        Thread.UncaughtExceptionHandler {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private static final String WINDOW_TITLE = "Chat client: change login";

    private ClientGUI clientGUI;

    private final JPanel panelTextFields = new JPanel(new GridLayout(1, 3));
    private final JPanel panelButtons = new JPanel(new GridLayout(1, 2));


    private final JTextField tfLogin = new JTextField("ivan");
    private final JPasswordField tfPassword = new JPasswordField("123");
    private final JTextField tfLoginNew = new JTextField("");

    private final JButton btnChange = new JButton("Change");
    private final JButton btnCancel = new JButton("Cancel");


    private final JButton btnDisconnect = new JButton("<html><b>Disconnect</b></html>");
    private final JTextField tfMessage = new JTextField();
    private final JButton btnSend = new JButton("Send");

    private final JList<String> userList = new JList<>();
    private boolean shownIoErrors = false;
    private SocketThread socketThread;

    private final JMenuBar menuBar = new JMenuBar();
    private final JMenu fileMenu = new JMenu("Menu");
    private final JMenuItem changeLogin = new JMenuItem("Change login");


    public ChangeLoginFrame(ClientGUI clientGUI) {

        Thread.setDefaultUncaughtExceptionHandler(this);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(WIDTH, HEIGHT);
        setTitle(WINDOW_TITLE);

        btnCancel.addActionListener(this);
        btnChange.addActionListener(this);


        Font font = new Font("Verdana", Font.PLAIN, 11);
        fileMenu.setFont(font);
        changeLogin.setFont(font);
        fileMenu.add(changeLogin);
        menuBar.add(fileMenu);

        setJMenuBar(menuBar);

        changeLogin.addActionListener(this);

        setPreferredSize(new Dimension(270, 225));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

//        panelTop.add(tfIPAddress);
//        panelTop.add(tfPort);
//        panelTop.add(cbAlwaysOnTop);
//        panelTop.add(tfLogin);
//        panelTop.add(tfPassword);
//        panelTop.add(btnLogin);
//
//
//        panelBottom.add(btnDisconnect, BorderLayout.WEST);
//        panelBottom.add(tfMessage, BorderLayout.CENTER);
//        panelBottom.add(btnSend, BorderLayout.EAST);
//
//        panelBottom.setVisible(false);

        panelTextFields.add(tfLogin);
        panelTextFields.add(tfLoginNew);
        panelTextFields.add(tfPassword);

        panelButtons.add(btnChange);
        panelButtons.add(btnCancel);



        add(panelTextFields, BorderLayout.NORTH);
        add(panelButtons, BorderLayout.SOUTH);



        setVisible(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if  (src == btnSend || src == tfMessage) {
          //  sendMessage();
        } else if (src == btnChange) {
          //  connect();
        } else if (src == btnCancel) {
          //  socketThread.close();
        } else if (src == changeLogin) {
         //   changeLogin();
        } else {
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
