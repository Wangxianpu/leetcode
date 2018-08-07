package com.wxp.io;

import java.io.*;
import java.util.*;

/**
 * @Author : shampoowang
 * @Date:Created : 2018/6/30 11:47
 * @Description : 实际场景，需要从a文件中筛选出b文件中存在的数据，同时a文件中不在b文件中的数据也记录出来，输出两个文件记录结果
 */

public class PayFile {

    public static Map<String,List<String>> map = new HashMap<String, List<String>>();

    public static final String FAIL_ASSET = "fail";

    public static final String SUCCESS_ASSET = "success";

    public static final String ALL_ASSET = "all";

    public static final String OLD_SUCCESS = "old_success";

    public static String FILE_PATH = "C:/Users/v_shampoowang/Desktop/tmpFile";

    public static void main(String[] args) throws IOException {


        String fromA = "C:/Users/v_shampoowang/Desktop/杭银消费金融/杭银贷后/众安三期合同签章影像资料补传.txt";
        String fromB = "C:/Users/v_shampoowang/Desktop/杭银消费金融/杭银贷后/杭银付款成功需要补传记录.txt";
//        String fromA = "C:/Users/v_shampoowang/Desktop/tmpFile/1.txt";
//        String fromB = "C:/Users/v_shampoowang/Desktop/tmpFile/2.txt";

        receive(fromA,fromB);
    }

    private static void receive(String fromA, String fromB) throws IOException {
        BufferedReader brA = null,brB = null;
        try{
            brA = new BufferedReader(new InputStreamReader(new FileInputStream(fromA)));
            brB = new BufferedReader(new InputStreamReader(new FileInputStream(fromB)));

            map.put(ALL_ASSET,parse2Map(brA));
            map.put(OLD_SUCCESS,parse2Map(brB));

            //文件对数据，获得还没有推的付款成功的订单和不是付款成功的订单
            check();
            //输出新的文件
            export2File();

        }catch (Exception e){

        }finally {
            if(brA!=null){
                brA.close();
            }
            if(brB != null){
                brB.close();
            }
        }

    }

    private static void export2File() throws IOException {
        BufferedWriter bwA = null;
        BufferedWriter bwB = null;
        StringBuffer sbA = new StringBuffer();
        StringBuffer sbB = new StringBuffer();
        try{
            bwA = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FILE_PATH.concat("/A.txt"))));
            bwB = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FILE_PATH.concat("/B.txt"))));

            for(String tmp : map.get(SUCCESS_ASSET)){
                sbA.append(tmp).append("\r\n");
            }

            for(String tmp : map.get(FAIL_ASSET)){
                sbB.append(tmp).append("\r\n");
            }

            bwA.write(sbA.toString());
            bwA.flush();

            bwB.write(sbB.toString());
            bwB.flush();
        }catch (Exception e){

        }finally {
            if(bwA!=null){
                bwA.close();
            }
            if(bwB != null){
                bwB.close();
            }
        }

     }

    private static void check() {
        List<String> listAll = map.get(ALL_ASSET);
        List<String> listOld = map.get(OLD_SUCCESS);
        List<String> resultSuccess = new ArrayList<String>();
        List<String> resultFail = new ArrayList<String>();

        //先将付款成功的数据存入set，在用set的key判断是否包含放款成功的数据
        Set<String> set = new HashSet<String>();
        for(String tmp : listOld){
            set.add(tmp);
        }

        //包含，表示这个是付款成功，还存在的
        for(String tmp : listAll){
            if(set.contains(tmp)){
                resultSuccess.add(tmp);
            }else{
                resultFail.add(tmp);
            }
        }
        map.put(FAIL_ASSET,resultFail);
        map.put(SUCCESS_ASSET,resultSuccess);
    }

    private static List<String> parse2Map(BufferedReader br) throws IOException {
        List<String> list = new ArrayList<String>();
        String line;
        while((line = br.readLine())!=null){
            list.add(line.trim());
        }
        return list;
    }

}
