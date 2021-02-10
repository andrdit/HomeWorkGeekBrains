package ru.geekbrains.java_two.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.time.LocalDateTime;
import java.util.logging.*;

public class ServerSocketThread extends Thread {
    private int port;
    private int timeout;
    private ServerSocketThreadListener listener;
    private final Logger logger = Logger.getLogger(ServerSocketThread.class.getName());
    private final Handler consoleHandler;
    private final Handler fileHandler;

    public ServerSocketThread(ServerSocketThreadListener listener, String name, int port, int timeout) {
        super(name);
        this.port = port;
        this.timeout = timeout;
        this.listener = listener;

        consoleHandler = new ConsoleHandler();

        Formatter formatter = new Formatter() {
            @Override
            public String format(LogRecord record) {
                return LocalDateTime.now() + " ->>- " + record.getMessage() + "\n";
            }
        };

        fileHandler = getFileHadler();

        consoleHandler.setFormatter(formatter);
        fileHandler.setFormatter(formatter);

        logger.addHandler(consoleHandler);
        logger.addHandler(fileHandler);
        logger.setUseParentHandlers(false);

        start();
    }

    private FileHandler getFileHadler(){
        try {
            return new FileHandler("Log.txt"); // 1024*10, 10, true
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void run() {
        logger.log(Level.INFO, "Server started");
        listener.onServerStart(this);
        try (ServerSocket server = new ServerSocket(port)) {
            server.setSoTimeout(timeout);
            listener.onServerSocketCreated(this, server);
            logger.log(Level.INFO, "Server socket created");
            while (!isInterrupted()) {
                Socket socket = null;
                try {
                    socket = server.accept();
                    logger.log(Level.INFO, "Client connected");
                    listener.onSocketAccepted(this, server, socket);
                } catch (SocketTimeoutException e) {
                    listener.onServerTimeout(this, server);
                }
            }
        } catch (IOException e) {
            logger.log(Level.WARNING, "Server exception: " + e.getMessage());
            listener.onServerException(this, e);
        } finally {
            logger.log(Level.INFO, "Server stopped");
            listener.onServerStop(this);
        }
    }
}
