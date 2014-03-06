/*
 * Copyright (c) 2014 Rex St. John on behalf of AirPair.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.ultimate.camera.utilities;

import android.bluetooth.BluetoothAdapter;
import android.os.Build;

/**
 * Utility for fetching details about the device.
 *
 * Created by Rex St. John (on behalf of AirPair.com) on 3/6/14.
 */
public class DeviceInfo {

    /**
     * Get the device's manufacturer name string.
     * @return
     */
    public static String getDeviceName() {
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;
        if (model.startsWith(manufacturer)) {
            return capitalize(model);
        } else {
            return capitalize(manufacturer) + " " + model;
        }
    }

    /**
     * Get the device's UUID
     * @return
     */
    public static String getDeviceUUID(){
        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
        String uuid = adapter.getAddress();
        return uuid;
    }

    /**
     * Internal helper to capitalize the string properly.
     * @param s
     * @return
     */
    private static String capitalize(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char first = s.charAt(0);
        if (Character.isUpperCase(first)) {
            return s;
        } else {
            return Character.toUpperCase(first) + s.substring(1);
        }
    }

    /**
     * Is this application an emulator?
     * @return
     */
    public static boolean isEmulator(){
        String brand = Build.BRAND;
        if (brand.equalsIgnoreCase("generic")) {
            return true;
        } else {
            return false;
        }
    }
}