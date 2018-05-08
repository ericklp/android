package com.example.ericklopes.tempclient;

import android.os.Bundle;
import android.os.Message;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import android.os.Handler;

/**
 * Created by ericklopes on 24/04/18.
 */

public class Conversor extends Thread {
    private float tempF, tempC;
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private static final String IP = "10.0.2.2";
    private static final int porta = 12345;

    private Handler handler;

    public Conversor(float tempC, Handler handler) {
        this.tempC = tempC;
        this.handler = handler;
    }

    @Override
    public void run() {
        super.run();
        try {
            socket = new Socket(IP,porta);
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
            out.writeFloat(tempC);
            out.flush();
            tempF = in .readFloat();
            out.close();
            in.close();
            socket.close();
            Bundle b = new Bundle();
            b.putFloat("resultado", tempF);
            Message msg = new Message();
            msg.what = 1;
            msg.setData(b);
            handler.sendMessage(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
