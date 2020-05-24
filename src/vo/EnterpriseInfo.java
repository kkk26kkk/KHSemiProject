package vo;

import java.util.Date;

// 기업 정보
public class EnterpriseInfo {
  private String EID; // 기업회원ID
  private String ENAME; // 기업명
  private String OWNERNAME; // 대표자명
  private String DOE; // 설립년도
  private String ETYPE; // 기업형태
  private String DUTY; // 직무
  private String INDUSTRY; // 산업
  private String ENUM; // 사원수
  private String EADDR; // 회사주소
  private String EADDR1; // 회사주소(도로명주소)
  private String EADDR2; // 회사주소(상세주소)
  private String PAGEADDR; // 홈페이지
  private String REVENUE; // 매출액
  private String LOGO; // 로고
  private Date RGS_DTM; // 등록일시
  private Date UPT_DTM; // 수정일시

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

  public String getOWNERNAME() {
    return OWNERNAME;
  }

  public void setOWNERNAME(String oWNERNAME) {
    OWNERNAME = oWNERNAME;
  }

  public String getDOE() {
    return DOE;
  }

  public void setDOE(String dOE) {
    DOE = dOE;
  }

  public String getETYPE() {
    return ETYPE;
  }

  public void setETYPE(String eTYPE) {
    ETYPE = eTYPE;
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

  public String getPAGEADDR() {
    return PAGEADDR;
  }

  public void setPAGEADDR(String pAGEADDR) {
    PAGEADDR = pAGEADDR;
  }

  public String getREVENUE() {
    return REVENUE;
  }

  public void setREVENUE(String rEVENUE) {
    REVENUE = rEVENUE;
  }

  public String getLOGO() {
    return LOGO;
  }

  public void setLOGO(String lOGO) {
    LOGO = lOGO;
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
