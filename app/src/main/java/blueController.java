import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.
import java.util.ArrayList;




/**
 * Created by David on 02/01/2017.
 */

public class blueController {
    private static final int REQUEST_ENABLE_BT = 1;
    private BluetoothAdapter mBluetoothAdapter;
    private ArrayList<BluetoothDevice> mBluetoothDevices;

    // Iniciar Bluetooth
    public int initAdapter(){
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if(mBluetoothAdapter == null){
            return -1;  //No tenemos dispositivo Bluetooth
        }

        // Comrpobamos si el Bluetooth está activado. En caso contrario lo activamos.
        if (!mBluetoothAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            //startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);

        }
        return 0;
    }




        private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();

                if(BluetoothDevice.ACTION_FOUND.equals(action)){
                    BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                    mBluetoothDevices.add(device);
                    String descriptionDevice = device.getName() + "::" + device.getAddress();

                } else if(BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)){
                    //Aquí habría que mostrar graficamente la lista de dispositivos econtrados.
                }
            }
        };


    public int conectionToDevice() {
        return 0;
    }



}
