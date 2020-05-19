package xyz.intellij.java.relearn.basic.smalltool;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.Base64;
import java.util.Scanner;

/**
 * @Classname VmessPerser
 * @Description vmess解析器，使用这个可以解析vmess为config.json,目前只支持tsl+ws的vmess解析
 * @Date 2020/5/17 4:45
 * @Created by whp98
 */
public class VmessPerser {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入vmess：");
        String vmess = scanner.next();
        System.out.println("请输入socks5端口号：");
        int port = scanner.nextInt();
        String result = genConfigFileTls(vmess,port);
        System.out.println(result);
        //保存配置文件
        File cfgFile = new File("D:\\winHOME\\dt\\cfg.json");
        if(!cfgFile.exists()){
            cfgFile.createNewFile();
        }
        FileWriter fileWritter = new FileWriter(cfgFile.getAbsolutePath());
        assert result != null;
        fileWritter.write(result);
        fileWritter.close();
    }

    static String genConfigFileTls(String vmess,int port){
        String string = vmess;
        String tempJson = null;
        try {
            tempJson = fileReader("src\\main\\java\\xyz\\intellij\\java\\relearn\\basic\\smalltool\\ws.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = new JSONObject(tempJson);
        //改变本地端口
        //请输入端口号
        changePort(jsonObject,port);
        int count = 0;

        if(string.startsWith("vmess")) {
            String[] strings = string.split("//");
            JSONObject jsonObject1 = new JSONObject(decoder(strings[1]));
            changeHost(jsonObject, jsonObject1.getString("add"), (String) jsonObject1.get("port"),
                    (String) jsonObject1.get("path"), (String) jsonObject1.get("id"), (String) jsonObject1.get("aid"));
            return jsonObject.toString();
        }else{
            return null;
        }
    }

    //base64解码器
    static String decoder(String s){
        byte[] decoded = Base64.getDecoder().decode(s.getBytes());
        return new String(decoded);
    }


    //文件读取
    static String fileReader(String fileName) throws IOException {
        File file = new File(fileName);
        Reader reader = new InputStreamReader(new FileInputStream(file),"UTF-8");
        int ch = 0;
        StringBuffer stringBuffer = new StringBuffer();
        while((ch=reader.read())!=-1){
            stringBuffer.append((char)ch);
        }
        reader.close();
        return stringBuffer.toString();
    }
    //改变本地端口
    static void changePort(JSONObject jsonObject,int newport){
        //更改端口号
        JSONArray inbounds = (JSONArray) jsonObject.get("inbounds");
        JSONObject bendi = (JSONObject) inbounds.get(0);
        bendi.put("port",newport);
    }
    //改变uuid
    static void changeHost(JSONObject jsonObject ,String host,String port,String path,String newUUID,String aid){
        JSONArray outbounds = (JSONArray) jsonObject.get("outbounds");
        JSONObject remote = (JSONObject) outbounds.get(0);
        JSONObject settings = (JSONObject) remote.get("settings");

        JSONObject streamSettings = (JSONObject) remote.get("streamSettings");
        JSONObject wsSettings = (JSONObject)streamSettings.get("wsSettings");
        wsSettings.put("path",path);
        ((JSONObject)wsSettings.get("headers")).put("Host",host);
        ((JSONObject)streamSettings.get("tlsSettings")).put("serverName",host);
        JSONObject setting = (JSONObject) ((JSONArray) settings.get("vnext")).get(0);
        setting.put("address",host);
        setting.put("port",Integer.parseInt(port));
        JSONObject user = (JSONObject)((JSONArray)setting.get("users")).get(0);
        user.put("id",newUUID);
        user.put("alterId",Integer.parseInt(aid));
    }
}
