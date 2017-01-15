package com.example.david.bvcontroller;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;

import java.io.IOException;
import java.util.UUID;

/**
 * Created by David on 15/01/2017.
 */

public class ConnectThread extends Thread {
    private final BluetoothSocket mmSocket;
    private final BluetoothDevice mmDevice;

    private ConnectThread(BluetoothDevice device) {
        BluetoothSocket tmp = null;
        mmDevice = device;
        try{
            
            tmp = device.createRfcommSocketToServiceRecord(MY_UUID);

            
        }catch (IOException e){}
        mmSocket = tmp;
    }

    public void run(){
        mBluetoothAdapter.cancelDiscovery();
        try{
            mmSocket.connect();
        }catch (IOException connectException){
            try{
                mmSocket.close();
            }catch (IOException closeException){}
            return;
        }
        manageConnectedSocket(mmSocket);
    }

    public void close(){
        try{
            mmSocket.close();
        }catch (IOException e){}
    }
}
