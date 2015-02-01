package com.timoffex.structure;

/**
 * Created by timoffex on 1/31/15.
 */
public class Util {
    public static byte[] concat(byte[] ... b) {
        int totalSize = 0;
        for (int i = 0; i < b.length; i++)
            totalSize += b[i].length;

        int index = 0;
        byte[] out = new byte[totalSize];
        for (int i = 0; i < b.length; i++)
            for (int j = 0; j < b[i].length; j++)
                out[index++] = b[i][j];

        return out;
    }

    public static byte[] toBytes(long n) {
        byte[] b = new byte[8];

        for (int i = 0; i < 8; i++) {
            b[i] = (byte)((n>>((7-i)*8))&0xFF);
        }

        return b;
    }

    public static byte[] toBytes(String s) {
        return s.getBytes();
    }
}
