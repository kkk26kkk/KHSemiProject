package vo;

import java.util.Date;

// ���ȸ��
public class EnterpriseUser {
  private String EID; // ���ȸ��ID
  private String ENAME; // �����
  private String ENUM; // ����ڹ�ȣ
  private String EADDR; // ȸ���ּ�
  private String EADDR1; // ȸ���ּ�(���θ��ּ�)
  private String EADDR2; // ȸ���ּ�(���ּ�)
  private String OWNERNAME; // ��ǥ�ڸ�
  private Date RGS_DTM; // ����Ͻ�

  public String getEID() {
    return EID;
  }

  public void setEID(String eID) {
    EID = eID;
  }

  public String getENAME() {
    return ENAME;
  }

  public void setENAME(String eNAME) {
    ENAME = eNAME;
  }

  public String getENUM() {
    return ENUM;
  }

  public void setENUM(String eNUM) {
    ENUM = eNUM;
  }

  public String getEADDR() {
    return EADDR;
  }

  public void setEADDR(String eADDR) {
    EADDR = eADDR;
  }

  public String getEADDR1() {
    return EADDR1;
  }

  public void setEADDR1(String eADDR1) {
    EADDR1 = eADDR1;
  }

  public String getEADDR2() {
    return EADDR2;
  }

  public void setEADDR2(String eADDR2) {
    EADDR2 = eADDR2;
  }

  public String getOWNERNAME() {
    return OWNERNAME;
  }

  public void setOWNERNAME(String oWNERNAME) {
    OWNERNAME = oWNERNAME;
  }

  public Date getRGS_DTM() {
    return RGS_DTM;
  }

  public void setRGS_DTM(Date rGS_DTM) {
    RGS_DTM = rGS_DTM;
  }

  public Date getUPT_DTM() {
    return UPT_DTM;
  }

  public void setUPT_DTM(Date uPT_DTM) {
    UPT_DTM = uPT_DTM;
  }

  private Date UPT_DTM; // �����Ͻ�
}
