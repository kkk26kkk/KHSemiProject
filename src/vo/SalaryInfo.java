package vo;

import java.util.Date;

// 연봉 정보
public class SalaryInfo {
  private String GID; // 일반회원ID
  private int SN; // 일련번호
  private String ENAME; // 회사명
  private String CF; // 현전직장
  private String DUTY; // 직무
  private String INDUSTRY; // 산업
  private String JTYPE; // 고용형태
  private String RANK; // 직급
  private String CAREER; // 경력
  private String REGION; // 지역
  private int SAL; // 연봉
  private int INCENTIVE; // 성과급
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

  public String getRANK() {
    return RANK;
  }

  public void setRANK(String rANK) {
    RANK = rANK;
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

  public int getSAL() {
    return SAL;
  }

  public void setSAL(int sAL) {
    SAL = sAL;
  }

  public int getINCENTIVE() {
    return INCENTIVE;
  }

  public void setINCENTIVE(int iNCENTIVE) {
    INCENTIVE = iNCENTIVE;
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
