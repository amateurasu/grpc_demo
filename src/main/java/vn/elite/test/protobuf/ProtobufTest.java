package vn.elite.test.protobuf;

import com.google.protobuf.ByteString;
import vn.elite.test.Messages;

import java.io.FileOutputStream;
import java.io.IOException;

public class ProtobufTest {
    public static void main(String[] args) throws IOException {
        var l1 = System.currentTimeMillis();
        var ap = Messages.Wifi.AP.newBuilder()
            .setMac(ByteString.copyFrom(
                new byte[] {(byte) 0xAA, (byte) 0x11, (byte) 0x22, (byte) 0x33, (byte) 0x44, (byte) 0x55}))
            .setSignal(-123)
            .build();
        var wifi = Messages.Wifi.newBuilder()
            .setType(Messages.Wifi.Type.WIFI)
            .setConnection(Messages.Connection.GSM)
            .setBattery(100)
            .addCells(Messages.Wifi.Cell.newBuilder()
                .setCid(123)
                .setLac(123)
                .setMnc(3123)
                .setMac(12312)
                .setSignal(-123)
                .build())
            .addAps(ap)
            .addAps(ap)
            .addAps(ap)
            .build();

        var l2 = System.currentTimeMillis();
        wifi.writeTo(new FileOutputStream("protobuf"));
        var l3 = System.currentTimeMillis();

        System.out.println(l1);
        System.out.println(l2);
        System.out.println(l3);
        System.out.println("l2-l1=" + (l2 - l1) + "; l3-l2=" + (l3 - l2));
    }
}
