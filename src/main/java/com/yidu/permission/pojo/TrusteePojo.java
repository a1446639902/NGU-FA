package com.yidu.permission.pojo;

/**
 * @author cai
 */
public class TrusteePojo {
    //trusteeId	varchar2(50)	PK  托管人的ID
    //trusteeName	Varchar2(50)	托管人名字
    //trusteeAddress	Varchar2(100)	托管人地址
    //trusteeCompany	Varchar2(50)	托管公司
    //trusteePhone	Varchar2(50)	电话s
    //trusteeFee	number(16,2)	托管费率
    //trusteeDesc	Varchar2(100)	备注
    private String trusteeId;  //PK  托管人的ID
    private String trusteeName;  //托管人名字
    private String trusteeAddress;  //托管人地址
    private String trusteeCompany;  //托管公司
    private String trusteePhone;    //电话
    private double trusteeFee;  //托管费率
    private String trusteeDesc; //备注
}
