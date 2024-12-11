import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinUser;
import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinUser.INPUT;

public class main {
    public static void main(String[] args) {
        // Ablak neve, amelynek küldeni szeretnénk a leütést (pl. Jegyzettömb)
        String windowTitle = "Untitled - Notepad";

        // Cél ablak keresése a cím alapján
        HWND hwnd = User32.INSTANCE.FindWindow(null, windowTitle);
        

        if (hwnd != null) {
            // SendMessage függvénnyel küldhetünk üzeneteket anélkül, hogy az ablak fókuszba kerülne
            User32.INSTANCE.SendMessage(hwnd, WinUser.WM_KEYDOWN, new WinDef.WPARAM(0x0D), new WinDef.LPARAM(0)); // "Enter" billentyű kódja
            User32.INSTANCE.SendMessage(hwnd, WinUser.WM_KEYUP, new WinDef.WPARAM(0x0D), new WinDef.LPARAM(0));
            
            System.out.println("Enter gomb elküldve a háttérablaknak.");
        } else {
            System.out.println("A megadott ablak nem található.");
        }
    }
}
