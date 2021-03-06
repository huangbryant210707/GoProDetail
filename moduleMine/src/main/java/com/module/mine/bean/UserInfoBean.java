package com.module.mine.bean;

/**
 * Created by shibing on 18/5/22.
 */

public class UserInfoBean {


    /**
     * code : 00
     * msg : SUCCESS
     * data : {"id":6,"nickname":"你好呀","imgurl":"apache-tomcat-8.0.48/2018-06-06/11e64f5b1bb44f4c9b571632f7487f17.jpg","mobile":"18207182435","password":"","cardNum":"1234567890","cardName":"了解","cardBank":"中国建设银行","amount":0,"freezeAmount":0,"totalAmount":0,"pid":0,"childCount":0,"status":0,"requestCode":"18207182435"}
     */

    private String code;
    private String msg;
    private DataBean data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 6
         * nickname : 你好呀
         * imgurl : apache-tomcat-8.0.48/2018-06-06/11e64f5b1bb44f4c9b571632f7487f17.jpg
         * mobile : 18207182435
         * password :
         * cardNum : 1234567890
         * cardName : 了解
         * cardBank : 中国建设银行
         * amount : 0
         * freezeAmount : 0
         * totalAmount : 0
         * pid : 0
         * childCount : 0
         * status : 0
         * requestCode : 18207182435
         */

        private int id;
        private String nickname;
        private String imgurl;
        private String mobile;
        private String password;
        private String cardNum;
        private String cardName;
        private String cardBank;
        private int amount;
        private int freezeAmount;
        private int totalAmount;
        private int pid;
        private int childCount;
        private int status;
        private String requestCode;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getImgurl() {
            return imgurl;
        }

        public void setImgurl(String imgurl) {
            this.imgurl = imgurl;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getCardNum() {
            return cardNum;
        }

        public void setCardNum(String cardNum) {
            this.cardNum = cardNum;
        }

        public String getCardName() {
            return cardName;
        }

        public void setCardName(String cardName) {
            this.cardName = cardName;
        }

        public String getCardBank() {
            return cardBank;
        }

        public void setCardBank(String cardBank) {
            this.cardBank = cardBank;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public int getFreezeAmount() {
            return freezeAmount;
        }

        public void setFreezeAmount(int freezeAmount) {
            this.freezeAmount = freezeAmount;
        }

        public int getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(int totalAmount) {
            this.totalAmount = totalAmount;
        }

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        public int getChildCount() {
            return childCount;
        }

        public void setChildCount(int childCount) {
            this.childCount = childCount;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getRequestCode() {
            return requestCode;
        }

        public void setRequestCode(String requestCode) {
            this.requestCode = requestCode;
        }
    }
}
