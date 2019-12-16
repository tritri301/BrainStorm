package Repositories;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class BackupRepository {
    public void create()
    {
        String command = "mysqldump --routines -u BrainStorm -pinfo420 EquipeTristan_BD > Backup/mysqlBackup_$(date +%F_%H:%M:%S).sql";
        ExecuteCommand(command);
    }
    public List<String> FindAll()
    {
        String command = "ls Backup/";
        return ExecuteCommand(command);
    }
    public void restore(String file)
    {
        String command = "mysql -uBrainStorm -pinfo420 EquipeTristan_BD < Backup/" + file;
        ExecuteCommand(command);
    }
    private List<String> ExecuteCommand(String command)
    {
        List<String> ret = new ArrayList<>();
        String host="10.20.40.40";
        String user="pi";
        String password="raspberry";
        try{
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            JSch jsch = new JSch();
            Session session=jsch.getSession(user, host, 22);
            session.setPassword(password);
            session.setConfig(config);
            session.connect();

            Channel channel=session.openChannel("exec");
            ((ChannelExec)channel).setCommand(command);
            channel.setInputStream(null);
            ((ChannelExec)channel).setErrStream(System.err);

            InputStream in=channel.getInputStream();
            channel.connect();
            byte[] tmp=new byte[1024];
            while(true){
                while(in.available()>0){
                    int i=in.read(tmp, 0, 1024);
                    if(i<0)break;
                    ret.add(new String(tmp, 0, i));
                }
                if(channel.isClosed()){
                    break;
                }
                try{Thread.sleep(1000);}catch(Exception ee){}
            }
            channel.disconnect();
            session.disconnect();
        }catch(Exception e){
            e.printStackTrace();
        }
        return ret;
    }
}
