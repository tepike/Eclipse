package Halasz_Zold;

import java.net.*;
import java.util.Enumeration;

public class adatbazis {
    public static void main(String[] args) {
        try {
            // Megkeressük az összes hálózati interfészt
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface networkInterface = interfaces.nextElement();
                // Megvizsgáljuk az összes interfészhez tartozó Socket-eket
                Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress address = addresses.nextElement();
                    if (!address.isLoopbackAddress() && !address.isLinkLocalAddress() && address instanceof Inet4Address) {
                        // Ellenőrizzük az összes olyan IPv4 címet, amely nem a helyi hurok visszaállító vagy helyi hálózati cím
                        System.out.println("IP-cím: " + address.getHostAddress());
                        checkDatabaseConnection(address);
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    private static void checkDatabaseConnection(InetAddress address) {
        // Itt lehetne ellenőrizni, hogy az adott IP-címről van-e kimenő kapcsolat az SQL szerverek felé
        // Ehhez TCP/IP kapcsolatokat lehetne ellenőrizni, és megnézni, hogy azok az SQL szerverekkel vannak-e kapcsolatban
        // A részletek az implementációtól függenek, és itt érdemes lehet egy olyan könyvtárat vagy eszközt használni, amely képes az aktív hálózati kapcsolatok lekérdezésére és elemzésére.
    }
}
