package com.wxp.algrithm.normalMid;


import com.wxp.common.ConstantsTest;

public class MiniLanguageAnalyzer_385 {
    public static void main(String[] args) {
//        String str = "[123,[456,[789],[65]]]";
        String str = "[123,[456,[789]]]";
        System.out.println(ConstantsTest.GSON.toJson(deserialize2(str)));
    }

    private static NestedInteger deserialize2(String s) {
        if(s == null || s.length() == 0){
            return null;
        }
        if(s.charAt(0) != '['){
            return new NestedInteger(Integer.parseInt(s));
        }

        if(s.length() <= 2){
            return new NestedInteger();
        }
        NestedInteger res = new NestedInteger();
        //记录某一层的真实位置
        int start = 1;
        //当前级别，遇到‘[’升级，遇到‘]’降级
        int cnt = 0;
        for(int i = 1 ; i < s.length() ; i++){
            //每次只对当前级别,
            if(cnt == 0 && (s.charAt(i) == ',' || i == s.length() - 1 )){
                //从','后截取
                res.add(deserialize2(s.substring(start, i )));
                start = 1 + i;
            }
            //遇到‘[’升级
            if(s.charAt(i) == '['){
                cnt++;
            }
            //遇到‘]’降级
            if(s.charAt(i) == ']'){
                cnt--;
            }
        }
        return res;
    }


    static String str = "";

    public static NestedInteger deserialize(String s) {
        str = s;
        //如果没有嵌套
        if( str.charAt(0) != '['){
            return new NestedInteger(Integer.parseInt(str));
        }
        //嵌套的情况
        NestedInteger resultInteger = new NestedInteger();
        str = str.substring(1);
        dfsFill(resultInteger);
        return resultInteger;
    }

    /**
     * 递对nestedInteger进行填充
     * @param resultInteger 待填充的integer
     */
    private static void dfsFill( NestedInteger resultInteger) {
        if(str == null || str.length() == 1){
            return ;
        }
        while(str.length() > 0 && (str.charAt(0) == ',' || str.charAt(0) == '[') ){
            str = str.substring(1);
        }
        //确定下一个填充的数字分割符号
        int preNum = str.indexOf("[");
        //确定当前nestInteger是否应当终结
        int endNum = str.indexOf("]");
        if(endNum == 0){
            str = str.substring(1);
            return ;
        }
        if(preNum == -1 && endNum == -1){
            return ;
        }
        //如果结束符号在开始符号前，则表明需要结束当前解析，返回
        if(endNum < preNum || preNum == -1){
            String endStr = str.substring(0,endNum );
            NestedInteger newInter = new NestedInteger(Integer.parseInt(endStr));
            resultInteger.add(newInter);
            str = str.substring(endNum);
        }else{
            String preStr = str.substring(0,preNum - 1);
            NestedInteger newInter = new NestedInteger(Integer.parseInt(preStr));
            resultInteger.add(newInter);
            //进行下一轮解析
            str = str.substring(preNum);
            dfsFill(newInter);
        }
    }
}
