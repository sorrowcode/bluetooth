package com.example.blueotooth

import android.Manifest
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.bluetooth.le.BluetoothLeScanner
import android.content.Context
import android.content.pm.PackageManager
import android.os.Handler
import androidx.core.app.ActivityCompat

class BluetoothStuff(var bluetoothAdapter: BluetoothAdapter, private val bluetoothLeScanner: BluetoothLeScanner, context: Context) {

    private val handler = Handler()
    private var scanning = false
    // Stops scanning after 10 seconds.
    private val SCAN_PERIOD: Long = 10000
    private val context = context
    private var scanCallback = CustomScanCallback()

    private fun scanLeDevice() {
        if (!scanning) { // Stops scanning after a pre-defined scan period.
            handler.postDelayed({
                scanning = false
                bluetoothLeScanner.stopScan(scanCallback)
            }, SCAN_PERIOD)
            scanning = true
            bluetoothLeScanner.startScan(scanCallback)
        } else {
            scanning = false
            bluetoothLeScanner.stopScan(scanCallback)
        }
    }
}