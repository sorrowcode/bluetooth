package com.example.blueotooth

import android.bluetooth.le.ScanCallback
import android.bluetooth.le.ScanResult

class CustomScanCallback: ScanCallback() {

    private var results: MutableList<ScanResult>? = null
        get() {
            return results
        }

    override fun onBatchScanResults(results: MutableList<ScanResult>?) {
        super.onBatchScanResults(results)
        this.results = results
        if (results != null) {
            for (result in results) {
                println(result.device.address)
            }
        } else {
            println("nothing found")
        }
    }
}