package vo;

import java.util.Date;

// 문의사항
public class BoardVo {
  private int SN; // 일련번호
  private String USERID; // 회원ID
  private String NAME; // 글 작성자
  private String PASS; // 글비밀번호
  private String SUBJECT; // 제목
  private String CONTENT; // 내용
  private int RE_REF; // 답변 글 작성 시 참조되는 글의 번호
  private int RE_LEV; // 답변 글의 깊이
  private int RE_SEQ; // 답변 글의 순서
  private int READCOUNT; // 글 조회수
  private Date RGS_DTM; // 등록일시
  private Date UPT_DTM; // 수정일시
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
