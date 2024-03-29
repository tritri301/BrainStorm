package Controllers;

import Controllers.Interface.BackupControllerInterface;

import java.io.IOException;
import java.io.InputStream;

/**
 *  @Note Aucune remarque
 */
public class BackupController implements BackupControllerInterface
{
    private static final BackupController instance = new BackupController();


    /**
     * Get instance backup controller.
     *
     * @return the backup controller
     */
    public static BackupController GetInstance() {
        return instance;
    }

    public void ShowBackupMenu() {
        Runtime runtime = Runtime.getRuntime();
        try {
            Process p1 = runtime.exec("cmd /c start C:\\backup\\menubackup.bat");
            InputStream is = p1.getInputStream();
            int i = 0;
            while( (i = is.read() ) != -1) {
                System.out.print((char)i);
            }
        } catch(IOException ioException) {
            System.out.println(ioException.getMessage() );
        }
    }
}
