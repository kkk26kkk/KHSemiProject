package vo;

import java.util.Date;

// 기업 리뷰
public class EnterpriseReview {

  private String GID; // 일반회원ID
  private int SN; // 일련번호
  private String ENAME; // 회사명
  private String CF; // 현전직장
  private String DUTY; // 직무
  private String INDUSTRY; // 산업
  private String JTYPE; // 고용형태
  private String CAREER; // 경력
  private String REGION; // 지역
  private String THINK; // 한줄평
  private String ADV; // 장점
  private String DADV; // 단점
  private int POINT; // 별점
  private String STORY; // 못다한이야기
  private Date RGS_DTM; // 등록일시
  private Date UPT_DTM; // 수정일시

  public String getGID() {
    return GID;
  }

  public void setGID(String gID) {
    GID = gID;
  }

  public int getSN() {
    return SN;
  }

  public void setSN(int sN) {
    SN = sN;
  }

  public String getENAME() {
    return ENAME;
  }

  public void setENAME(String eNAME) {
    ENAME = eNAME;
  }

  public String getCF() {
    return CF;
  }

  public void setCF(String cF) {
    CF = cF;
  }

  public String getDUTY() {
    return DUTY;
  }

  public void setDUTY(String dUTY) {
    DUTY = dUTY;
  }

  public String getINDUSTRY() {
    return INDUSTRY;
  }

  public void setINDUSTRY(String iNDUSTRY) {
    INDUSTRY = iNDUSTRY;
  }

  public String getJTYPE() {
    return JTYPE;
  }

  public void setJTYPE(String jTYPE) {
    JTYPE = jTYPE;
  }

  public String getCAREER() {
    return CAREER;
  }

  public void setCAREER(String cAREER) {
    CAREER = cAREER;
  }

  public String getREGION() {
    return REGION;
  }

  public void setREGION(String rEGION) {
    REGION = rEGION;
  }

  public String getTHINK() {
    return THINK;
  }

  public void setTHINK(String tHINK) {
    THINK = tHINK;
  }

  public String getADV() {
    return ADV;
  }

  public void setADV(String aDV) {
    ADV = aDV;
  }

  public String getDADV() {
    return DADV;
  }

  public void setDADV(String dADV) {
    DADV = dADV;
  }

  public int getPOINT() {
    return POINT;
  }

  public void setPOINT(int pOINT) {
    POINT = pOINT;
  }

  public String getSTORY() {
    return STORY;
  }

  public void setSTORY(String sTORY) {
    STORY = sTORY;
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
