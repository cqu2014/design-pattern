package pattern.io.processcontrol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Oliver Wang
 * @description 进程执行器
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2021/2/10
 * @since
 */
public class OSExecute {
    public static void command(String command) {
        boolean err = false;
        try{
            Process process = new ProcessBuilder(command.split(" ")).start();
            BufferedReader result = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            String s;
            while ((s = result.readLine()) != null){
                System.out.println(s);
            }
            BufferedReader errors = new BufferedReader(
                    new InputStreamReader(process.getErrorStream()));
            while ((s = errors.readLine()) != null){
                System.err.println(s);
                err = true;
            }
        } catch (IOException e) {
            if (!command.startsWith("CMD /C")){
                command("CMD /C " + command);
            } else {
               throw new RuntimeException();
            }
            if (err){
                throw new OSExecuteException("Error executing " + command);
            }
        }
    }
}
