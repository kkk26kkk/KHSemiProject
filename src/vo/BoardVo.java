package vo;

import java.util.Date;

// ���ǻ���
public class BoardVo {
  private int SN; // �Ϸù�ȣ
  private String USERID; // ȸ��ID
  private String NAME; // �� �ۼ���
  private String PASS; // �ۺ�й�ȣ
  private String SUBJECT; // ����
  private String CONTENT; // ����
  private int RE_REF; // �亯 �� �ۼ� �� �����Ǵ� ���� ��ȣ
  private int RE_LEV; // �亯 ���� ����
  private int RE_SEQ; // �亯 ���� ����
  private int READCOUNT; // �� ��ȸ��
  private Date RGS_DTM; // ����Ͻ�
  private Date UPT_DTM; // �����Ͻ�
  private String FA_FILE;


  public String getFA_FILE() {
    return FA_FILE;
  }

  public void setFA_FILE(String fA_FILE) {
    FA_FILE = fA_FILE;
  }

  public int getSN() {
    return SN;
  }

  public void setSN(int sN) {
    SN = sN;
  }

  public String getUSERID() {
    return USERID;
  }

  public void setUSERID(String uSERID) {
    USERID = uSERID;
  }

  public String getNAME() {
    return NAME;
  }

  public void setNAME(String nAME) {
    NAME = nAME;
  }

  public String getPASS() {
    return PASS;
  }

  public void setPASS(String pASS) {
    PASS = pASS;
  }

  public String getSUBJECT() {
    return SUBJECT;
  }

  public void setSUBJECT(String sUBJECT) {
    SUBJECT = sUBJECT;
  }

  public String getCONTENT() {
    return CONTENT;
  }

  public void setCONTENT(String cONTENT) {
    CONTENT = cONTENT;
  }

  public int getRE_REF() {
    return RE_REF;
  }

  public void setRE_REF(int rE_REF) {
    RE_REF = rE_REF;
  }

  public int getRE_LEV() {
    return RE_LEV;
  }

  public void setRE_LEV(int rE_LEV) {
    RE_LEV = rE_LEV;
  }

  public int getRE_SEQ() {
    return RE_SEQ;
  }

  public void setRE_SEQ(int rE_SEQ) {
    RE_SEQ = rE_SEQ;
  }

  public int getREADCOUNT() {
    return READCOUNT;
  }

  public void setREADCOUNT(int rEADCOUNT) {
    READCOUNT = rEADCOUNT;
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

}
