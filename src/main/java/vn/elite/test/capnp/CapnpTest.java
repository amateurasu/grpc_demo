package vn.elite.test.capnp;

import org.capnproto.MessageBuilder;
import org.capnproto.SerializePacked;

import java.io.FileOutputStream;
import java.io.IOException;

public class CapnpTest {

    public static void main(String[] args) throws IOException {
        var l1 = System.currentTimeMillis();
        var messageBuilder = new MessageBuilder();
        var wifiMessage = messageBuilder.initRoot(Messages.Wifi.factory);

        wifiMessage.setType(Messages.Wifi.Type.WIFI);
        wifiMessage.setConnection(Messages.Wifi.Connection.GSM);
        wifiMessage.setBattery((byte) 100);

        var cells = wifiMessage.initCells(1);
        var cell = cells.get(0);
        cell.setCid(12345);
        cell.setLac((short) 123);
        cell.setMnc((short) 452);
        cell.setMcc((short) 125);
        cell.setSignal((short) -123);

        var apSize = 3;
        var aps = wifiMessage.initAps(apSize);
        for (var i = 0; i < apSize; i++) {
            var ap = aps.get(i);
            setAP(ap);
        }
        var l2 = System.currentTimeMillis();

        var test = new FileOutputStream("capnp").getChannel();
        SerializePacked.writeToUnbuffered(test, messageBuilder);
        var l3 = System.currentTimeMillis();

        System.out.println(l1);
        System.out.println(l2);
        System.out.println(l3);
        System.out.println("l2-l1=" + (l2 - l1) + "; l3-l2=" + (l3 - l2));
    }

    private static void setAP(Messages.Wifi.AP.Builder ap) {
        ap.setSignal((byte) -123);
        var mac = ap.initMac(6);
        mac.set((byte) 0, (byte) 0xAA);
        mac.set((byte) 1, (byte) 0x11);
        mac.set((byte) 2, (byte) 0x22);
        mac.set((byte) 3, (byte) 0x33);
        mac.set((byte) 4, (byte) 0x44);
        mac.set((byte) 5, (byte) 0x55);
    }
}
